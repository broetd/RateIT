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
		em.createNamedQuery("Comment.deleteComments").setParameter("idPost", idPost).executeUpdate();
		em.remove(em.find(Post.class, idPost));
	}
	
	@Override
	public void ratePost(int idPost) {
		Post tmpPost = (Post) em.createNamedQuery("Post.getPostByID")
		.setParameter("idPost", idPost).getResultList().get(0);
		
		tmpPost.setRating(tmpPost.getRating() + 1);
		
		em.createNamedQuery("Post.ratePost")
		.setParameter("rating", tmpPost.getRating())
		.setParameter("idPost", tmpPost.getIdPost()).executeUpdate();
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

	@Override
	public Post findById(int postId) {	
		return (Post) em.createNamedQuery("Post.getPostByID").setParameter("idPost", postId).setMaxResults(1).getResultList().get(0);
	}
}
