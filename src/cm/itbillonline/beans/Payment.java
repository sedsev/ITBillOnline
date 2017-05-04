/**
 * 
 */
package cm.itbillonline.beans;

import java.util.Date;

/**
 * @author donald
 *
 */
public class Payment {
	
	private long id;
	private int amount;
	private Date date;
	private PaymentMethod method;
	private Bill bill;
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
	 * @return the method
	 */
	public PaymentMethod getMethod() {
		return method;
	}
	/**
	 * @return the bill
	 */
	public Bill getBill() {
		return bill;
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
	 * @param method the method to set
	 */
	public void setMethod(PaymentMethod method) {
		this.method = method;
	}
	/**
	 * @param bill the bill to set
	 */
	public void setBill(Bill bill) {
		this.bill = bill;
	}
}
