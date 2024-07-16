package org.Mess.Repository;
import java.util.*;

import org.Mess.DbConfig.GetConnections;
import org.Mess.DbConfig.dbconfig;
import org.Mess.Model.breakfastModel;

public class breakfastRepository extends GetConnections{
	
	List<breakfastModel> list;

	public boolean isAddBreakfast(breakfastModel bmodel)
	{
		try {
			stmt=conn.prepareStatement("insert into breakfast values('0',?,?)");
			stmt.setString(1, bmodel.getName());
			stmt.setInt(2, bmodel.getPrice());
			int value=stmt.executeUpdate();
			return value>0?true:false;
			
		} catch (Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
		
	}
	public List<breakfastModel> isgetBreakfast()
	{
		try {
			stmt=conn.prepareStatement("select *from breakfast");
			rs=stmt.executeQuery();
			 list=new ArrayList<breakfastModel>();
			while(rs.next())
			{
				breakfastModel fmode=new breakfastModel();
				fmode.setBid(rs.getInt(1));
				fmode.setName(rs.getString(2));
				fmode.setPrice(rs.getInt(3));
				list.add(fmode);
			}
			return list.size()>0?list:null;
			
		} catch (Exception e) {
			
			System.out.println("Error is"+e);
			return null;
		}
		
	}
	public boolean isdelete(String did) {
		
		try {
			stmt=conn.prepareStatement("delete from breakfast where name=?");
			stmt.setString(1, did);
			int value=stmt.executeUpdate();
			return value>0?true:false;
		} catch (Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
		
	}
	public boolean ischeckName(String bname) {
		try {
			
			stmt=conn.prepareStatement("select *from breakfast where name=?");
			stmt.setString(1, bname);
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
	public boolean isupdateName(String bname,String nname) {
		
		try
		{
			stmt=conn.prepareStatement("update breakfast set name=? where name=?");
			stmt.setString(1, nname);
			stmt.setString(2, bname);
			int result=stmt.executeUpdate();
			return result>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
		
	}
	public boolean ischeckPrice(String pname) {
		
		try {
			stmt=conn.prepareStatement("select *from breakfast where name=?");
			stmt.setString(1, pname);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
		
	}
	public boolean isupdatePrice(String bname, int nprice) {
		try {
			stmt=conn.prepareStatement("update breakfast set price =? where name=?");
			stmt.setInt(1, nprice);
			stmt.setString(2, bname);
			int value=stmt.executeUpdate();
			return value>0?true:false;
		} catch (Exception e) {
			
			System.out.println("Error is "+e);
			return false;
		}
		
	}
}
