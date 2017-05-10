/**
 * 
 */
package cm.itbillonline.job.dao;

import java.util.List;

import cm.itbillonline.job.beans.CreditCard;

/**
 * @author donald
 *
 */
public interface CreditCardDAO {
	
	public void save(CreditCard card);
	public List<CreditCard> findAll();
	public CreditCard findById(long id);
	public void merge(CreditCard card);
	public void remove(long id);
	public long count();

}
