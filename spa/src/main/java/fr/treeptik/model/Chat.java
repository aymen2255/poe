package fr.treeptik.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Chat extends Animal{
	@Id
	private Long id;
	
public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

private String couleur;

public String getCouleur() {
	return couleur;
}

public void setCouleur(String couleur) {
	this.couleur = couleur;
}

}
