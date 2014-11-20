package fr.treeptik.leboncoinweb.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import fr.treeptik.leboncoinweb.pojo.Annonce;
import fr.treeptik.leboncoinweb.pojo.Region;

public abstract class JSoupUtils {

	public static List<Annonce> getAnnoncesFromWeb(Integer nbResultats)
			throws IOException {
		List<Annonce> liste = new ArrayList<Annonce>();
		Integer resultatParPage = 35, nbPage = (int) Math.ceil((nbResultats
				.doubleValue() / resultatParPage));
		Integer i = 0;
		// Document doc =
		// Jsoup.connect("http://www.leboncoin.fr/locations/offres/provence_alpes_cote_d_azur/?o="+page).get();
		// Elements elements = doc.select(".list-lbc a[href]");
		for (int j = 1; j <= nbPage; j++) {
			Document doc = Jsoup.connect(
					"http://www.leboncoin.fr/locations/offres/provence_alpes_cote_d_azur/?o="
							+ j).get();
			Elements elements = doc.select(".list-lbc a[href]");
			for (Element element : elements) {
				i++;
				// System.out.println("Valeur de i : "+i);
				if (i > nbResultats) {
					System.out.println("Break");
					break;
				}
				Annonce a = new Annonce();
				a.setTitle(element.attr("title"));
				String prix = element.select(".price").text();
				if (prix.length() > 2) {
					prix = prix.substring(0, prix.length() - 2)
							.replace(" ", "");
				} else {
					prix = "0";
				}
				// System.out.print("Prix : "+prix);
				// System.out.println(" - "+prix.substring(0,
				// prix.length()-2).replace(" ", ""));
				a.setPrice(Float.valueOf(prix));
				a.setLocalisation(element.select(".placement").text());
				a.setLink(element.attr("href"));
				Document docE;
				try {
					docE = Jsoup.connect(element.attr("href")).get();
					Elements elements2 = docE.select(".content");
					Element element2 = elements2.get(0);
					String str = element2.text();
					a.setDescription(str);
					liste.add(a);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// elements.forEach(element->{
		//
		//
		// });
		// for (Element element : elements) {
		// Annonce a = new Annonce();
		// a.setTitle(element.attr("title"));
		// a.setPrice(Float.valueOf(element.select(".price").text().substring(0,
		// element.select(".price").text().length()-2).replace(" ", "")));
		// a.setLink(element.attr("href"));
		// // System.out.println(element.attr("href"));
		// // System.out.println(element.attr("title"));
		// // System.out.println(element.select(".price").text());
		// // System.out.println(element.select(".price").text().substring(0,
		// element.select(".price").text().length()-1));
		// Document docE = Jsoup.connect(element.attr("href")).get();
		// Elements elements2 = docE.select(".content");
		// Element element2 = elements2.get(0);
		// // System.out.println(element2.text());
		// String str =element2.text();
		// // if(str.length()>250){
		// // str = str.substring(0, 245);
		// // }
		// a.setDescription(str);
		// liste.add(a);
		// }
		return liste;

	}

	public static List<Annonce> getAnnoncesFromWebJ8(Integer nbResultats)
			throws IOException {
		List<Annonce> liste = new ArrayList<Annonce>();
		Integer resultatParPage = 35, nbPage = (int) Math.ceil((nbResultats
				.doubleValue() / resultatParPage));
//		Integer i = 0;
		for (int j = 1; j <= nbPage; j++) {
			Document doc = Jsoup.connect(
					"http://www.leboncoin.fr/locations/offres/provence_alpes_cote_d_azur/?o="
							+ j).get();
//			Elements elements = doc.select(".list-lbc a[href]");
			if (j == nbPage) {
				Stream<Annonce> map = doc
						.select(".list-lbc a[href]")
						.parallelStream()
						.map(el -> el.getAllElements())
						.map(el -> {
							Annonce a = new Annonce();
							a.setTitle(el.attr("title"));
							String prix = el.select(".price").text();
							if (prix.length() > 2) {
								prix = prix.substring(0, prix.length() - 2)
										.replace(" ", "");
							} else {
								prix = "0";
							}
							a.setPrice(Float.valueOf(prix));
							a.setLocalisation(el.select(".placement").text());
							a.setLink(el.attr("href"));
							Document docE;
							try {
								docE = Jsoup.connect(el.attr("href")).get();
								Elements elements2 = docE.select(".content");
								Element element2 = elements2.get(0);
								String str = element2.text();
								a.setDescription(str);
								liste.add(a);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return a;
						}).limit(nbResultats % resultatParPage);
				liste.addAll(map.collect(Collectors.toList()));
			} else {
				Stream<Annonce> map = doc
						.select(".list-lbc a[href]")
						.parallelStream()
						.map(el -> el.getAllElements())
						.map(el -> {
							Annonce a = new Annonce();
							a.setTitle(el.attr("title"));
							String prix = el.select(".price").text();
							if (prix.length() > 2) {
								prix = prix.substring(0, prix.length() - 2)
										.replace(" ", "");
							} else {
								prix = "0";
							}
							a.setPrice(Float.valueOf(prix));
							a.setLocalisation(el.select(".placement").text());
							a.setLink(el.attr("href"));
							Document docE;
							try {
								docE = Jsoup.connect(el.attr("href")).get();
								Elements elements2 = docE.select(".content");
								Element element2 = elements2.get(0);
								String str = element2.text();
								a.setDescription(str);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return a;
						});
				liste.addAll(map.collect(Collectors.toList()));
			}

		}

		return liste;

	}

	public static List<Region> getAnnoncesFromWebJ8Region() throws IOException {
		Integer nbResultats = 5;
		Integer limit = 35;
		List<Region> regions = new ArrayList<Region>();
//		List<Annonce> liste = new ArrayList<Annonce>();
		Integer resultatParPage = 35, nbPage = (int) Math.ceil((nbResultats
				.doubleValue() / resultatParPage));
		Region r1 = new Region(
				null,
				"PACA",
				"http://www.leboncoin.fr/locations/offres/provence_alpes_cote_d_azur/?o=",
				null);
		Region r2 = new Region(null, "Alsace", "http://www.leboncoin.fr/locations/offres/alsace/?o=", null);
		Region r3 = new Region(null, "Aquitaine", "http://www.leboncoin.fr/locations/offres/aquitaine/?o=", null);
		Region r4 = new Region(null, "Auvergne", "http://www.leboncoin.fr/locations/offres/auvergne/?o=", null);
		Region r5 = new Region(null, "Basse-Normandie", "http://www.leboncoin.fr/locations/offres/basse_normandie/?o=", null);
		Region r6 = new Region(null, "Bourgogne", "http://www.leboncoin.fr/locations/offres/bourgogne/?o=", null);
		Region r7 = new Region(null, "Bretagne", "http://www.leboncoin.fr/locations/offres/bretagne/?o=", null);
		Region r8 = new Region(null, "Centre", "http://www.leboncoin.fr/locations/offres/centre/?o=", null);
		Region r9 = new Region(null, "Champagne-Ardenne", "http://www.leboncoin.fr/locations/offres/champagne_ardenne/?o=", null);
		Region r10 = new Region(null, "Corse", "http://www.leboncoin.fr/locations/offres/corse/?o=", null);
		Region r11 = new Region(null, "Franche-Comté", "http://www.leboncoin.fr/locations/offres/franche_comte/?o=", null);
		Region r12 = new Region(null, "Haute-Normandie", "http://www.leboncoin.fr/locations/offres/haute_normandie/?o=", null);
		Region r13 = new Region(null, "Ile-de-France", "http://www.leboncoin.fr/locations/offres/ile_de_france/?o=", null);
		Region r14 = new Region(null, "Languedoc-Roussillon", "http://www.leboncoin.fr/locations/offres/languedoc_roussillon/?o=", null);
		Region r15 = new Region(null, "Limousin", "http://www.leboncoin.fr/locations/offres/limousin/?o=", null);
		Region r16 = new Region(null, "Lorraine", "http://www.leboncoin.fr/locations/offres/lorraine/?o=", null);
		Region r17 = new Region(null, "Midi-Pyrénées", "http://www.leboncoin.fr/locations/offres/midi_pyrenees/?o=", null);
		Region r18 = new Region(null, "Nord-Pas-de-Calais", "http://www.leboncoin.fr/locations/offres/nord_pas_de_calais/?o=", null);
		Region r19 = new Region(null, "Pays de la Loire", "http://www.leboncoin.fr/locations/offres/pays_de_la_loire/?o=", null);
		Region r20 = new Region(null, "Picardie", "http://www.leboncoin.fr/locations/offres/picardie/?o=", null);
		Region r21 = new Region(null, "Poitou-Charentes", "http://www.leboncoin.fr/locations/offres/poitou_charentes/?o=", null);
		Region r22 = new Region(null, "Rhône-Alpes", "http://www.leboncoin.fr/locations/offres/rhone_alpes/?o=", null);

		//		regions.addAll(Arrays.asList(r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22));
		
		regions.addAll(Arrays.asList(r1,r2,r3,r4,r5));
		
		for (Region region : regions) {
			List<Annonce> liste = new ArrayList<Annonce>();
			for (int j = 1; j <= nbPage; j++) {
				System.out.println("Region "+region.getNom()+" page "+j);
				if(j==nbPage){
					limit = nbResultats%resultatParPage;
					if(limit==0){
						limit = 35;
					}
				}else{
					limit = 35;
				}
				Document doc = Jsoup.connect(region.getUrl() + j).get();
//				Elements elements = doc.select(".list-lbc a[href]");

				Stream<Annonce> map = doc
						.select(".list-lbc a[href]")
						.parallelStream().limit(limit)
						.map(el -> el.getAllElements())
						.map(el -> {
							Annonce a = new Annonce();
							a.setTitle(el.attr("title"));
							String prix = el.select(".price").text();
							if (prix.length() > 2) {
								prix = prix.substring(0, prix.length() - 2)
										.replace(" ", "");
							} else {
								prix = "0";
							}
							a.setPrice(Float.valueOf(prix));
							a.setLocalisation(el.select(".placement").text());
							a.setLink(el.attr("href"));
							Document docE;
							try {
								docE = Jsoup.connect(el.attr("href")).get();
								Elements elements2 = docE.select(".content");
								Element element2 = elements2.get(0);
								String str = element2.text();
								a.setDescription(str);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return a;
						});

				liste.addAll(map.collect(Collectors.toList()));

			}
			region.setAnnonces(liste);
		}

		return regions;

	}

}
