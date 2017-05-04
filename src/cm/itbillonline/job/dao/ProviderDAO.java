/**
 * 
 */
package cm.itbillonline.job.dao;

import java.util.List;

import cm.itbillonline.job.beans.Provider;

/**
 * @author donald
 *
 */
public interface ProviderDAO {
	
	public void save(Provider provider);
	public List<Provider> findAll();
	public Provider findById(long id);
	public void merge(Provider provider);
	public void remove(long id);
}
