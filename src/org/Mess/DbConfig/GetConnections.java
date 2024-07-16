package org.Mess.DbConfig;

import java.sql.*;
public class GetConnections {
	
	private  dbconfig db=dbconfig.getInstance();
	protected Connection conn=db.getConnection();
	protected PreparedStatement stmt=db.getPreparedStatement();
	protected ResultSet rs=db.getResultSet();
	
   
}
