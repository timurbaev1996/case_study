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
    public Map[] LoadUsers (String UserId) {
        Map[] Users = null;
        try {
            String query = "SELECT * FROM db_grad_cs_1917.users WHERE user_id = ?";
            PreparedStatement preparedStatement = db.prepare(query);
            preparedStatement.setString (1, UserId);
            preparedStatement.execute();
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
    public Map[] LoadCounterparties (){ //Integer CounterpartyId) {
        Map[] Counterparties = null;
        try {
//            String query = "SELECT * FROM db_grad_cs_1917.counterparty WHERE counterparty_id = ?";
            String query = "SELECT * FROM db_grad_cs_1917.counterparty";
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
    public boolean AuthorizeUser (String login, String password) {
        
        return false;
    }
}
