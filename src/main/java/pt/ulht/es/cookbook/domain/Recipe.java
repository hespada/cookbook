package pt.ulht.es.cookbook.domain;

import java.util.Comparator;

public class Recipe {
	private String id;
	private String titulo;
	private String autor;
	private String problema;
	private String solucao;
	private String data;

	public Recipe(String titulo, String autor, String problema, String solucao, String data)
	{
		this.titulo = titulo;
		this.autor = autor;
		this.problema = problema;
		this.solucao = solucao;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public static class TituloComparator implements Comparator<Recipe> {
		public int compare(Recipe o1, Recipe o2) {
			return o1.titulo.compareTo(o2.titulo);
		}
	}
	
}
