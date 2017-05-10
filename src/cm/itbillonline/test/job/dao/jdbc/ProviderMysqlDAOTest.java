/**
 * 
 */
package cm.itbillonline.test.job.dao.jdbc;

import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import cm.itbillonline.job.beans.Provider;
import cm.itbillonline.job.dao.ProviderDAO;
import cm.itbillonline.job.dao.jdbc.ProviderMysqlDAO;

/**
 * @author donald
 *
 */
public class ProviderMysqlDAOTest {
	
	public static boolean canSave(Provider provider){
		ProviderDAO providerDAO = new ProviderMysqlDAO();
		long currentRecordNumber = providerDAO.count();
		providerDAO.save(provider);
		return providerDAO.count() == currentRecordNumber+1;
	}
	
	public static boolean canFindAll(){
		ProviderDAO providerDAO = new ProviderMysqlDAO();
		List<Provider> providers = providerDAO.findAll();
		return providerDAO.count() == providers.size();
	}
	
	public static boolean canDelete(long id){
		ProviderDAO providerDAO = new ProviderMysqlDAO();
		long currentRecordNumber = providerDAO.count();
		providerDAO.remove(id);
		return providerDAO.count() == currentRecordNumber-1;
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
			ProviderDAO providerDAO = new ProviderMysqlDAO();
			List<Provider> providers = providerDAO.findAll();
			Iterator<Provider> it = providers.iterator();
			while (it.hasNext()) {
				Provider provider = it.next();
				canDel = canDel && canDelete(provider.getId());
			}
			if(canDel){
				message += "Test remove(long id) : OK \n";
			}else{
				message += "Test remove(long id) : Echec \n";
			}
		}else{
			message += "Test remove(long id) : Echec \n";
		}
		Provider p = new Provider("Sandjo Eloundou", "Donald", "masculin", "dimitrieloundou@yahoo.fr", "670811960", "sedsev", "sedco030692", "wincomservices");
		canSav = canSav && canSave(p);
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
