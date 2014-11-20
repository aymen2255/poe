package fr.treeptik.tp.modelisation;

public class CD {
//Titre, compositeur, nombre de chansons, durée, type (rock, classique, techno)
	private String titre;
	private String compositeur;
	private String nbrChanson;
	private String duree;
	private String type;
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getCompositeur() {
		return compositeur;
	}
	public void setCompositeur(String compositeur) {
		this.compositeur = compositeur;
	}
	public String getNbrChanson() {
		return nbrChanson;
	}
	public void setNbrChanson(String nbrChanson) {
		this.nbrChanson = nbrChanson;
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
