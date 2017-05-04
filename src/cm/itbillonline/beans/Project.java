/**
 * 
 */
package cm.itbillonline.beans;

import java.util.ArrayList;

/**
 * @author donald
 *
 */
public class Project {
	
	private long id;
	private String title;
	private String Description;
	private ProjectState state;
	private Customer owner;
	ArrayList<Comment> comments;
	ArrayList<Proforma> proformas;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @return the state
	 */
	public ProjectState getState() {
		return state;
	}
	/**
	 * @return the owner
	 */
	public Customer getOwner() {
		return owner;
	}
	/**
	 * @return the comments
	 */
	public ArrayList<Comment> getComments() {
		return comments;
	}
	/**
	 * @return the proformas
	 */
	public ArrayList<Proforma> getProformas() {
		return proformas;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(ProjectState state) {
		this.state = state;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	/**
	 * @param proformas the proformas to set
	 */
	public void setProformas(ArrayList<Proforma> proformas) {
		this.proformas = proformas;
	}
}
