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
