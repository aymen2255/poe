package fr.treeptik.tp.modelisation;

import java.util.ArrayList;
import java.util.List;

public class Commande {
	private List<Article> articles = new ArrayList<Article>();
	private Client client = new Client();
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
