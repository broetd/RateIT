package ch.bbc.rateit.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

import com.sun.media.jfxmedia.logging.Logger;

import ch.bbc.rateit.model.Post;
import ch.bbc.rateit.model.User;
import ch.bbcag.RateITEJB.UploadBeanLocal;


@Named
public class UploadController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private UploadBeanLocal uploadBean;

	@Inject
	private Post post;
	
	User user = new User();


	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	public String createPost() {
		
//		RegisterController registerController = new RegisterController();
		
//		if(registerController.isUserLoggedIn == true()) {
			uploadBean.createPost(post);
			return "";
//		} else {
//			LOGGER.warning("User not logged in!");
		}
		
	


	public void handleFileUpload(FileUploadEvent event) {
        try {
               InputStream inputStream = event.getFile().getInputstream();
               File uploads = new File("D:\\Users\\zsoedj\\workspace\\RateITWEB\\WebContent\\img\\post");
               File file = new File(uploads, post.getTitel() + ".png");

               Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        }
		
	}
}
