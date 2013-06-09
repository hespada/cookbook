package pt.ulht.es.cookbook.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pt.ist.fenixframework.pstm.AbstractDomainObject;
import pt.ulht.es.cookbook.domain.CookbookManager;
import pt.ulht.es.cookbook.domain.Recipe;

@Controller
public class RecipeController {
	
	//Criar receita - Formulário - GET
    @RequestMapping(method=RequestMethod.GET, value="/recipes/create")
    public String showRecipeCreateFrom(Model model) {
    	return "createRecipe";
    }
    
    //Criar receita - Formulário
    @RequestMapping(method=RequestMethod.POST, value="/recipes")
    public String createRecipe(Model model, @RequestParam Map<String, String> params) {
    	String titulo = params.get("titulo");
    	String autor = params.get("autor");
    	String problema = params.get("problema");
    	String solucao = params.get("solucao");
    	String data = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date());
    	String tags = params.get("tags");
    	Recipe recipe = new Recipe(titulo, autor, problema, solucao, data, tags);
    	return "redirect:/recipes/" + recipe.getOid();
    }
    
    //Listagem das receitas - as últimas receitas alteradas + Formulário de Pesquisa
    @RequestMapping(method=RequestMethod.GET, value="/recipes")
    public String listRecipes(Model model) {
		String str = "Não há receitas criadas!";
    	Date date = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance();
        model.addAttribute("currentTime", df.format(date));
    	List<Recipe> sortRecipes = new ArrayList <Recipe>(CookbookManager.getInstance().getRecipeSet());
    	Collections.sort(sortRecipes, new Recipe.TituloComparator());
    	List<Recipe> finalRecipes = new ArrayList<Recipe>();
    	for(int i=0; i < sortRecipes.size(); i++)
			if (((Recipe)sortRecipes.get(i)).getReceitaPai() == null) 
				finalRecipes.add((Recipe)sortRecipes.get(i)); 	
    	if (finalRecipes.isEmpty()) {
    		 model.addAttribute("message", str);
    		 return "listRecipes";
    	}
    	else {
        model.addAttribute("recipes", finalRecipes);
		return "listRecipes";
    	}
    }
        
    //Pesquisar receitas - POST
    @RequestMapping(method=RequestMethod.POST, value="/search")
    public String searchRecipe(Model model, @RequestParam Map<String, String> params) {
		String str = "Não foram encontradas receitas!";
    	String pesq = params.get("pesquisa");   	
    	List<Recipe> results = new ArrayList<Recipe>();
    	List<Recipe> sortRecipes = new ArrayList <Recipe>(CookbookManager.getInstance().getRecipeSet());
    	for (Iterator<Recipe> r = sortRecipes.iterator(); r.hasNext();) {
			Recipe recipe = (Recipe) r.next();
			if (recipe.getReceitaPai() == null) {
				if ((recipe.getTitulo().contains(pesq)) ||
					(recipe.getProblema().contains(pesq)) ||
					(recipe.getSolucao().contains(pesq)) ||
					(recipe.isInTags(pesq)))
					results.add(recipe);
			}
		}
    	if (results.isEmpty()) {
   		 model.addAttribute("message", str);
   		 return "searchRecipes";
   	}
   	else {
       model.addAttribute("recipes", results);
   	}
    	return "searchRecipes";
    }
        
    //Detalhe da receita + o histórico das modificações
    @RequestMapping(method=RequestMethod.GET, value="/recipes/{id}")
    public String detailedRecipe(Model model, @PathVariable String id) {
    	String str = "Não há receitas modificadas!";
    	Date date = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance();
        model.addAttribute("currentTime", df.format(date));
    	Recipe recipe = AbstractDomainObject.fromExternalId(id);
    	List<Recipe> sortRecipes = new ArrayList <Recipe>(CookbookManager.getInstance().getRecipeSet());
    	Collections.sort(sortRecipes, new Recipe.DataComparator());
    	List<Recipe> finalRecipes = new ArrayList<Recipe>();
    	for(int i=0; i < sortRecipes.size(); i++)
    		if (((Recipe)sortRecipes.get(i)).getReceitaPai() != null)
    			if (((Recipe)sortRecipes.get(i)).getReceitaPai().equals(id))
    				finalRecipes.add((Recipe)sortRecipes.get(i));
        model.addAttribute("recipes", finalRecipes);    
        if (finalRecipes.isEmpty()) {
          	model.addAttribute("recipe", recipe);
          	model.addAttribute("message", str);
          	return "detailedRecipe";
          	}       
      	if (recipe != null) {
      		model.addAttribute("recipe", recipe);
      		return "detailedRecipe";
      		} else {
      			return "recipeNotFound";
          	}
    }
    
    //Apagar uma receita
    @RequestMapping(method=RequestMethod.GET, value="/recipes/{id}/delete")
    public String deleteRecipe(@PathVariable String id) {
    	Recipe recipe = AbstractDomainObject.fromExternalId(id);
    	CookbookManager.getInstance().removeRecipe(recipe);
    	recipe.delete();    		
    	return "redirect:/recipes";
    }
    
    //Editar uma receita - Formulário - GET
    @RequestMapping(method=RequestMethod.GET, value="/recipes/{id}/update")
    public String updateRecipe(Model model, @PathVariable String id) {
    	Recipe recipe = AbstractDomainObject.fromExternalId(id);
    	if (recipe != null)
    	{
    		model.addAttribute("recipe", recipe);
    		return "updateRecipe";
    	}
    	else
    		return "recipeNotFound";
    }
    
    //Editar uma receita - POST
    @RequestMapping(method=RequestMethod.POST, value="/recipes/update")
    public String updateRecipe(Model model, @RequestParam Map<String, String> params) {
    	String receitaPai = params.get("id");
    	Recipe recipe = AbstractDomainObject.fromExternalId(receitaPai);
    	new Recipe(recipe.getTitulo(), recipe.getAutor(), recipe.getProblema(), recipe.getSolucao(), recipe.getData(), recipe.getTags(), receitaPai);
    	recipe.setAutor(params.get("autor"));
    	recipe.setData(new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date()));
    	recipe.setProblema(params.get("problema"));
    	recipe.setSolucao(params.get("solucao"));
    	recipe.setTags(params.get("tags"));
    	recipe.setTitulo(params.get("titulo"));
    	return "redirect:/recipes/" + receitaPai;
    }
   
}	
    	