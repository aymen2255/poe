package fr.treeptik.leboncoinweb.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
@Entity
public class Region implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nom;
	private String url;
	@OneToMany
	@JoinTable(name="Region_Annonce",joinColumns={@JoinColumn(name="Region_id")}, inverseJoinColumns={@JoinColumn(name="Annonce_id")})
	private List<Annonce> annonces;
	public Region() {
		annonces = new ArrayList<Annonce>();
	}
	

	public Region(Integer id, String nom, String url, List<Annonce> annonces) {
		super();
		this.id = id;
		this.nom = nom;
		this.url = url;
		this.annonces = annonces;
	}


	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Annonce> getAnnonces() {
		return annonces;
	}
	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}


	@Override
	public String toString() {
		return "Region [id=" + id + ", nom=" + nom + ", url=" + url + "]";
	}
	

}
