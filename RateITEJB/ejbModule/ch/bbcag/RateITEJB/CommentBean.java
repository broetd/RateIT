package ch.bbcag.RateITEJB;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.rateit.model.Comment;

@Stateless
@Named
public class CommentBean implements CommentBeanLocal {

	private final static Logger LOGGER = Logger.getLogger(UserBean.class.getName());

	@PersistenceContext
	EntityManager em;

	public CommentBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String createComment(Comment comment) {
		try {
			em.persist(comment);
		} catch (Exception e) {
			LOGGER.warning("Comment could not be posted" + e);
		}
		LOGGER.info("Comment from User" + comment.getAuthor() + " has been posted");
		return "";
	}
}