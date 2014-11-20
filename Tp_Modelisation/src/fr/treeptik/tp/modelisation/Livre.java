package fr.treeptik.tp.modelisation;

public class Livre extends Article{
	protected String titre;
	protected String auteur;
	protected int nbrPage;
	protected int isbn;
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public int getNbrPage() {
		return nbrPage;
	}
	public void setNbrPage(int nbrPage) {
		this.nbrPage = nbrPage;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
}
