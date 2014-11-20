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
import javax.persistence.ManyToMany;
@Entity
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String login;
	private String password;
	private Integer age;
	@ManyToMany
	 @JoinTable(name="User_Annonce",joinColumns={@JoinColumn(name="User_id")}, inverseJoinColumns={@JoinColumn(name="Annonce_id")})
	private List<Annonce> annonces;
	public User() {
		annonces = new ArrayList<Annonce>();
	}
	
	

	public User(Integer id, String name, String login, String password,
			Integer age, List<Annonce> annonces) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.age = age;
		this.annonces = annonces;
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



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public List<Annonce> getAnnonces() {
		return annonces;
	}
	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", login=" + login
				+ ", age=" + age + "]";
	}
	

}
