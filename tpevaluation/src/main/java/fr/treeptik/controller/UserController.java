package fr.treeptik.controller;

import java.io.IOException;
import java.security.Principal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.treeptik.model.Stagiaire;
import fr.treeptik.model.User;
import fr.treeptik.service.UserService;
import fr.treeptik.serviceImpl.MailTest;

@ManagedBean(name = "userController")
@SessionScoped
public class UserController {
	private User user = new Stagiaire();
	@EJB
	UserService userService;
	

	// private List<User> users;
	private DataModel<User> users;
	private User editUser = new Stagiaire();
	String currentUser;

	public void setCurrentUser(String currentUser) {
		this.currentUser = currentUser;
	}

	public Principal getCurrentUser() {
		final Principal principal = FacesContext.getCurrentInstance()
				.getExternalContext().getUserPrincipal();
		if (null == principal) {
			return null;
		}

		return principal;
	}

	public User getEditUser() {
		return editUser;
	}

	public void setEditUser(User editUser) {
		this.editUser = editUser;
	}

	public String editerUser() {
		editUser = users.getRowData();
		return "edit";
	}

	public String updateUser() {
		userService.update(editUser);
		if (users == null) {
			users = new ListDataModel<User>();
			users.setWrappedData(userService.getAllUsers());
		}

		return "list";
	}
	HttpServletRequest req= (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	
	HttpServletResponse res=  (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	
	public String createUser(){
		userService.create(user);
		
		userService.sendMail(req, res, user);
		user = new Stagiaire();
		return "list";
	}

	public DataModel<User> getUsers() {

		
			users = new ListDataModel<User>();
			users.setWrappedData(userService.getAllUsers());
	
		return users;
	}

	public String deleteUser() {
		User user = users.getRowData();
		userService.delete(user);
		users.setWrappedData(userService.getAllUsers());
		return "list";
	}

	public void setUsers(DataModel<User> users) {
		this.users = users;
	}

	public String logout() {
	
		 FacesContext.getCurrentInstance().getExternalContext()
		 .invalidateSession();

		return "logout";

	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
