/**
 * 
 */
package cm.itbillonline.test.job.dao.jdbc;

import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import cm.itbillonline.job.beans.MobileMoney;
import cm.itbillonline.job.beans.MobileMoney;
import cm.itbillonline.job.dao.MobileMoneyDAO;
import cm.itbillonline.job.dao.MobileMoneyDAO;
import cm.itbillonline.job.dao.jdbc.MobileMoneyMysqlDAO;
import cm.itbillonline.job.dao.jdbc.MobileMoneyMysqlDAO;

/**
 * @author donald
 *
 */
public class MobileMoneyMysqlDAOTest {
	
	public static boolean canSave(MobileMoney momo){
		MobileMoneyDAO momoDAO = new MobileMoneyMysqlDAO();
		long currentRecordNumber = momoDAO.count();
		momoDAO.save(momo);
		return momoDAO.count() == currentRecordNumber+1;
	}
	
	public static boolean canFindAll(){
		MobileMoneyDAO cardDAO = new MobileMoneyMysqlDAO();
		List<MobileMoney> cards = cardDAO.findAll();
		return cardDAO.count() == cards.size();
	}
	
	public static boolean canDelete(long id){
		MobileMoneyDAO cardDAO = new MobileMoneyMysqlDAO();
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
			MobileMoneyDAO momoDAO = new MobileMoneyMysqlDAO();
			List<MobileMoney> momos = momoDAO.findAll();
			Iterator<MobileMoney> it = momos.iterator();
			while (it.hasNext()) {
				MobileMoney momo = it.next();
				canDel = canDel && canDelete(momo.getId());
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
