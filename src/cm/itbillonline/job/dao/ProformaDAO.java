/**
 * 
 */
package cm.itbillonline.job.dao;

import java.util.List;

import cm.itbillonline.job.beans.Proforma;

/**
 * @author donald
 *
 */
public interface ProformaDAO {
	
	public void save(Proforma proforma);
	public List<Proforma> findAll();
	public Proforma findById(long id);
	public void merge(Proforma proforma);
	public void remove(long id);

}
