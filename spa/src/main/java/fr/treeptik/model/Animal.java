package fr.treeptik.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Animal {
	@Id
	
private Long id;
private String nom;
private Integer age;
public Long getId() {
	return id;
}
public void setId(Long id) {
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


}
