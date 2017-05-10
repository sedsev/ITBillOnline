/**
 * 
 */
package cm.itbillonline.job.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cm.itbillonline.job.beans.CreditCard;
import cm.itbillonline.job.beans.Customer;
import cm.itbillonline.job.beans.MobileMoney;
import cm.itbillonline.job.dao.MobileMoneyDAO;

/**
 * @author donald
 *
 */
public class MobileMoneyMysqlDAO implements MobileMoneyDAO {

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.MobileMoneyDAO#save(cm.itbillonline.job.beans.MobileMoney)
	 */
	@Override
	public void save(MobileMoney momo) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO payment_method SET label = ?, customer_id = ?");
			ps.setString(1, momo.getLabel());
			ps.setLong(2, momo.getCustomer().getId());
			ps.executeUpdate();
			ps.close();
			ps = con.prepareStatement("SELECT LAST_INSERT_ID() AS last_id FROM payment_method");
			ResultSet rs = ps.executeQuery();
			rs.next();
			long lastId = rs.getLong("last_id");
			ps.close();
			ps = con.prepareStatement("INSERT INTO mobile_money VALUES(?,?)");
			ps.setLong(1, lastId);
			ps.setString(2, momo.getAccountPhoneNumber());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.MobileMoneyDAO#findAll()
	 */
	@Override
	public List<MobileMoney> findAll() {
		List<MobileMoney> momos = new ArrayList<MobileMoney>();
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT "
					+ "user.id AS user_id, first_name, last_name, gender, email, phone_number, login, password,"
					+ "payment_method.id AS method_id, label, customer_id, mobile_money.id AS id,"
					+ "account_phone_number FROM user INNER JOIN payment_method ON  user.id = customer_id INNER JOIN mobile_money ON payment_method.id = mobile_money.id");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				MobileMoney momo = new MobileMoney();
				momo.setId(rs.getLong("id"));
				momo.setLabel(rs.getString("label"));
				momo.setAccountPhoneNumber(rs.getString("account_phone_number"));
				Customer customer = new Customer(rs.getString("fist_name"), rs.getString("last_name"), rs.getString("gender"), rs.getString("email"), rs.getString("phone_number"), rs.getString("login"), rs.getString("password"));
				customer.setId(rs.getLong("user_id"));
				customer.addPaymentMethod(momo);
				momos.add(momo);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return momos;
	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.MobileMoneyDAO#findById(long)
	 */
	@Override
	public MobileMoney findById(long id) {
		MobileMoney momo = null;
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT "
					+ "user.id AS user_id, first_name, last_name, gender, email, phone_number, login, password,"
					+ "payment_method.id AS method_id, label, customer_id, mobile_money.id AS id,"
					+ "account_phone_number FROM user INNER JOIN payment_method ON  user.id = customer_id INNER JOIN mobile_money ON payment_method.id = mobile_money.id WHERE mobile_money.id = ?");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				momo = new MobileMoney();
				momo.setId(rs.getLong("id"));
				momo.setLabel(rs.getString("label"));
				momo.setAccountPhoneNumber(rs.getString("account_phone_number"));
				Customer customer = new Customer(rs.getString("fist_name"), rs.getString("last_name"), rs.getString("gender"), rs.getString("email"), rs.getString("phone_number"), rs.getString("login"), rs.getString("password"));
				customer.setId(rs.getLong("user_id"));
				customer.addPaymentMethod(momo);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(momo==null) throw new RuntimeException("Aucun compte mobile money n'a été trouvé.");
		return momo;
	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.MobileMoneyDAO#merge(cm.itbillonline.job.beans.MobileMoney)
	 */
	@Override
	public void merge(MobileMoney momo) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE mobibe_money SET account_phone_number = ? WHERE id = ?");
			ps.setString(1, momo.getAccountPhoneNumber());
			ps.setLong(2, momo.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.MobileMoneyDAO#remove(long)
	 */
	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM payment_method WHERE id = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
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
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS number_mobile_money FROM mobile_money");
			ResultSet rs = ps.executeQuery();
			rs.next();
			result = rs.getLong("number_mobile_money");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
