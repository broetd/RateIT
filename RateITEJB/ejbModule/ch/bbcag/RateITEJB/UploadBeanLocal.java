package ch.bbcag.RateITEJB;

import javax.ejb.Local;

import ch.bbc.rateit.model.Post;

@Local
public interface UploadBeanLocal {
	
	public String createPost(Post post);
	 
	

}
