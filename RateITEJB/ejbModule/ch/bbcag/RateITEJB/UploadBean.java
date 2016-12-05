//package ch.bbcag.RateITEJB;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.file.Files;
//import java.nio.file.StandardCopyOption;
//import java.util.logging.Logger;
//
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//
//import ch.bbc.rateit.model.Post;
//
//@Stateless
//public class UploadBean implements UploadBeanLocal {
//
//	private final static Logger LOGGER = Logger.getLogger(UploadBean.class.getName());
//
//	@PersistenceContext
//	EntityManager em;
//
//	/**
//	 * Default constructor.
//	 */
//	public UploadBean() {
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public String createPost(Post post) {
//		
//		try {
//			em.persist(post);
//		} catch (Exception e) {
//			LOGGER.warning("Could not create Post: " + e);
//		}
//		LOGGER.info("Post has been created.");
//		return "";
//	}
//	
//	public void handleFileUpload(FileUploadEvent event) {
//        try {
//               InputStream inputStream = event.getFile().getInputstream();
//               File uploads = new File("D:\\Users\\zniedl\\Rotten-Gold\\RottenGold_WEB\\WebContent\\img\\profileImg");
//               File file = new File(uploads, user.getUsername() + ".png");
//
//               Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//               // TODO Auto-generated catch block
//               e.printStackTrace();
//        }
//
//  }
//
//}