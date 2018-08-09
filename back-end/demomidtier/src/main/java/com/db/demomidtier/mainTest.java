package com.db.demomidtier;

import static com.db.demomidtier.Connector.*;
import java.sql.*;

public class mainTest {
    public static void main (String args[]){
        SQLManager sql = new SQLManager("jdbc:mysql://localhost:3307/db_grad_cs_1917","root","ppp"); // Must be read from config
        sql.AuthorizeUser("alison", "gradprog2016@07");
        String result = sql.testConnection();
        System.out.println(result);
        
    }
}
