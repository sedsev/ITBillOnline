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

import cm.itbillonline.job.beans.Provider;
import cm.itbillonline.job.dao.ProviderDAO;

/**
 * @author donald
 *
 */
public class ProviderMysqlDAO implements ProviderDAO {

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.ProviderDAO#save(cm.itbillonline.job.beans.Provider)
	 */
	@Override
	public void save(Provider provider) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO user SET last_name = ?, first_name = ?, gender = ?, email = ?, phone_number = ?, login = ?, password = ?");
			ps.setString(1, provider.getFirstName());
			ps.setString(2, provider.getLastName());
			ps.setString(3, provider.getGender());
			ps.setString(4, provider.getEmail());
			ps.setString(5, provider.getPhoneNumber());
			ps.setString(6, provider.getLogin());
			ps.setString(7, provider.getPassword());
			ps.executeUpdate();
			ps.close();
			ps = con.prepareStatement("SELECT LAST_INSERT_ID() AS last_id FROM user");
			ResultSet rs = ps.executeQuery();
			rs.next();
			long lastId = rs.getLong("last_id");
			ps.close();
			ps = con.prepareStatement("INSERT INTO provider VALUES(?,?)");
			ps.setLong(1, lastId);
			ps.setString(2, provider.getOrganisationName());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.ProviderDAO#findAll()
	 */
	@Override
	public List<Provider> findAll() {
		// TODO Auto-generated method stub
		List<Provider> providers = new ArrayList<Provider>();
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user INNER JOIN provider ON user.id = provider.id");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Provider p = new Provider();
				p.setId(rs.getLong("id"));
				p.setFirstName(rs.getString("first_name"));
				p.setLastName(rs.getString("last_name"));
				p.setGender(rs.getString("gender"));
				p.setEmail(rs.getString("email"));
				p.setPhoneNumber(rs.getString("phone_number"));
				p.setLogin(rs.getString("login"));
				p.setPassword(rs.getString("password"));
				p.setOrganisationName(rs.getString("organisation_name"));
				providers.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return providers;
	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.ProviderDAO#findById(long)
	 */
	@Override
	public Provider findById(long id) {
		// TODO Auto-generated method stub
		Provider provider = null;
		Connection con =DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user INNER JOIN provider ON user.id = provider.id WHERE user.id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				provider = new Provider();
				provider.setId(rs.getLong("id"));
				provider.setFirstName(rs.getString("first_name"));
				provider.setLastName(rs.getString("last_name"));
				provider.setGender(rs.getString("gender"));
				provider.setEmail(rs.getString("email"));
				provider.setPhoneNumber(rs.getString("phone_number"));
				provider.setLogin(rs.getString("login"));
				provider.setPassword(rs.getString("password"));
				provider.setOrganisationName(rs.getString("organisation_name"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(provider == null) throw new RuntimeException("Aucun Fournisseur ne correspond à cet identifiant");
		return provider;
	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.ProviderDAO#merge(cm.itbillonline.job.beans.Provider)
	 */
	@Override
	public void merge(Provider provider) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE user SET last_name = ?, first_name = ?, gender = ?, email = ?, phone_number = ?, login = ?, password = ? WHERE id = ?");
			ps.setString(1, provider.getLastName());
			ps.setString(2, provider.getFirstName());
			ps.setString(3, provider.getGender());
			ps.setString(4, provider.getEmail());
			ps.setString(5, provider.getPhoneNumber());
			ps.setString(6, provider.getLogin());
			ps.setString(7, provider.getPassword());
			ps.setLong(8, provider.getId());
			ps.executeUpdate();
			ps.close();
			ps = con.prepareStatement("UPDATE provider SET organisation_name = ? WHERE id = ?");
			ps.setString(1, provider.getOrganisationName());
			ps.setLong(2, provider.getId());
			ps.executeUpdate();
			ps.close();
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
		Connection con = DBConnection.getConnection();
		long result = 0;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS number_provider FROM provider");
			ResultSet rs = ps.executeQuery();
			rs.next();
			result = rs.getLong("number_provider");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
