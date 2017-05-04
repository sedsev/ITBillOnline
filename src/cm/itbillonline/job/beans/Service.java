/**
 * 
 */
package cm.itbillonline.job.beans;

/**
 * @author donald
 *
 */
public abstract class Service {
	
	private long id;
	private String title;
	private String description;
	private ServiceCategory category;
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
		return description;
	}
	/**
	 * @return the category
	 */
	public ServiceCategory getCategory() {
		return category;
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
		this.description = description;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(ServiceCategory category) {
		this.category = category;
	}
}
