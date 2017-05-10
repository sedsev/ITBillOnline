/**
 * 
 */
package cm.itbillonline.job.dao;

import java.util.List;

import cm.itbillonline.job.beans.Employee;

/**
 * @author donald
 *
 */
public interface EmployeeDAO {
	
	public void save(Employee employee);
	public List<Employee> findAll();
	public Employee findById(long id);
	public void merge(Employee employee);
	public void remove(long id);
	public long count();
}
