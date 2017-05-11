package con.connection.forms;

import javax.servlet.http.HttpServletRequest;

public class connectionform {
    private String resultat;
    
    
    
	public void verifierIdentifiant(HttpServletRequest request){
    	try{
		String login = request.getParameter("login");
    	String pass = request.getParameter("pass");
    	if(pass.equals(login + "123")){
    		resultat = "vous etes bien connecte!!";
    	}else{
    		resultat = "Identifiants incorects";
    	}
    
	} catch(ClassCastException e){
		e.printStackTrace();
	}
	}
    
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
     
     
}
