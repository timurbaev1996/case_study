package com.db.demomidtier;

import java.sql.*;
import java.util.Map;

public class SQLManager {
    private DB db;
    public SQLManager (String dbName, String username, String password) {
        try {
            db = new DB(dbName, username, password);
        } catch (Exception e) {
            throw new IllegalStateException("Cannot connect the database!", e); /// wrong
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
    
        //throw new Exception("FASFFASFSAFASGGGGGGGGGGGGGGGGGGGGGGGGGGG");
        try {
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
                    return true; // Better Map
                    //Auth Success
                    //break;
                default:
                    throw new Exception("Database Error"); // Not unique key
            }
        } catch (Exception e) {
            System.err.println ("Got an exception!");
            System.err.println (e.getMessage());
        }
        throw new Exception("[ggydfg");
    }
}
