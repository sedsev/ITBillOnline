/**
 * 
 */
package cm.itbillonline.job.beans;

/**
 * @author donald
 *
 */
public class Provider extends User {
	
	private String organisationName;
	
	
	

	/**
	 * 
	 */
	public Provider() {
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
	 * @param organisationName
	 */
	public Provider(String firstName, String lastName, String gender,
			String email, String phoneNumber, String login, String password,
			String organisationName) {
		super(firstName, lastName, gender, email, phoneNumber, login, password);
		this.organisationName = organisationName;
	}



	/**
	 * @return the organisationName
	 */
	public String getOrganisationName() {
		return organisationName;
	}

	/**
	 * @param organisationName the organisationName to set
	 */
	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}
	
	
}
