package org.Mess.Repository;

import java.util.List;
import java.util.*;

import org.Mess.DbConfig.GetConnections;
import org.Mess.DbConfig.dbconfig;
import org.Mess.Model.dinnerModel;

public class dinnerRepository extends GetConnections {

	List<dinnerModel> ld;
	public boolean isAddDinner(dinnerModel dmodel)
	{
		try {
			
			stmt=conn.prepareStatement("insert into dinner values('0',?,?)");
			stmt.setString(1, dmodel.getName());
			stmt.setInt(2, dmodel.getPrice());
			int value=stmt.executeUpdate();
		return	value > 0?true:false; 
		} catch (Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
		
	}

	public List<dinnerModel> isgetDinner() {
		try {
			stmt=conn.prepareStatement("select *from dinner");
			rs=stmt.executeQuery();
			ld=new ArrayList<dinnerModel>();
			while(rs.next())
			{
				dinnerModel dm=new dinnerModel();
				dm.setDid(rs.getInt(1));
				dm.setName(rs.getString(2));
				dm.setPrice(rs.getInt(3));
				ld.add(dm);
				
			}
			return ld.size()>0?ld:null;
		} 
		catch (Exception e)
		{
			System.out.println("Error is "+e);
			return null;
		}
		
	}

	public boolean isdelete(String dinnerid) {
		try {
			stmt=conn.prepareStatement("delete from dinner where name=?");
			stmt.setString(1, dinnerid);
			int value=stmt.executeUpdate();
			return value>0?true:false;
		} 
		catch (Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
		
	}

	public boolean ischeckDinnerName(String dinnerName) {
		try {
			stmt=conn.prepareStatement("select *from dinner where name=?");
			stmt.setString(1, dinnerName);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		} 
		catch (Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
		
	}

	public boolean isupdatedinnerPrice(int dinnerPrice, String dinnerName) {
		try {
			stmt=conn.prepareStatement("update dinner set price=? where name=?");
			stmt.setInt(1, dinnerPrice);
			stmt.setString(2, dinnerName);
			int value=stmt.executeUpdate();
			
			return value>0?true:false;
		}
		catch (Exception e) {
			System.out.println("Error is"+e);
			return false;
		}
	}
}
