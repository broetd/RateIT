package ch.bbcag.RateITEJB;

import java.util.Collection;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.rateit.model.Post;

@Stateless
public class PostBean implements PostBeanLocal {

	private final static Logger LOGGER = Logger.getLogger(UserBean.class.getName());

	@PersistenceContext
	EntityManager em;
	
	/**
	 * Default constructor.
	 */
	public PostBean() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<Post> getAllPost() {
		return (Collection<Post>)em.createNamedQuery("Post.findAll").getResultList();
	}

	@Override
	public void deletePost(int idPost) {
		em.createNamedQuery("Post.deletePost")
		.setParameter("idPost",idPost).executeUpdate();
	}
	
	@Override
	public void ratePost(int addrating, int idPost) {
		em.createNamedQuery("Post.ratePost")
		.setParameter("rating",addrating)
		.setParameter("postID", idPost).executeUpdate();
	}
	
	@Override
	public String createPost(Post post) {
		try {
			em.persist(post);
		} catch (Exception e) {
			LOGGER.warning("User could not be registered: " + e);
		}
		LOGGER.info("User " + post.getAuthor() + " has posted.");
		return "";
	}
}
