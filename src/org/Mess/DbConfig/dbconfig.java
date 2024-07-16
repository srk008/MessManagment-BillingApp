package org.Mess.DbConfig;
import java.sql.*;
public class dbconfig {
	private ResultSet rs;
	private PreparedStatement stmt;
	private Connection conn;
	private CallableStatement cstmt;
	
	private static dbconfig db=null;
	
	private dbconfig()
	{
		try {
			Class.forName(pathHelper.p.getProperty("db.Driver"));
			
			conn=DriverManager.getConnection(pathHelper.p.getProperty("db.url"),pathHelper.p.getProperty("db.username"),pathHelper.p.getProperty("db.password"));
			
			if(conn!=null)
			{
//				System.out.println("Database Connected..");
			}
			else
			{
				System.out.println("Database not connected");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
		}
	}
	
	
	public static dbconfig getInstance() {
		if(db==null) {
			db=new dbconfig();
		}
		return db;
	}
	
	
	protected Connection getConnection() {
		return conn;
	}
	protected PreparedStatement getPreparedStatement() {
		return stmt;
	}
	
	protected ResultSet getResultSet() {
		return rs;
	}
	
}
