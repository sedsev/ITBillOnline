/**
 * 
 */
package cm.itbillonline.job.dao;

import java.util.List;

import cm.itbillonline.job.beans.Payment;

/**
 * @author donald
 *
 */
public interface PaymentDAO {
	
	public void save(Payment payment);
	public List<Payment> findAll();
	public Payment findById(long id);
	public void merge(Payment payment);
	public void remove(long id);
}
