/**
 * 
 */
package cm.itbillonline.job.beans;

/**
 * @author donald
 *
 */
public class Employee extends User {
	
	private String cniNumber;

	
	/**
	 * 
	 */
	public Employee() {
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
	 * @param cniNumber
	 */
	public Employee(String firstName, String lastName, String gender,
			String email, String phoneNumber, String login, String password,
			String cniNumber) {
		super(firstName, lastName, gender, email, phoneNumber, login, password);
		this.cniNumber = cniNumber;
	}



	/**
	 * @return the cniNumber
	 */
	public String getCniNumber() {
		return cniNumber;
	}

	/**
	 * @param cniNumber the cniNumber to set
	 */
	public void setCniNumber(String cniNumber) {
		this.cniNumber = cniNumber;
	}
	
	

}
