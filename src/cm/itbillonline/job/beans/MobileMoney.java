/**
 * 
 */
package cm.itbillonline.job.beans;

/**
 * @author donald
 *
 */
public class MobileMoney extends PaymentMethod {
	
	private String accountPhoneNumber;

	/**
	 * @return the accountPhoneNumber
	 */
	public String getAccountPhoneNumber() {
		return accountPhoneNumber;
	}

	/**
	 * @param accountPhoneNumber the accountPhoneNumber to set
	 */
	public void setAccountPhoneNumber(String accountPhoneNumber) {
		this.accountPhoneNumber = accountPhoneNumber;
	}
}
