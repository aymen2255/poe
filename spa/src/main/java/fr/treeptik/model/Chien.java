package fr.treeptik.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Chien extends Animal{
	@Id
	private Long id;
	private String pedigree;

	public String getPedigree() {
		return pedigree;
	}

	public void setPedigree(String pedigree) {
		this.pedigree = pedigree;
	}

}
