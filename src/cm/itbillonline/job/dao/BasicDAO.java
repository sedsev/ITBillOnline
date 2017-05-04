/**
 * 
 */
package cm.itbillonline.job.dao;

import java.util.List;

import cm.itbillonline.job.beans.Basic;

/**
 * @author donald
 *
 */
public interface BasicDAO {
	
	public void save(Basic basic);
	public List<Basic> findAll();
	public Basic findById(long id);
	public void merge(Basic basic);
	public void remove(long id);

}
