/**
 * 
 */
package cm.itbillonline.job.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import cm.itbillonline.job.beans.CreditCard;
import cm.itbillonline.job.beans.Customer;
import cm.itbillonline.job.beans.Provider;
import cm.itbillonline.job.dao.CreditCardDAO;
/**
 * @author donald
 *
 */
public class CreditCardMysqlDAO implements CreditCardDAO {

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.CreditCardDAO#save(cm.itbillonline.job.beans.CreditCard)
	 */
	@Override
	public void save(CreditCard card) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO payment_method SET label = ?, customer_id = ?");
			ps.setString(1, card.getLabel());
			ps.setLong(2, card.getCustomer().getId());
			ps.executeUpdate();
			ps.close();
			ps = con.prepareStatement("SELECT LAST_INSERT_ID() AS last_id FROM payment_method");
			ResultSet rs = ps.executeQuery();
			rs.next();
			long lastId = rs.getLong("last_id");
			ps.close();
			ps = con.prepareStatement("INSERT INTO credit_card VALUES(?,?,?)");
			ps.setLong(1, lastId);
			ps.setString(2, card.getNumber());
			ps.setString(3, card.getMask());
			ps.setString(4, formatDate.format(card.getEmissionDate()));
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.CreditCardDAO#findAll()
	 */
	@Override
	public List<CreditCard> findAll() {
		// TODO Auto-generated method stub
		List<CreditCard> cards = new ArrayList<CreditCard>();
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT "
					+ "user.id AS user_id, first_name, last_name, gender, email, phone_number, login, password,"
					+ "payment_method.id AS method_id, label, customer_id, credit_card.id AS id,"
					+ "card_number, mask_card, emission_date FROM user INNER JOIN payment_method ON  user.id = customer_id INNER JOIN credit_card ON payment_method.id = credit_card.id");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				CreditCard card = new CreditCard();
				card.setId(rs.getLong("id"));
				card.setLabel(rs.getString("label"));
				card.setEmissionDate(new Date(rs.getString("emission_date")));
				card.setMask(rs.getString("mask_card"));
				card.setNumber(rs.getString("card_number"));
				Customer customer = new Customer(rs.getString("fist_name"), rs.getString("last_name"), rs.getString("gender"), rs.getString("email"), rs.getString("phone_number"), rs.getString("login"), rs.getString("password"));
				customer.setId(rs.getLong("user_id"));
				customer.addPaymentMethod(card);
				cards.add(card);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cards;
	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.CreditCardDAO#findById(long)
	 */
	@Override
	public CreditCard findById(long id) {
		CreditCard card = null;
		Connection con =DBConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT "
					+ "user.id AS user_id, first_name, last_name, gender, email, phone_number, login, password,"
					+ "payment_method.id AS method_id, label, customer_id, credit_card.id AS id,"
					+ "card_number, mask_card, emission_date FROM user INNER JOIN payment_method ON  user_id = customer_id INNER JOIN credit_card ON method_id = id WHERE credit_card.id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				card = new CreditCard();
				card.setId(rs.getLong("id"));
				card.setLabel(rs.getString("label"));
				card.setEmissionDate(new Date(rs.getString("emission_date")));
				card.setMask(rs.getString("mask_card"));
				card.setNumber(rs.getString("card_number"));
				Customer customer = new Customer(rs.getString("fist_name"), rs.getString("last_name"), rs.getString("gender"), rs.getString("email"), rs.getString("phone_number"), rs.getString("login"), rs.getString("password"));
				customer.setId(rs.getLong("user_id"));
				customer.addPaymentMethod(card);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(card == null) throw new RuntimeException("Aucune Carte de Credit ne correspond à cet identifiant");
		return card;
	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.CreditCardDAO#merge(cm.itbillonline.job.beans.CreditCard)
	 */
	@Override
	public void merge(CreditCard card) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE credit_card SET card_number = ?, mask_card = ?, emission_date = ? WHERE id = ?");
			ps.setString(1, card.getNumber());
			ps.setString(2, card.getMask());
			ps.setString(3, formatDate.format(card.getEmissionDate()));
			ps.setLong(4, card.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see cm.itbillonline.job.dao.CreditCardDAO#remove(long)
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
			PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS number_credit_card FROM credit_card");
			ResultSet rs = ps.executeQuery();
			rs.next();
			result = rs.getLong("number_credit_card");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
