/**
 * 
 */
package cm.itbillonline.job.dao;

import java.util.List;

import cm.itbillonline.job.beans.Comment;

/**
 * @author donald
 *
 */
public interface CommentDAO {
	
	public void save(Comment comment);
	public List<Comment> findAll();
	public Comment findById(long id);
	public void merge(Comment comment);
	public void remove(long id);

}
