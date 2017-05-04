/**
 * 
 */
package cm.itbillonline.job.beans;

import java.util.Date;

/**
 * @author donald
 *
 */
public class CreditCard extends PaymentMethod {
	
	private String number;
	private String mask;
	private Date emissionDate;
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the mask
	 */
	public String getMask() {
		return mask;
	}
	/**
	 * @param mask the mask to set
	 */
	public void setMask(String mask) {
		this.mask = mask;
	}
	/**
	 * @return the emissionDate
	 */
	public Date getEmissionDate() {
		return emissionDate;
	}
	/**
	 * @param emissionDate the emissionDate to set
	 */
	public void setEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
	}

}
