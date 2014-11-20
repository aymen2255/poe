package fr.treeptik.tp.modelisation;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private String nom;
	private String prenom;
	private Caddie caddie = new Caddie();
	private List<Commande> commandes = new ArrayList<Commande>();

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Caddie getCaddie() {
		return caddie;
	}

	public void setCaddie(Caddie caddie) {
		this.caddie = caddie;
	}

}
