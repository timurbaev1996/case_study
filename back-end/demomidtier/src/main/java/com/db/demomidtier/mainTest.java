package com.db.demomidtier;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mainTest {
    public static void main (String args[]){
        SQLManager sql = new SQLManager("jdbc:mysql://localhost:3307/db_grad","root","ppp"); // Must be read from config
        try {
            System.out.print(sql.AuthorizeUser("alison","gradprog2016@07"));
        } catch (Exception ex) {
            Logger.getLogger(mainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
