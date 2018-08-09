package com.db.demomidtier;

import java.sql.*;

public class SQLManager {
    private Connection connection;
    public SQLManager (String dbName, String username, String password){
        try {
            Class.forName ("com.mysql.jdbc.Driver");  
            connection = DriverManager.getConnection (dbName,username,password);
        } catch (Exception e) {
            connection = null;
        }
    }
    protected void finalize() {
        System.out.println("Called finalize method");
    }
    
    
    static final class Deal {
        @JsonProperty("deal_id");
        private String dealId;
/*        @JsonProperty("picOfPersonWhoPosted")
        private String pictureOfPoster;
        @JsonProperty("nameOfPersonWhoPosted")
        private String nameOfPoster;
        private String likesCount;
        private List<String> comments;
        private String timeOfPost;*/
    }
    
    
    // deal_id
    
    private static final ObjectMapper JACKSON = new ObjectMapper();
    public String testConnection () {
        
        
        
        if (connection == null) {
            return "Failed to make connection!";
        } else {
            return "Successful";
        }
    }
    public boolean AuthorizeUser (String login, String password) {
        try {
            String query = "SELECT user_pwd FROM db_grad_cs_1917.users WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString (1, login);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if (password.equals(rs.getString("user_pwd"))) {
                    return true;
                }
            } else {
                System.out.println("User not found");
            }
        }
        catch (Exception e) {
            System.err.println ("Got an exception!");
            System.err.println (e.getMessage());
        }
        return false;
    }

    private static class ObjectMapper {

        public ObjectMapper() {
        }
    }
}
