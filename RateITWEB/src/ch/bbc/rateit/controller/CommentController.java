package ch.bbc.rateit.controller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ch.bbc.rateit.model.Comment;
import ch.bbc.rateit.model.Post;
import ch.bbcag.RateITEJB.CommentBeanLocal;

@Named
@SessionScoped
public class CommentController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private CommentBeanLocal commentBean;

	@Inject
	private Comment comment;

	private Post originalPost;

	private String commentText;

	@Inject
	private UserController registerController;
	
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String createComment() {
			comment.setMessage(commentText);
			comment.setPost_idPost(originalPost.getIdPost());
			getComment().setAuthor(registerController.getUser().getUsername());
			if (commentHasMessage()) {
			commentBean.createComment(getComment());
			return "";
		} else {
			FacesContext saveContext = FacesContext.getCurrentInstance();
			saveContext.addMessage(null, new FacesMessage("Could not create comment. Please try again."));
		}
		return "";
	}

	public boolean commentHasMessage() {
		if (comment.getMessage() == null || comment.getMessage().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Post getOriginalPost() {
		return originalPost;
	}

	public void setOriginalPost(Post originalPost) {
		this.originalPost = originalPost;
	}
}
