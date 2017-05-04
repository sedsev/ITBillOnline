/**
 * 
 */
package cm.itbillonline.job.dao;

import java.util.List;

import cm.itbillonline.job.beans.Customer;

/**
 * @author donald
 *
 */
public interface CustomerDAO {
	
	public void save(Customer customer);
	public List<Customer> findAll();
	public Customer findById(long id);
	public void merge(Customer customer);
	public void remove(long id);
}
