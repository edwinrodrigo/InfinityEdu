package com.ec.infinity.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexion {

	public static void main(String[] args) {
		new Conexion().realizaConexion();
	}
	
	public void realizaConexion() {
		Connection conn = null;
		String urlDatabase = "jdbc:postgresql://186.101.244.103:1433/testing";
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(urlDatabase, "postgres", "root");
			PreparedStatement ps = conn.prepareStatement("select * from tablaprueba");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1)+" - "+rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}