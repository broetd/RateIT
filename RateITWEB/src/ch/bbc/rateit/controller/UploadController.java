//package ch.bbc.rateit.controller;
//
//import javax.ejb.EJB;
//import javax.inject.Inject;
//import javax.inject.Named;
//
//import ch.bbc.rateit.model.Post;
//import ch.bbcag.RateITEJB.UploadBeanLocal;
//
//@Named
//public class UploadController {
//	
//	@EJB
//	private UploadBeanLocal uploadBean;
//	
//	@Inject
//	private Post post;
//	
//	public Post getPost() {
//		return post;
//	}
//
//
//
//	public void setPost(Post post) {
//		this.post = post;
//	}
//
//
//
//	public String createPost() {
//		uploadBean.createPost(post);
//		return "";
//	}
//		
//}
