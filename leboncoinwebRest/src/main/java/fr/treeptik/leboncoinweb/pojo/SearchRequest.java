package fr.treeptik.leboncoinweb.pojo;

public class SearchRequest {

	private String description;
	private String localisation;
	private Float prixMin;
	private Float prixMax;

	public SearchRequest() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public Float getPrixMin() {
		return prixMin;
	}

	public void setPrixMin(Float prixMin) {
		this.prixMin = prixMin;
	}

	public Float getPrixMax() {
		return prixMax;
	}

	public void setPrixMax(Float prixMax) {
		this.prixMax = prixMax;
	}

	@Override
	public String toString() {
		return "SearchRequest [description=" + description + ", localisation="
				+ localisation + ", prixMin=" + getPrixMin() + ", prixMax="
				+ getPrixMax() + "]";
	}

}
