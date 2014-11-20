package fr.treeptik.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.treeptik.model.Administrateur;
import fr.treeptik.service.UserService;

@ManagedBean(name = "adminController")
@RequestScoped
public class AdminController {
	private Administrateur admin = new Administrateur();
	@EJB
	UserService userService;
}
