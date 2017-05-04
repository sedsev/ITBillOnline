/**
 * 
 */
package cm.itbillonline.job.dao;

import java.util.List;

import cm.itbillonline.job.beans.External;

/**
 * @author donald
 *
 */
public interface ExternalDAO {
	
	public void save(External external);
	public List<External> findAll();
	public External findById(long id);
	public void merge(External external);
	public void remove(long id);
}
