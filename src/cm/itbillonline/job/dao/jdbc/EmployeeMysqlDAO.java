package cm.itbillonline.job.dao.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cm.itbillonline.job.beans.Employee;
import cm.itbillonline.job.dao.EmployeeDAO;

public class EmployeeMysqlDAO implements EmployeeDAO {


		@Override
		public void save(Employee employee) {
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
		}

		@Override
		public List<Employee> findAll() {
			// TODO Auto-generated method stub
			List<Employee> employees = new ArrayList<Employee>();
			Connection con = DBConnection.getConnection();
			try {
				PreparedStatement ps = con.prepareStatement("SELECT * FROM user");
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Employee e = new Employee();
					e.setId(rs.getLong("id"));
					e.setFirstName(rs.getString("first_name"));
					e.setLastName(rs.getString("last_name"));
					e.setGender(rs.getString("gender"));
					e.setEmail(rs.getString("email"));
					e.setPhoneNumber(rs.getString("phone_number"));
					e.setLogin(rs.getString("login"));
					e.setPassword(rs.getString("passord"));
					employees.add(e);
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return employees;
		}

		@Override
		public Employee findById(long id) {
			// TODO Auto-generated method stub
			Employee employee = new Employee();
			Connection con =DBConnection.getConnection();
			try {
				PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE user.id = ?");
				ps.setLong(1, id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					employee.setId(rs.getLong("id"));
					employee.setFirstName(rs.getString("first_name"));
					employee.setLastName(rs.getString("last_name"));
					employee.setGender(rs.getString("gender"));
					employee.setEmail(rs.getString("email"));
					employee.setPhoneNumber(rs.getString("phone_number"));
					employee.setLogin(rs.getString("login"));
					employee.setPassword(rs.getString("passord"));
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return employee;
		}

		/* (non-Javadoc)
		 * @see cm.itbillonline.job.dao.ProviderDAO#merge(cm.itbillonline.job.beans.Provider)
		 */
		@Override
		public void merge(Employee employee) {
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
