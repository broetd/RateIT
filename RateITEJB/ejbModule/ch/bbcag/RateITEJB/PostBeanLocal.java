package ch.bbcag.RateITEJB;

import java.util.Collection;

import javax.ejb.Local;

import ch.bbc.rateit.model.Post;

@Local
public interface PostBeanLocal {
	
	public String createPost(Post post);

	Collection<Post> getAllPost();

	void deletePost(int idPost);

	void ratePost(int idPost);

	public Post findById(int postId);
	 
	

}
