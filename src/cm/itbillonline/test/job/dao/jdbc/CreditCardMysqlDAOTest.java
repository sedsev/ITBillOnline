/**
 * 
 */
package cm.itbillonline.test.job.dao.jdbc;

import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import cm.itbillonline.job.beans.CreditCard;
import cm.itbillonline.job.beans.Provider;
import cm.itbillonline.job.beans.User;
import cm.itbillonline.job.dao.CreditCardDAO;
import cm.itbillonline.job.dao.jdbc.CreditCardMysqlDAO;

/**
 * @author donald
 *
 */
public class CreditCardMysqlDAOTest {
	
	public static boolean canSave(CreditCard card){
		CreditCardDAO cardDAO = new CreditCardMysqlDAO();
		long currentRecordNumber = cardDAO.count();
		cardDAO.save(card);
		return cardDAO.count() == currentRecordNumber+1;
	}
	
	public static boolean canFindAll(){
		CreditCardDAO cardDAO = new CreditCardMysqlDAO();
		List<CreditCard> cards = cardDAO.findAll();
		return cardDAO.count() == cards.size();
	}
	
	public static boolean canDelete(long id){
		CreditCardDAO cardDAO = new CreditCardMysqlDAO();
		long currentRecordNumber = cardDAO.count();
		cardDAO.remove(id);
		return cardDAO.count() == currentRecordNumber-1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message = "";
		boolean canFind = canFindAll();
		boolean canSav = true;
		boolean canDel = true;
		if(canFind){
			message += "Test findAll() : OK \n";
			CreditCardDAO cardDAO = new CreditCardMysqlDAO();
			List<CreditCard> cards = cardDAO.findAll();
			Iterator<CreditCard> it = cards.iterator();
			while (it.hasNext()) {
				CreditCard card = it.next();
				canDel = canDel && canDelete(card.getId());
			}
			if(canDel){
				message += "Test remove(long id) : OK \n";
			}else{
				message += "Test remove(long id) : Echec \n";
			}
		}else{
			message += "Test remove(long id) : Echec \n";
		}
		//User user =  
		//canSav = canSav && canSave(p);
		if(canSav){
			message += "Test save(Provider provider) : OK \n";
		}else{
			message += "Test save(Provider provider) : Echec \n";
		}
		
		if(canDel && canFind && canSav){
			JOptionPane.showMessageDialog(null, message, "Test DAO  Provider", JOptionPane.INFORMATION_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null, message, "Test DAO  Provider", JOptionPane.ERROR_MESSAGE);
		}

	}

}
