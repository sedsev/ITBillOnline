/**
 * 
 */
package cm.itbillonline.job.dao;

import java.util.List;

import cm.itbillonline.job.beans.Project;

/**
 * @author donald
 *
 */
public interface ProjectDAO {
	
	public void save(Project project);
	public List<Project> findAll();
	public Project findById(long id);
	public void merge(Project project);
	public void remove(long id);

}
