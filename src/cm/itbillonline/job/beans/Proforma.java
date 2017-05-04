/**
 * 
 */
package cm.itbillonline.job.beans;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author donald
 *
 */
public class Proforma {
	
	private long id;
	private int amount;
	private Date date;
	private ProformaState state;
	private Project project;
	private ArrayList<Service> services;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @return the state
	 */
	public ProformaState getState() {
		return state;
	}
	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}
	/**
	 * @return the services
	 */
	public ArrayList<Service> getServices() {
		return services;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(ProformaState state) {
		this.state = state;
	}
	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}
	/**
	 * @param services the services to set
	 */
	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}
	
}
