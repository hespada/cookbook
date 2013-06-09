package pt.ulht.es.cookbook.domain;

import java.util.Comparator;


public class Recipe extends Recipe_Base {
	
	//Receita nova
    public Recipe(String titulo, String autor, String problema, String solucao, String data, String tags) {
    	setTitulo(titulo);
    	setAutor(autor);
    	setProblema(problema);
    	setSolucao(solucao);
    	setData(data);
    	setTags(tags);
    	setCookbookManager (CookbookManager.getInstance());	
    }

    //Receita modificada
    public Recipe(String titulo, String autor, String problema, String solucao, String data, String tags, String receitaPai) {
    	setTitulo(titulo);
    	setAutor(autor);
    	setProblema(problema);
    	setSolucao(solucao);
    	setData(data);
    	setTags(tags);
    	setReceitaPai(receitaPai);
    	setCookbookManager (CookbookManager.getInstance());	
    }
    
	public void delete() {
		super.deleteDomainObject();
	}
    
	//função que compara a lista de tags pela tag recebida
	public Boolean isInTags(String tag) {
		String[] arr = this.getTags().split(",");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].compareToIgnoreCase(tag) == 0)
				return true;
		}
		return false;
	}
	
	//função que compara as receitas por titulo
	public static class TituloComparator implements Comparator<Recipe> {
		public int compare(Recipe o1, Recipe o2) {
			return o1.getTitulo().compareTo(o2.getTitulo());
		}
	}
	
	//função que compara as receitas por data
	public static class DataComparator implements Comparator<Recipe> {
		public int compare(Recipe o1, Recipe o2) {
			return o1.getData().compareTo(o2.getData());
		}
	}
	
    
}
