/**
 * 
 */
package cm.itbillonline.job.dao;

import java.util.List;

import cm.itbillonline.job.beans.Bill;

/**
 * @author donald
 *
 */
public interface BillDAO {
	
	public void save(Bill bill);
	public List<Bill> findAll();
	public Bill findById(long id);
	public void merge(Bill bill);
	public void remove(long id);

}
