package com.zensar.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zensar.dbconfig.Connectivity;

public class GetProductTest {
	public static void main(String[] args) {

		try (Connection con = Connectivity.getConnectivity();) {
			String sql = "select * from product";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			int count = 0;
			while(rs.next())
			{
				System.out.println("Row: "+(++count));
				int productId = rs.getInt(1);
				String name = rs.getString(2);
				String brand = rs.getString("BRAND");
				float price = rs.getFloat(4);
				System.out.println("ID : "+productId);
				System.out.println("name: "+name);
				System.out.println("brand: "+brand);
				System.out.println("price: "+price);
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("driver class not found");
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
