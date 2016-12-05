package ch.bbc.rateit.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

import ch.bbc.rateit.model.Post;
import ch.bbc.rateit.model.User;


@Named
public class UploadController {


	@Inject
	private Post post;
	
	User user = new User();


	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}


	public void handleFileUpload(FileUploadEvent event) {
        try {
               InputStream inputStream = event.getFile().getInputstream();
               File uploads = new File("D:\\Users\\zsoedj\\workspace\\RateITWEB\\WebContent\\img\\post");
               File file = new File(uploads, post.getIdPost() + ".png");

               Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
        }
		
	}
}
