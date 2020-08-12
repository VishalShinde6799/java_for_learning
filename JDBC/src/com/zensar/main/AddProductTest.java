package com.zensar.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.zensar.dbconfig.Connectivity;

public class AddProductTest {
	public static void main(String[] args) {
		System.out.println("Here");
		
		try(Connection con = Connectivity.getConnectivity();)
		{
			
			String sql = "insert into product values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			Scanner sc= new Scanner(System.in);
			System.out.println("enter id:: ");
			int productId = sc.nextInt();
			pstmt.setInt(1, productId);
			
			System.out.println("Enter the name:: ");
			String name = sc.next();
			pstmt.setString(2, name);
			
			System.out.println("Enter the brand:: ");
			String brand= sc.next();
			pstmt.setString(3, brand);
			
			System.out.println("Enter price:: ");
			float price = sc.nextFloat();
			pstmt.setFloat(4, price);
			sc.close();
			int updateCount = pstmt.executeUpdate();
			con.commit();
			if(updateCount>0)
				System.out.println("new product saved");
			else
				System.out.println("sorrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrry!!!!");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}

}
