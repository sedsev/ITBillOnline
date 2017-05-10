package cm.itbillonline.job.dao.jdbc;
package cm.itbillonline.job.dao.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cm.itbillonline.job.beans.Employee;
import cm.itbillonline.job.dao.EmployeeDAO;
public class ExternalMysqlDAO implements ExternalDAO{
	

			@Override
			public void save(External external) {
				Connection con = DBConnection.getConnection();
				try {
					PreparedStatement ps = con.prepareStatement("INSERT INTO user SET last_name = ?, first_name = ?, gender = ?, email = ?, phone_number = ?, login = ?, password = ?");
					ps.setString(1, external.getFirstName());
					ps.setString(2, external.getLastName());
					ps.setString(3, external.getGender());
					ps.setString(4, external.getEmail());
					ps.setString(5, external.getPhoneNumber());
					ps.setString(6, external.getLogin());
					ps.setString(7, external.getPassword());
					ps.executeUpdate();
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Auto-generated method stub
			}

			@Override
			public List<External> findAll() {
				// TODO Auto-generated method stub
				List<External> external = new ArrayList<External>();
				Connection con = DBConnection.getConnection();
				try {
					PreparedStatement ps = con.prepareStatement("SELECT * FROM user");
					ResultSet rs = ps.executeQuery();
					while(rs.next()){
						External e = new External();
						e.setId(rs.getLong("id"));
						e.setFirstName(rs.getString("first_name"));
						e.setLastName(rs.getString("last_name"));
						e.setGender(rs.getString("gender"));
						e.setEmail(rs.getString("email"));
						e.setPhoneNumber(rs.getString("phone_number"));
						e.setLogin(rs.getString("login"));
						e.setPassword(rs.getString("passord"));
						external.add(e);
					}
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return external;
			}

			@Override
			public External findById(long id) {
				// TODO Auto-generated method stub
				External external = new External();
				Connection con =DBConnection.getConnection();
				try {
					PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE user.id = ?");
					ps.setLong(1, id);
					ResultSet rs = ps.executeQuery();
					if(rs.next()){
						external.setId(rs.getLong("id"));
						external.setFirstName(rs.getString("first_name"));
						external.setLastName(rs.getString("last_name"));
						external.setGender(rs.getString("gender"));
						external.setEmail(rs.getString("email"));
						external.setPhoneNumber(rs.getString("phone_number"));
						external.setLogin(rs.getString("login"));
						external.setPassword(rs.getString("passord"));
					}
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return external;
			}

			/* (non-Javadoc)
			 * @see cm.itbillonline.job.dao.ProviderDAO#merge(cm.itbillonline.job.beans.Provider)
			 */
			@Override
			public void merge(External external) {
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
