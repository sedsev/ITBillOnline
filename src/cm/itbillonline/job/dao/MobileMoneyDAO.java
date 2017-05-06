/**
 * 
 */
package cm.itbillonline.job.dao;

import java.util.List;

import cm.itbillonline.job.beans.MobileMoney;

/**
 * @author donald
 *
 */
public interface MobileMoneyDAO {
	
	public void save(MobileMoney momo);
	public List<MobileMoney> findAll();
	public MobileMoney findById(long id);
	public void merge(MobileMoney momo);
	public void remove(long id);
}
