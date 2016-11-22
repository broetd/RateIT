 package ch.bbc.rateit.model;

import java.io.Serializable;

//import javax.inject.Named;
//import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;


/**
 * The persistent class for the customer database table.
 * 
 */
//@Named
//@Entity
//@NamedQueries({
//       @NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
//       @NamedQuery(name="User.findByUsernameAndPassword", query ="SELECT u FROM User u WHERE u.username = :userName AND u.password = :userPW")
//})

public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idComment;
	private String author;
	private String message;
	
	
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




}