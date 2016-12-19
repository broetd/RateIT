package ch.bbcag.RateITEJB;

import java.util.Collection;

import javax.ejb.Local;

import ch.bbc.rateit.model.Comment;
import ch.bbc.rateit.model.Post;

@Local
public interface CommentBeanLocal {
	
	public String createComment(Comment comment);

	public Post findById(int postId);

	public Collection<Comment> getAllCommentsOfPost();
	 
	

}
