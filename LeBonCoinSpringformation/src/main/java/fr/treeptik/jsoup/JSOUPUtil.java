package fr.treeptik.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSOUPUtil {
	public static void getJsoup() {
		Document doc;
		Document doc2;
		try {
			doc = Jsoup.connect("http://www.leboncoin.fr/locations/offres/provence_alpes_cote_d_azur/?f=a&th=1").get();
			// get all links
			
			Elements links = doc.select("div.list-lbc a");
			for (Element link : links) {
				System.out.println("titre de l'annonce : " + link.getElementsByClass("detail").text());
				doc2=Jsoup.connect(link.attr("href")).get();
				Elements lien = doc2.select("div.content");
				Integer prix = parseToInt(link.getElementsByClass("price").text());
				System.out.println("description: "+lien.text());
				System.out.println("prix: "+prix+"\n");

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static Integer parseToInt(String chaine){
		chaine = chaine.replaceAll("€", " ");
		chaine = chaine.replaceAll(" ", "");
		chaine = chaine.replaceAll(" ", "");
		chaine = chaine.substring(0,chaine.length()-1);
		int prix=Integer.parseInt(chaine);
		return prix; 
	}
}
