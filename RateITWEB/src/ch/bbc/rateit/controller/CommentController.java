package ch.bbc.rateit.controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.bbc.rateit.model.Comment;
import ch.bbc.rateit.model.Post;
import ch.bbcag.RateITEJB.CommentBeanLocal;
import ch.bbcag.RateITEJB.PostBeanLocal;

@Named
@ViewScoped
public class CommentController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private CommentBeanLocal commentBean;

	@EJB
	private PostBeanLocal postBean;

	@Inject
	private Comment comment;

	private Collection<Comment> allCommentsOfPost;

	private Post originalPost;
	
	private int currentPostId;

	

	@Inject
	private UserController registerController;

	@PostConstruct
	public void init() {
		try {
			setAllCommentsOfPost(commentBean.getAllCommentsOfPost());
		} catch (Exception e) {
			e.printStackTrace();
			setAllCommentsOfPost(null);
		}
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String createComment(int postId) {
		originalPost = postBean.findById(postId);
		comment.setPost_idPost(postId);
		getComment().setAuthor(registerController.getUser().getUsername());
		 if (commentHasMessage()) {
		commentBean.createComment(getComment());
		return "index.jsf";
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

	public Post getOriginalPost() {
		return originalPost;
	}

	public void setOriginalPost(Post originalPost) {
		this.originalPost = originalPost;
	}

	public Collection<Comment> getAllCommentsOfPost() {
		return allCommentsOfPost;
	}

	public void setAllCommentsOfPost(Collection<Comment> allCommentsOfPost) {
		this.allCommentsOfPost = allCommentsOfPost;
	}

	public int getCurrentPostId() {
		return currentPostId;
	}

	public void setCurrentPostId(int currentPostId) {
		this.currentPostId = currentPostId;
	}
}
