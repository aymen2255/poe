package fr.treeptik.leboncoinweb.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Annonce implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	@Type(type = "text")
	@JsonIgnore
	private String description;
	private String localisation;
	private String link;
	private Float price;
	private Integer count;
	
	public Annonce() {
		count = 0;
	}
	
	

	public Annonce(Integer id, String title, String description,
			String localisation, String link, Float price, Integer count) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.localisation = localisation;
		this.link = link;
		this.price = price;
		this.count = count;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Annonce [id=" + id + ", title=" + title + ", count=" + count
				+ "]";
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
	

}
