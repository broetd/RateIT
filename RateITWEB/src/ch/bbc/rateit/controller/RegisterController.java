package ch.bbc.rateit.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import ch.bbc.rateit.model.User;
import ch.bbcag.RateITEJB.RegisterBeanLocal;

@Named
@SessionScoped
public class RegisterController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private RegisterBeanLocal registerBean;
	
	@Inject
	private User user;
	
	private boolean userLoggedIn = false;

	public String save() {
		registerBean.save(user);
		return "";
	}
	
	public void logout() {
		setUserLoggedIn(false);
	   ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
	}

	public String login() {
		if (registerBean.login(user) == true) {
			user.setUsername(user.getUsername());
			userLoggedIn = true;
		}else{
			userLoggedIn = false;
		}
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
