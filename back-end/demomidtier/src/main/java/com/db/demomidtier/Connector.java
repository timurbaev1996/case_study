
package com.db.demomidtier;
 
import java.sql.*;  
 

public class Connector {
    
    public static Connection makeConnection(String dbName, String userName, String passWord){  
        
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            dbName,userName,passWord);  
            //here sonoo is database name, root is username and password  
            
            return con;


    }catch(Exception e){ 
        return null;}  
    
}
    
    public static String testConnection(Connection con){
	
	if (con == null) {
            
            return "Failed to make connection!";
		
	} else {
                return "Successful";
		
		}      
    } 

} 
