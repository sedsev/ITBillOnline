/**
 * 
 */
package cm.itbillonline.job.beans;

import java.util.ArrayList;

/**
 * @author donald
 *
 */
public class Customer extends User {
	
	private ArrayList<PaymentMethod> paymentMethods;

	/**
	 * 
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param email
	 * @param phoneNumber
	 * @param login
	 * @param password
	 */
	public Customer(String firstName, String lastName, String gender,
			String email, String phoneNumber, String login, String password) {
		super(firstName, lastName, gender, email, phoneNumber, login, password);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the paymentMethods
	 */
	public ArrayList<PaymentMethod> getPaymentMethods() {
		return paymentMethods;
	}

	/**
	 * @param paymentMethods the paymentMethods to set
	 */
	public void setPaymentMethods(ArrayList<PaymentMethod> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
	
}
