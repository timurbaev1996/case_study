package com.db.demomidtier;

import java.util.Map;

public class mainTest {
    public static void main (String args[]){
        SQLManager sql = new SQLManager("jdbc:mysql://localhost:3307/db_grad_cs_1917","root","ppp"); // Must be read from config
        sql.LoadUsers("alison");
        sql.LoadAnonymousUsers("hELLO");
        sql.LoadCounterparties();
    }
}
