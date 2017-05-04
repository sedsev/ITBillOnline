/**
 * 
 */
package cm.itbillonline.job.beans;

/**
 * @author donald
 *
 */
public abstract class PaymentMethod {
	
	private long id;
	private String label;
	private Customer customer;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
