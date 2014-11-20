package fr.treeptik.tp.modelisation;


public class DVD extends LivreNumerique{
	//auteur, acteurs, durée, type (action, comédie, spectacle)
	private String auteur;
	private String acteurs;
	private String duree;
	private String type;
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getActeurs() {
		return acteurs;
	}
	public void setActeurs(String acteurs) {
		this.acteurs = acteurs;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
