package pt.ulht.es.cookbook.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
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
	
	//Criar Receita - Formulário
    @RequestMapping(method=RequestMethod.GET, value="/recipes/create")
    public String showRecipeCreateFrom(Model model) {
    	return "createRecipe";
    }
    
    //Criar Receita - POST do formulário
    @RequestMapping(method=RequestMethod.POST, value="/recipes")
    public String createRecipe(Model model, @RequestParam Map<String, String> params) {
    	String titulo = params.get("titulo");
    	String autor = params.get("autor");
    	String problema = params.get("problema");
    	String solucao = params.get("solucao");
    	String data = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date());
    	String tags = params.get("tags");
    	Recipe recipe = new Recipe(titulo, autor, problema, solucao, data, tags);
    	//CookbookManager.saveRecipe(recipe);
    	return "redirect:/recipes/" + recipe.getOid();
    }
    
    //Listagem das Receitas
    @RequestMapping(method=RequestMethod.GET, value="/recipes")
    public String listRecipes(Model model) {
    	Date date = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance();
        model.addAttribute("currentTime", df.format(date));
    	//Set<Recipe> recipes = CookbookManager.getInstance().getRecipeSet();
    	List<Recipe> sortRecipes = new ArrayList <Recipe>(CookbookManager.getInstance().getRecipeSet());
    	Collections.sort(sortRecipes, new Recipe.TituloComparator());
        model.addAttribute("sortRecipes", sortRecipes);
		return "listRecipes";
    	}   
    
    //Detalhe da Receita
    @RequestMapping(method=RequestMethod.GET, value="/recipes/{id}")
    public String detailedRecipe(Model model, @PathVariable String id) {
    	Date date = new Date(System.currentTimeMillis());
        DateFormat df = DateFormat.getDateInstance();
        model.addAttribute("currentTime", df.format(date));
    	Recipe recipe = AbstractDomainObject.fromExternalId(id);
      	if (recipe != null) {
      		model.addAttribute("recipe", recipe);
      		return "detailedRecipe";
      		} else {
      			return "recipeNotFound";
      			}
      	}   

    //Apagar Receita
    @RequestMapping(method=RequestMethod.GET, value="/recipes/{id}/delete")
    public String deleteRecipe(@PathVariable String id) {
    	Recipe recipe = AbstractDomainObject.fromExternalId(id);
    	CookbookManager.getInstance().removeRecipe(recipe);
    	recipe.delete();    		
    	return "redirect:/recipes";
    }

}	
    	