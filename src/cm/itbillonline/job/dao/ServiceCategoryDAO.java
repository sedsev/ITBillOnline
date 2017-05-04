/**
 * 
 */
package cm.itbillonline.job.dao;

import java.util.List;

import cm.itbillonline.job.beans.ServiceCategory;

/**
 * @author donald
 *
 */
public interface ServiceCategoryDAO {
	
	public void save(ServiceCategory serviceCategory);
	public List<ServiceCategory> findAll();
	public ServiceCategory findById(long id);
	public void merge(ServiceCategory serviceCategory);
	public void remove(long id);

}
