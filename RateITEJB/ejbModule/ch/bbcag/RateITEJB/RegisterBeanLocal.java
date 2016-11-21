package ch.bbcag.RateITEJB;

import java.util.List;

import javax.ejb.Local;

import ch.bbc.rateit.model.User;

@Local
public interface RegisterBeanLocal {
	
	public String save(User u);
	public String login(User u);
	public List<User> getAllUser();

}
