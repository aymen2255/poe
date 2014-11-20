package fr.treeptik.runtime;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.treeptik.jsoup.JSOUPUtil;
import fr.treeptik.model.Annonce;
import fr.treeptik.model.User;
import fr.treeptik.service.AnnonceService;
import fr.treeptik.service.UserService;

public class Main {

	public static void main(String[] args) {
		//createUser();
		//findUserById(1);
		//findAllAnnonces();
		//importAndSaveAnnonces();

	}

	public static User createUser() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserService service = context.getBean(UserService.class);
		User user = new User(null, "toto", 22, "toto", "toto", null);
		return service.create(user);

	}
	public static User findUserById(Integer id){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		UserService service = context.getBean(UserService.class);
		User user = service.findById(id);
		System.out.println(user.getNom());
		return user;
	}
	public static List<Annonce> findAllAnnonces(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		AnnonceService annonceService = context.getBean(AnnonceService.class);
		List<Annonce> allAnnonces = annonceService.findAllAnnonces();
		for (Annonce annonce : allAnnonces) {
			System.out.println(annonce.getTitre());
			
		}
		return allAnnonces;
		
	}
	public static void importAndSaveAnnonces(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		AnnonceService annonceService = context.getBean(AnnonceService.class);
		annonceService.importAndSaveAnnonces();
	}

}
