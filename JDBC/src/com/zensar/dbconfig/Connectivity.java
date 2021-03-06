package com.zensar.dbconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Connectivity {

	public static Connection getConnectivity() throws ClassNotFoundException, SQLException {
		// step 1:: load jdbc driver class::
		Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver loaded");
		System.out.println("Enter username");
		String user = sc.next();
		System.out.println("Enter Password:");
		String pass = sc.next();
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", user, pass);
		System.out.println("Connection established");
		return con;

	}
}
   