package fr.treeptik.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Annonce {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String titre;
	private String description;
	private String link;
	private Integer prix;
	private Integer count;
	@ManyToMany(mappedBy="annonces")
	private List<User> users;

	public Annonce() {
		super();
	}



	public Annonce(Integer id, String titre, String description, String link,
			Integer prix, Integer count, List<User> users) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.link = link;
		this.prix = prix;
		this.count = count;
		this.users = users;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public Integer getCount() {
		return count;
	}



	public void setCount(Integer count) {
		this.count = count;
	}

}
