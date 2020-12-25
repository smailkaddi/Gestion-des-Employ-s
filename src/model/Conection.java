package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conection {

	Connection conn;
	Statement stat;
	ResultSet rs;
	
	public void Connect() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root" , "");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
