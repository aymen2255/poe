package fr.treeptik.tp.modelisation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Caddie {

	private Client client = new Client();
	private List<Article> articles = new ArrayList<Article>();
	
	 
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
}
