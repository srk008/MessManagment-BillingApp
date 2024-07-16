package org.Mess.Repository;

import org.Mess.DbConfig.GetConnections;
import org.Mess.Model.billingModel;

public class billingRepository extends GetConnections{

	public boolean iscalculatebill(billingModel bmodel) {
		try {
			
			stmt=conn.prepareStatement("insert into billing values('0',?,?,?,?,?)");
			stmt.setInt(1,bmodel.getCid());
			stmt.setString(2,bmodel.getBdate());
			stmt.setInt(3,bmodel.getAmount());
			stmt.setString(4,bmodel.getItemName());
			stmt.setInt(5,bmodel.getQty());
			
			int value=stmt.executeUpdate();
			return value>0?true:false;
			
		} 
		catch (Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
		
	}

	public int isgettotalwalkin() {
		try {
			stmt=conn.prepareStatement("select sum(amount) from billing");
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
