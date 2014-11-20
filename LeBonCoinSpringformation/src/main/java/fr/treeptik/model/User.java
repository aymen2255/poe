package fr.treeptik.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nom;
	private Integer age;
	private String login;
	private String password;
	@ManyToMany
	private List<Annonce> annonces;

	public User() {
		super();
	}

	public User(Integer id, String nom, Integer age, String login,
			String password, List<Annonce> annonces) {
		super();
		this.id = id;
		this.nom = nom;
		this.age = age;
		this.login = login;
		this.password = password;
		this.annonces = annonces;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}

}
