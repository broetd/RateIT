package ch.bbc.rateit.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

import ch.bbc.rateit.model.Post;
import ch.bbcag.RateITEJB.UploadBeanLocal;

@Named
@SessionScoped
public class UploadController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UploadBeanLocal uploadBean;

	@Inject
	private Post post;

	@Inject
	private RegisterController registerController;

	private boolean imageUploaded = false;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String createPost() {
		if (isImageUploaded() == true) {
			getPost().setAuthor(registerController.getUser().getUsername());
			uploadBean.createPost(getPost());
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

	public boolean isImageUploaded() {
		return imageUploaded;
	}

	public void setImageUploaded(boolean imageUploaded) {
		this.imageUploaded = imageUploaded;
	}
}
