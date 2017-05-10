package cm.itbillonline.job.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cm.itbillonline.job.beans.Customer;
import cm.itbillonline.job.dao.CustomerDAO;

public class CustomerMysqlDAO implements CustomerDAO {

	@Override
	public void save(Customer customer) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO user SET last_name = ?, first_name = ?, gender = ?, email = ?, phone_number = ?, login = ?, password = ?");
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getGender());
			ps.setString(4, customer.getEmail());
			ps.setString(5, customer.getPhoneNumber());
			ps.setString(6, customer.getLogin());
			ps.setString(7, customer.getPassword());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		List<Customer> customers = new ArrayList<Customer>();
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Customer c = new Customer();
				c.setId(rs.getLong("id"));
				c.setFirstName(rs.getString("first_name"));
				c.setLastName(rs.getString("last_name"));
				c.setGender(rs.getString("gender"));
				c.setEmail(rs.getString("email"));
				c.setPhoneNumber(rs.getString("phone_number"));
				c.setLogin(rs.getString("login"));
				c.setPassword(rs.getString("passord"));
				customers.add(c);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public Customer findById(long id) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		Connection con =DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE user.id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				customer.setId(rs.getLong("id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setGender(rs.getString("gender"));
				customer.setEmail(rs.getString("email"));
				customer.setPhoneNumber(rs.getString("phone_number"));
				customer.setLogin(rs.getString("login"));
				customer.setPassword(rs.getString("passord"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;
	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.ProviderDAO#merge(cm.itbillonline.job.beans.Provider)
	 */
	@Override
	public void merge(Customer customer) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE user SET first_name = ? ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.ProviderDAO#remove(long)
	 */
	@Override
	public void remove(long id) {

	}

}