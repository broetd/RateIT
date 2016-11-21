package ch.bbc.rateit.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.bbc.rateit.model.User;
import ch.bbcag.RateITEJB.RegisterBeanLocal;

@Named
@RequestScoped
public class RegisterController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private RegisterBeanLocal registerBean;
	
	@Inject
	private User user;

	public String save() {
		registerBean.save(user);
		return "";
	}

	public String login() {
		registerBean.login(user);
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
}
