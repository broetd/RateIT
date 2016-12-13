package ch.bbcag.RateITEJB;

import java.util.Collection;

import javax.ejb.Local;

import ch.bbc.rateit.model.Post;

@Local
public interface UploadBeanLocal {
	
	public String createPost(Post post);

	Collection<Post> getAllPost();
	 
	

}
