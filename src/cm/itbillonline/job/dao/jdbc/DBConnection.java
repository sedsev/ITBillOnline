/**
 * 
 */
package cm.itbillonline.job.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author donald
 *
 */
public class DBConnection {
	
	private static Connection connection;
	static{
		try {
			Class.forName("com.jdbc.mysql.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/it_bill_online", "root", "sedco92");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @return the connection
	 */
	public static Connection getConnection() {
		return connection;
	}
}
