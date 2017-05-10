/**
 * 
 */
package cm.itbillonline.test.job.dao.jdbc;

import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import cm.itbillonline.job.beans.Employee;
import cm.itbillonline.job.dao.EmployeeDAO;
import cm.itbillonline.job.dao.jdbc.EmployeeMysqlDAO;

/**
 * @author donald
 *
 */
public class EmployeeMysqlDAOTest {
	
	public static boolean canSave(Employee employee){
		EmployeeDAO employeeDAO = new EmployeeMysqlDAO();
		long currentRecordNumber = employeeDAO.count();
		employeeDAO.save(employee);
		return employeeDAO.count() == currentRecordNumber+1;
	}
	
	public static boolean canFindAll(){
		EmployeeDAO employeeDAO = new EmployeeMysqlDAO();
		List<Employee> employees = employeeDAO.findAll();
		return employeeDAO.count() == employees.size();
	}
	
	public static boolean canDelete(long id){
		EmployeeDAO employeeDAO = new EmployeeMysqlDAO();
		long currentRecordNumber = employeeDAO.count();
		employeeDAO.remove(id);
		return employeeDAO.count() == currentRecordNumber-1;
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
			EmployeeDAO employeeDAO = new EmployeeMysqlDAO();
			List<Employee> employees = employeeDAO.findAll();
			Iterator<Employee> it = employees.iterator();
			while (it.hasNext()) {
				Employee employee = it.next();
				canDel = canDel && canDelete(employee.getId());
			}
			if(canDel){
				message += "Test remove(long id) : OK \n";
			}else{
				message += "Test remove(long id) : Echec \n";
			}
		}else{
			message += "Test remove(long id) : Echec \n";
		}
		Employee employee = new Employee("Sandjo Eloundou", "Donald", "masculin", "dimteloundou@yahoo.fr", "67081960", "seds", "sedco030692", "1223358");
		canSav = canSav && canSave(employee);
		if(canSav){
			message += "Test save(Employee employee) : OK \n";
		}else{
			message += "Test save(Employee employee) : Echec \n";
		}
		
		if(canDel && canFind && canSav){
			JOptionPane.showMessageDialog(null, message, "Test DAO  Provider", JOptionPane.INFORMATION_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null, message, "Test DAO  Provider", JOptionPane.ERROR_MESSAGE);
		}

	}

}
