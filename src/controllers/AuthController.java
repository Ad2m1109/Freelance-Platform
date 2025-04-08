package controllers;

import models.User;
import utils.DBConnector;

public class AuthController {
    public User login(String username, String password) {
        // Simple JDBC implementation
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (var conn = DBConnector.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            
            var rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("type")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}