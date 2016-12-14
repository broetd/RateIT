package ch.bbcag.RateITEJB;

import java.util.List;

import javax.ejb.Local;

import ch.bbc.rateit.model.User;

@Local
public interface UserBeanLocal {

	public String save(User u);

	public User login(User u);

	public List<User> getAllUser();

	void update(User user);

}
