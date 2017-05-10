/**
 * 
 */
package cm.itbillonline.job.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cm.itbillonline.job.beans.Employee;
import cm.itbillonline.job.beans.Employee;
import cm.itbillonline.job.dao.EmployeeDAO;

/**
 * @author donald
 *
 */
public class EmployeeMysqlDAO implements EmployeeDAO {

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.EmployeeDAO#save(cm.itbillonline.job.beans.Employee)
	 */
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO user SET last_name = ?, first_name = ?, gender = ?, email = ?, phone_number = ?, login = ?, password = ?");
			ps.setString(1, employee.getFirstName());
			ps.setString(2, employee.getLastName());
			ps.setString(3, employee.getGender());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getPhoneNumber());
			ps.setString(6, employee.getLogin());
			ps.setString(7, employee.getPassword());
			ps.executeUpdate();
			ps.close();
			ps = con.prepareStatement("SELECT LAST_INSERT_ID() AS last_id FROM user");
			ResultSet rs = ps.executeQuery();
			rs.next();
			long lastId = rs.getLong("last_id");
			ps.close();
			ps = con.prepareStatement("INSERT INTO employee VALUES(?,?)");
			ps.setLong(1, lastId);
			ps.setString(2, employee.getCniNumber());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.EmployeeDAO#findAll()
	 */
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<Employee>();
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user INNER JOIN employee ON user.id = employee.id");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setId(rs.getLong("id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setGender(rs.getString("gender"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setLogin(rs.getString("login"));
				emp.setPassword(rs.getString("password"));
				emp.setCniNumber(rs.getString("cni_number"));
				employees.add(emp);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.EmployeeDAO#findById(long)
	 */
	@Override
	public Employee findById(long id) {
		// TODO Auto-generated method stub
		Employee employee = null;
		Connection con =DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user INNER JOIN employee ON user.id = employee.id WHERE user.id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setGender(rs.getString("gender"));
				employee.setEmail(rs.getString("email"));
				employee.setPhoneNumber(rs.getString("phone_number"));
				employee.setLogin(rs.getString("login"));
				employee.setPassword(rs.getString("password"));
				employee.setCniNumber(rs.getString("cni_number"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(employee == null) throw new RuntimeException("Aucun Fournisseur ne correspond à cet identifiant");
		return employee;
	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.EmployeeDAO#merge(cm.itbillonline.job.beans.Employee)
	 */
	@Override
	public void merge(Employee employee) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE user SET last_name = ?, first_name = ?, gender = ?, email = ?, phone_number = ?, login = ?, password = ? WHERE id = ?");
			ps.setString(1, employee.getLastName());
			ps.setString(2, employee.getFirstName());
			ps.setString(3, employee.getGender());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getPhoneNumber());
			ps.setString(6, employee.getLogin());
			ps.setString(7, employee.getPassword());
			ps.setLong(8, employee.getId());
			ps.executeUpdate();
			ps.close();
			ps = con.prepareStatement("UPDATE employee SET cni_number = ? WHERE id = ?");
			ps.setString(1, employee.getCniNumber());
			ps.setLong(2, employee.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.EmployeeDAO#remove(long)
	 */
	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM user WHERE id = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		long result = 0;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS number_employee FROM employee");
			ResultSet rs = ps.executeQuery();
			rs.next();
			result = rs.getLong("number_employee");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
