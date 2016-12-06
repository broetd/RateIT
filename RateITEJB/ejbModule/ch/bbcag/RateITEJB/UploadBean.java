package ch.bbcag.RateITEJB;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.rateit.model.Post;
import ch.bbc.rateit.model.User;

@Stateless
public class UploadBean implements UploadBeanLocal {

	private final static Logger LOGGER = Logger.getLogger(RegisterBean.class.getName());

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public UploadBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String createPost(Post post) {
	
		User user = new User();
		try {
			em.persist(post);
		} catch (Exception e) {
			LOGGER.warning("User could not be registered: " + e);
		}
		LOGGER.info("User " + user.getUsername() + " has posted.");
		return "";
	}
}
