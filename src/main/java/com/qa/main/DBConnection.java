package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.utils.DBconfig;

public class DBConnection {
	private PreparedStatement ps;
    private Connection con;
    private ResultSet rs;
    
    
    public  DBConnection() throws SQLException {
    	
  
con = DriverManager.getConnection(DBconfig.url, DBconfig.user, DBconfig.pw);
}
    
 public void create (String name, String gender) throws SQLException  {
	 String sql = "INSERT INTO staff (name, gender) VALUE(?, ?)";
	 ps = con.prepareStatement(sql);
	 ps.setString(1, name);
	 ps.execute();
	 
 } 
    
 public void read () throws SQLException  {
	 String sql = "SELECT * FROM staff";
	 ps = con.prepareStatement(sql);
	 rs = ps.executeQuery();
	 if (!rs.next()) {
		 System.out.println("Nothing Found");
	 }else {
		 do {
			 System.out.println(String.format("ID: %d, Name: %s , Gender", rs.getInt("id"), rs.getString("name"), rs.getString("gender")));
		 }while (rs.next());
	 }
 } 
public void readOne (int id) throws SQLException  {
	String sql= " SELECT * FROM staff WHERE id = ?";
	ps = con.prepareStatement(sql);
	 rs = ps.executeQuery();
	 if (!rs.next()) {
		 System.out.println("Nothing Found");
	 }else {
		 do {
			 System.out.println(String.format("ID: %d, Name: %s , Gender", rs.getInt("id"), rs.getString("name"), rs.getString("gender")));
		 }while (rs.next());
	 }
	 
 } 
 public void update (int uId, String name) throws SQLException  {
	ps = con.prepareStatement("UPDATEE staff SET name = ? WHERE id =?" );
	ps.setInt(2, uId);
	ps.setString(1, name);
	ps.execute();
	 
 } 
 public void delete (int id) throws SQLException  {
	 ps = con.prepareStatement("DELETE FROM staff WHERENID = ?");
	 ps.setInt(1, id);
	 ps.execute();
	 
 } 
public void tearDowm () throws SQLException  {
	 
	 con.close();
 }    
    
}