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
public class Bill {
	
	private long id;
	private int amount;
	private Date date;
	private BillState state;
	private Proforma proforma;
	private ArrayList<Payment> payments;
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
	public BillState getState() {
		return state;
	}
	/**
	 * @return the proforma
	 */
	public Proforma getProforma() {
		return proforma;
	}
	/**
	 * @return the payments
	 */
	public ArrayList<Payment> getPayments() {
		return payments;
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
	public void setState(BillState state) {
		this.state = state;
	}
	/**
	 * @param proforma the proforma to set
	 */
	public void setProforma(Proforma proforma) {
		this.proforma = proforma;
	}
	/**
	 * @param payments the payments to set
	 */
	public void setPayments(ArrayList<Payment> payments) {
		this.payments = payments;
	}
	
}
