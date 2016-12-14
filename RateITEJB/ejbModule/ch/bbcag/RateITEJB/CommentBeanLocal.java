package ch.bbcag.RateITEJB;

import javax.ejb.Local;

import ch.bbc.rateit.model.Comment;

@Local
public interface CommentBeanLocal {
	
	public String createComment(Comment comment);
	 
	

}
