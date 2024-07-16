package org.Mess.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.Mess.DbConfig.GetConnections;
import org.Mess.DbConfig.dbconfig;
import org.Mess.Model.menuModel;

public class menuItemRepository extends GetConnections {
	List<menuModel> list;
	public boolean isAddItem(menuModel menu)
	{
		
		
		try
		{
			stmt=conn.prepareStatement("insert into menu values('0',?,?)");
			String name=menu.getName();
			int price=menu.getPrice();
			stmt.setString(1, name);
			stmt.setInt(2, price);
			int value=stmt.executeUpdate();
			 return value>0?true:false;
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
		}
		return false;
	}
	public List<menuModel> isgetMenu()
	{
	
		
		try {
			stmt=conn.prepareStatement("select *from menu");
			list=new ArrayList<menuModel>();
			rs=stmt.executeQuery();
			while(rs.next())
			{
				menuModel menu=new menuModel();
				menu.setId(rs.getInt(1));
				menu.setPrice(rs.getInt(3));
				menu.setName(rs.getString(2));
				
				list.add(menu);
			}
			return list.size() > 0? list:null;
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	public boolean isupdatelunchPrice(int nlunchprice, String lunchName) {
		try {
			
			stmt=conn.prepareStatement("update menu set price=? where name=?");
			stmt.setInt(1, nlunchprice);
			stmt.setString(2, lunchName);
			int value=stmt.executeUpdate();
			return value>0?true:false;
			
		} 
		catch (Exception e) {
			System.out.println("Error is "+e);
			return false;
		}
		
	}
	public boolean ischecklunchname(String lunchName) {
		try {
			stmt=conn.prepareStatement("select *from menu where name=?");
			stmt.setString(1, lunchName);
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
	

}
