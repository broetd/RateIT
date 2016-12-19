package ch.bbc.rateit.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import ch.bbc.rateit.model.User;
import ch.bbcag.RateITEJB.UserBeanLocal;

@Named
@SessionScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UserBeanLocal registerBean;
	
	@Inject
	private User user;

	private boolean userLoggedIn = false;

	public String save() {
		registerBean.save(user);
		return "";
	}
	
	public String logout() {
		setUserLoggedIn(false);
	   ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
	   return "index.jsf";
	}

	public String login() {
		User loggedInUser = registerBean.login(user);
		if (loggedInUser != null) {
			user.setIdUser(loggedInUser.getIdUser());	
			userLoggedIn = true;
		}else{
			userLoggedIn = false;
			FacesContext saveContext = FacesContext.getCurrentInstance();
			saveContext.addMessage(null, new FacesMessage("Could not sign in User. Username or Password wrong!"));
		}
		return "";
	}
	
	public String update() {
		registerBean.update(user);
		return "";
	}
	
	public List<User> getAllUser() {
		List<User> user = registerBean.getAllUser();
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean isUserLoggedIn() {
		return userLoggedIn;
	}

	public void setUserLoggedIn(boolean isLoggedIn) {
		this.userLoggedIn = isLoggedIn;
	}
}
