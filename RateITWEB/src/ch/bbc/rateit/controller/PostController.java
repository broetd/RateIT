package ch.bbc.rateit.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.rating.Rating;
import org.primefaces.event.FileUploadEvent;

import ch.bbc.rateit.model.Post;
import ch.bbc.rateit.model.User;
import ch.bbcag.RateITEJB.PostBeanLocal;

@Named
@SessionScoped
public class PostController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private PostBeanLocal postBean;

	@Inject
	private Post post;

	@Inject
	private UserController registerController;

	@Inject
	private User user;

	private Collection<Post> allPosts;

	private boolean imageUploaded = false;

	private String imgpath;

	@PostConstruct
	public void init() {
		try {
			setAllPosts(postBean.getAllPost());
		} catch (Exception e) {
			e.printStackTrace();
			setAllPosts(null);
		}
	}
	
	public String ratePost(int idPost) {
		post.setRating(addRating());
		postBean.ratePost(addRating(), idPost);
		return "";
	}
	
	public int addRating() {
		int amountLikes = 0;
		amountLikes = post.getRating() + 1;
		return amountLikes;
		
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String deletePost(int idPost) {
		postBean.deletePost(idPost);

		return "";
	}

	
	
	public String createPost() {
		if (isImageUploaded() == true) {
			getPost().setAuthor(registerController.getUser().getUsername());
			postBean.createPost(getPost());
			return "";
		} else {
			FacesContext saveContext = FacesContext.getCurrentInstance();
			saveContext.addMessage(null, new FacesMessage("Could not create Post. Please upload a picture."));
		}
		return "";
	}

	

	public int countFilesInDirectory() {
		File f = new File("D:\\Users\\zsoedj\\workspace\\RateITWEB\\WebContent\\img\\post");
		int count = 1;
		for (File file : f.listFiles()) {
			if (file.isFile()) {
				count++;
			}
		}

		return count++;

	}

	public String handleFileUpload(FileUploadEvent event) {
		try {
			InputStream inputStream = event.getFile().getInputstream();
			File uploads = new File("D:\\Users\\zsoedj\\workspace\\RateITWEB\\WebContent\\img\\post");
			File file = new File(uploads, countFilesInDirectory() + ".png");
			setImageUploaded(true);
			Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public String getImgpath(Post post) {
		imgpath = "img\\post\\" + post.getIdPost() + ".png";
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

	public boolean isImageUploaded() {
		return imageUploaded;
	}

	public void setImageUploaded(boolean imageUploaded) {
		this.imageUploaded = imageUploaded;
	}

	public Collection<Post> getAllPosts() {
		return allPosts;
	}

	public void setAllPosts(Collection<Post> allPosts) {
		this.allPosts = allPosts;
	}

}
