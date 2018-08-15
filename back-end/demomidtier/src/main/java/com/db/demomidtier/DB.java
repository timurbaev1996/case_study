package com.db.demomidtier;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DB {
    private Connection connection = null;
    public DB (String dbName, String username, String password){
        try {
            Class.forName ("com.mysql.jdbc.Driver");  
            connection = DriverManager.getConnection (dbName, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
    protected void finalize() {
        //Close Connection
        System.out.println("Called finalize method");
    }
    public String testConnection () {
        if (connection == null) {
            return "Failed to make connection!";
        } else {
            return "Successful";
        }
    }
    public PreparedStatement prepare(String query) {
        try {
            return connection.prepareStatement(query);
        } catch (SQLException e){
           // throw e;
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
    private Map GetColumnNamesAndTypes(ResultSet rs) {
        HashMap NameType = new HashMap();
        try {
            ResultSetMetaData MD = rs.getMetaData();
            int count = MD.getColumnCount();
            for (int i = 1; i <= count; i++) {
                NameType.put(MD.getColumnName(i), MD.getColumnTypeName(i));
            }
        } catch (Exception e) {
            System.out.println("Called exception");
            System.err.println (e.getMessage());
        }
        return NameType;
    }
    public Map[] ResultSetToMapArray (ResultSet rs) {
        ArrayList<Map> list = new ArrayList<>();
        try {
            Map NameType = GetColumnNamesAndTypes(rs);
            
            while (rs.next()) {
                HashMap Obj = new HashMap();
                Iterator entries = NameType.entrySet().iterator();
                while (entries.hasNext()) {
                    Map.Entry<String, String> entry = (Map.Entry) entries.next();
                    String key = (String)entry.getKey();
                    String value = (String)entry.getValue();
                    switch(value) {
                        case "CHAR":
                            Obj.put(key, rs.getString(key));
                            break;
                        case "INT":
                            Obj.put(key, rs.getInt(key));
                            break;
                        case "DATETIME":
                            Obj.put(key, rs.getDate(key));
                            break;
                        case "DECIMAL":
                            Obj.put(key, rs.getBigDecimal(key));
                            break;
                        case "VARCHAR":
                            Obj.put(key, rs.getString(key));
                            break;
                        default:
                            System.out.println("not supported yet");
                    }
                }
                list.add(Obj);
            }
        }
        catch (Exception e) {
            System.err.println ("Got an exception!");
            System.err.println (e.getMessage());
        }
        return (Map[]) list.toArray(new Map[list.size()]);
    }
}
