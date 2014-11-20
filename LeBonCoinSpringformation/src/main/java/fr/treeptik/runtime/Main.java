package fr.treeptik.runtime;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.treeptik.model.User;
import fr.treeptik.service.UserService;

public class Main {

	public static void main(String[] args) {
		createUser();

	}
	
	public static User createUser(){
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = context.getBean(UserService.class);
		User user= new User(null, "toto", 22, "toto", "toto", null);
		return service.create(user);
		
	}

}
