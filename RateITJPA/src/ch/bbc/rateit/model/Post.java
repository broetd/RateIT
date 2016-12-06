package ch.bbc.rateit.model;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.*;

/**
 * The persistent class for the item database table.
 * 
 */
@Named
@Entity
@NamedQueries({
	@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p"),
    @NamedQuery(name="Post.findByAuthorAndTitel", query ="SELECT p FROM Post p WHERE p.author = :author AND p.titel = :titel")
})


public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPost;

	private String titel;

	private String author;

	private float rating;
	
	private String text;

	public Post() {
		
	}
	
	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}
	
	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}