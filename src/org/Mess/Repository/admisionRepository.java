package org.Mess.Repository;

import org.Mess.DbConfig.GetConnections;
import org.Mess.Model.admisionModel;

public class admisionRepository extends GetConnections{

	public boolean isaddadmision(admisionModel admisionmodel)
	{
		try {
			stmt=conn.prepareStatement("insert into admission values('0',?,?,?,?)");
			stmt.setInt(1,admisionmodel.getCid());
			stmt.setString(2, admisionmodel.getAdate());
			stmt.setInt(3, admisionmodel.getDeposite());
			stmt.setInt(4, admisionmodel.getHtimes());
			
			int value=stmt.executeUpdate();
			
			
			return value>0?true:false;
		} 
		catch (Exception e) {
			
			System.out.println("Error is "+e);
			return false;
		}
		
	}

	public int isgettotal() {
		try {
			stmt=conn.prepareStatement("select sum(htime) from admission");
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
			{
				return 0;
			}
			
		} catch (Exception e) {
			System.out.println("Error is "+e);
			return 0;
		}
		
	}
	
}
