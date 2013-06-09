package pt.ulht.es.cookbook.domain;

import java.util.Comparator;


public class Recipe extends Recipe_Base {
	
    public Recipe(String titulo, String autor, String problema, String solucao, String data, String tags) {
    	setTitulo(titulo);
    	setAutor(autor);
    	setProblema(problema);
    	setSolucao(solucao);
    	setData(data);
    	setTags(tags);
    	setCookbookManager (CookbookManager.getInstance());	
    }
    
	public void delete() {
		super.deleteDomainObject();
	}
	
	public static class TituloComparator implements Comparator<Recipe> {
		public int compare(Recipe o1, Recipe o2) {
			return o1.getTitulo().compareTo(o2.getTitulo());
		}
	}
	
	public static class DataComparator implements Comparator<Recipe> {
		public int compare(Recipe o1, Recipe o2) {
			return o1.getData().compareTo(o2.getData());
		}
	}	
    
}
