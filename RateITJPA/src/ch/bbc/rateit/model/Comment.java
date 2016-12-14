 package ch.bbc.rateit.model;

import java.io.Serializable;
import javax.persistence.Id;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the customer database table.
 * 
 */
@Named
@Entity
@NamedQueries({
       @NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c"),
       @NamedQuery(name="Comment.findByAuthorAnd", query ="SELECT u FROM User u WHERE u.username = :userName AND u.password = :userPW")
})
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idComment;
	private String author;
	private String message;
	private int Post_idPost;
	
	public Comment() {
	}
	
	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getPost_idPost() {
		return Post_idPost;
	}

	public void setPost_idPost(int post_idPost) {
		Post_idPost = post_idPost;
	}




}