package fr.treeptik.jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import fr.treeptik.dao.AnnonceDAO;
import fr.treeptik.model.Annonce;

public class JSOUPUtil {
	
	public static List<Annonce> getJsoup() {
		Document doc;
		Document doc2;
		List<Annonce> annonces= new ArrayList<Annonce>();
		try {
			doc = Jsoup.connect("http://www.leboncoin.fr/locations/offres/provence_alpes_cote_d_azur/?f=a&th=1").get();
			// get all links
			
			Elements links = doc.select("div.list-lbc a");
			for (Element link : links) {
				//System.out.println("titre de l'annonce : " + link.getElementsByClass("detail").text());
				String titre= link.getElementsByClass("detail").text();
				
				//System.out.println("url : " + link.attr("href"));
				String url = link.attr("href");

				doc2=Jsoup.connect(link.attr("href")).get();
				Elements lien = doc2.select("div.content");
				Integer prix = parseToInt(link.getElementsByClass("price").text());
				
				//System.out.println("description: "+lien.text());
				
				String description = lien.text();
				//System.out.println("prix: "+prix+"\n");
				Annonce annonce = new Annonce(null, titre, description, url, prix, null, null);
				annonces.add(annonce);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
return annonces;
	}
	public static Integer parseToInt(String chaine){
		chaine = chaine.replaceAll("€", " ");
		chaine = chaine.replaceAll(" ", "");
		chaine = chaine.replaceAll(" ", "").trim();
		chaine = chaine.substring(0,chaine.length()-1);
		int prix=Integer.parseInt(chaine);
		return prix; 
	}
}
