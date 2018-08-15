package com.db.demomidtier;

import java.sql.*;
import java.util.Map;

public class SQLManager {
    private DB db;
    public SQLManager (String dbName, String username, String password) {
        try {
            db = new DB(dbName, username, password);
        } catch (Exception e) {
            db = null;
            //throw new IllegalStateException("Cannot connect the database!", e); /// wrong
        }
    }

    public String testConnection () {
        if (db == null) {
            return "Failed to make connection!";
        } else {
            return "Successful";
            
        }}
    public Map LoadUserById (String UserId) throws Exception {
        Map[] Users;
        try {
            String query = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement preparedStatement = db.prepare(query);
            preparedStatement.setString (1, UserId);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();
            Users = db.ResultSetToMapArray (rs);
            if (Users.length == 1) {
                return Users[0];
            }
        } catch (Exception e) {
            System.err.println ("Got an exception!");
            System.err.println (e.getMessage());
        }
        throw new Exception("");
    }
    
        public Map[] overview () throws SQLException {
        String query = "SELECT d.deal_time, d.deal_type, d.deal_amount, d.deal_quantity, i.instrument_name, c.counterparty_name, c.counterparty_status, c.counterparty_date_registered FROM deal d, counterparty c, instrument i where d.deal_instrument_id = i.instrument_id and d.deal_counterparty_id = c.counterparty_id order by d.deal_id";
        PreparedStatement preparedStatement = db.prepare(query);
        preparedStatement.execute();
        ResultSet rs = preparedStatement.executeQuery();
        return db.ResultSetToMapArray (rs);
    }
    public Map[] correlationCounterparty () throws SQLException {
        String query = "SELECT sum(d.deal_quantity), sum(d.deal_amount), c.counterparty_name FROM deal d, counterparty c WHERE d.deal_counterparty_id = c.counterparty_id group by c.counterparty_name;";
	PreparedStatement preparedStatement = db.prepare(query);
        preparedStatement.execute();
        ResultSet rs = preparedStatement.executeQuery();
        return db.ResultSetToMapArray (rs);
    }
    public Map[] correlationInstrument () throws SQLException {
        String query = "SELECT sum(d.deal_quantity), sum(d.deal_amount), i.instrument_name FROM deal d, instrument i WHERE d.deal_instrument_id = i.instrument_id group by i.instrument_name;";
        PreparedStatement preparedStatement = db.prepare(query);
        preparedStatement.execute();
        ResultSet rs = preparedStatement.executeQuery();
        return db.ResultSetToMapArray (rs);
    }
    public Map[] LoadUsers () {
        Map[] Users = null;
        try {
            String query = "SELECT * FROM users";
            PreparedStatement preparedStatement = db.prepare(query);
            ResultSet rs = preparedStatement.executeQuery();
            Users = db.ResultSetToMapArray (rs);
        } catch (Exception e) {
            System.err.println ("Got an exception!");
            System.err.println (e.getMessage());
        }
        return Users;
    }
    public Map[] LoadAnonymousUsers (String AnonymousUserId) {
        Map[] AnonymousUsers = null;
        try {
            String query = "SELECT * FROM db_grad_cs_1917.anonymous_users WHERE anonymous_user_id = ?";
            PreparedStatement preparedStatement = db.prepare(query);
            preparedStatement.setString (1, AnonymousUserId);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();
            AnonymousUsers = db.ResultSetToMapArray (rs);
        } catch (Exception e) {
            System.err.println ("Got an exception!");
            System.err.println (e.getMessage());
        }
        return AnonymousUsers;
    }
    public Map[] LoadCounterparties () {
        Map[] Counterparties = null;
        try {
            String query = "SELECT * FROM counterparty";
            PreparedStatement preparedStatement = db.prepare(query);
          //  preparedStatement.setInt (1, CounterpartyId); /// Integer or Int
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();
            Counterparties = db.ResultSetToMapArray (rs);
        } catch (Exception e) {
            System.err.println ("Got an exception!");
            System.err.println (e.getMessage());
        }
        return Counterparties;
    }
    public boolean AuthorizeUser (String UserId, String UserPwd) throws Exception {
        String query = "SELECT * FROM users WHERE user_id = ? AND user_pwd = ?";
        PreparedStatement preparedStatement = db.prepare(query);
        preparedStatement.setString (1, UserId);
        preparedStatement.setString (2, UserPwd);
        preparedStatement.execute();
        ResultSet rs = preparedStatement.executeQuery();
        Map[] Users = db.ResultSetToMapArray (rs);
        switch (Users.length) {
            case 0:
                throw new Exception("Auth Error");
            case 1:
                String serialized = "Hello";
                // ...
                //cookie.GenerateCookie(serialized);
                // ...
                // cookie.decryptCookie(s);
                return true; // Better Map
                //Auth Success
                //break;
            default:
                throw new Exception("Database Error"); // Not unique key
        }
    }
}
