package exampleMVN.Scanner;

import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConfig {
	private String jdbcConnectionURL;
    private String username;
    private String password;

    public void LearningJDBC(String username, String password) {
        jdbcConnectionURL = "jdbc:mysql://localhost:3306/ims";
        this.username = username;
        this.password = password;
    }

    public void LearningJDBC(String jdbcConnectionURL, String username, String password) {
        this.jdbcConnectionURL = jdbcConnectionURL;
        this.username = username;
        this.password = password;
    }

    public void readAll() {
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(jdbcConnectionURL, username, password);
        } catch (SQLException e) {
            
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
