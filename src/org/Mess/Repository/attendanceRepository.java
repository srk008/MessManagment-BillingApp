package org.Mess.Repository;

import org.Mess.DbConfig.GetConnections;
import org.Mess.Model.attendanceModel;

public class attendanceRepository extends GetConnections{

	public boolean isaddPresent(attendanceModel attendmodel) {
		try {
			
			stmt=conn.prepareStatement("insert into attendance values('0',?,?,?)");
			stmt.setInt(1, attendmodel.getAid());
			stmt.setString(2, attendmodel.getAdate());
			stmt.setInt(3, attendmodel.getPresent());
			int value=stmt.executeUpdate();
			
			return value>0?true:false;
		} 
		catch (Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
		
	}

}
