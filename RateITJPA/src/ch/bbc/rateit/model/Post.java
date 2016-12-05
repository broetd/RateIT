package ch.bbc.rateit.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPost;

	private String author;

	private float rating;

	public Post() {
		
	}
	
	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

}