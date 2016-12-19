package ch.bbcag.RateITEJB;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.rateit.model.User;

@Stateless
public class UserBean implements UserBeanLocal {

	private final static Logger LOGGER = Logger.getLogger(UserBean.class.getName());

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String save(User user) {
		
		try {
			em.persist(user);
		} catch (Exception e) {
			LOGGER.warning("User could not be registered: " + e);
		}
		LOGGER.info("User " + user.getUsername() + " has been registered.");
		return "";
	}
	
	@Override 
	public void update(User user) {
		em.createNamedQuery("User.update")
		.setParameter("userName",user.getUsername())
		.setParameter("name", user.getName())
		.setParameter("surname", user.getSurname())
		.setParameter("userID", user.getIdUser()).executeUpdate();
		
	}

	@Override
	public User login(User user) {
		@SuppressWarnings("unchecked")
		List<User> userData = em.createNamedQuery("User.findByUsernameAndPassword").setParameter("userName", user.getUsername())
				.setParameter("userPW", user.getPassword()).getResultList();
		try {
			if (userData.size() > 0){
				LOGGER.info("User " + user.getUsername() + " successfully logged in.");
				return userData.get(0);
			} else
				LOGGER.info("Username or password incorrect.");
			return null;
		} catch (Exception e) {
			LOGGER.warning("User could not be logged in: " + e);
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
        List<User> user = em.createNamedQuery("User.findAll").getResultList();
        for (int i = 0; i < user.size(); i++) {
               User u = user.get(i);
        }
        return user;
  }


}