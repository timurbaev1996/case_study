package com.db.demomidtier;

import java.util.Map;

public class mainTest {
    public static void main (String args[]){
        SQLManager sql = new SQLManager("jdbc:mysql://localhost:3307/db_grad","root","ppp"); // Must be read from config
        //sql.LoadUsers("alison");
        //sql.LoadAnonymousUsers("hELLO");
       // sql.LoadCounterparties();
    }
}
