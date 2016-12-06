package ch.bbcag.RateITEJB;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.rateit.model.User;

@Stateless
public class RegisterBean implements RegisterBeanLocal {

	private final static Logger LOGGER = Logger.getLogger(RegisterBean.class.getName());

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public RegisterBean() {
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
	public boolean login(User user) {
		try {
			if (em.createNamedQuery("User.findByUsernameAndPassword").setParameter("userName", user.getUsername())
					.setParameter("userPW", user.getPassword()).getResultList().size() > 0) {
				LOGGER.info("User " + user.getUsername() + " successfully logged in.");
				return true;
			} else
				LOGGER.info("Username or password incorrect.");
			return false;
		} catch (Exception e) {
			LOGGER.warning("User could not be logged in: " + e);
			return false;
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