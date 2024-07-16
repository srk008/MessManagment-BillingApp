package org.Mess.Repository;
import java.util.*;

import org.Mess.DbConfig.GetConnections;
import org.Mess.DbConfig.dbconfig;
import org.Mess.Model.AllmessCustomerModel;

public class AllmessCustomerRepository extends GetConnections {
	AllmessCustomerModel allcust;
	ArrayList<AllmessCustomerModel> list;
	public boolean isAddCustomer(AllmessCustomerModel allcust)
	{
		try {
			stmt=conn.prepareStatement("insert into candidates values('0',?,?,?)");
			stmt.setString(1, allcust.getName());
			stmt.setString(2, allcust.getEmail());
			stmt.setString(3,allcust.getContact());
			
			int value=stmt.executeUpdate();
			return value>0?true:false;
			
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
	}
	public List<AllmessCustomerModel> isgetcustomer()
	{
		try {
			stmt=conn.prepareStatement("select *from candidates");
			rs=stmt.executeQuery();
			list=new ArrayList<AllmessCustomerModel>();
			while(rs.next())
			{
				allcust=new AllmessCustomerModel();

				allcust.setId(rs.getInt(1));
				allcust.setName(rs.getString(2));
				allcust.setEmail(rs.getString(3));
				allcust.setContact(rs.getString(4));

				list.add(allcust);
			}

			return list.size()>0?list:null;
		} 
		catch (Exception e) {
			System.out.println("Error is "+e);
			return null;
		}
	}
	
	public int ischeckcutomerpresent(String custmail) {
		try {
			stmt=conn.prepareStatement("select *from candidates where email=?");
			stmt.setString(1, custmail);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			else
			{
				return 0;
			}
			
		} 
		catch (Exception e) {
			System.out.println("Error is"+e);
			return 0;
		}
		
	}
	public int ischeckcutomerpresentattendance(String cemail) {
		try {
			
			stmt=conn.prepareStatement("select name ,aid from candidates inner join admission on candidates.cid=admission.cid where email=?");
			stmt.setString(1, cemail);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(2);
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
	public List<AllmessCustomerModel> isgetbillcustomer(String uemail) {
		try {
			stmt=conn.prepareStatement("select *from candidates where email=?");
			stmt.setString(1, uemail);
			list=new ArrayList<AllmessCustomerModel>();
			rs=stmt.executeQuery();
			if(rs.next())
			{
				allcust=new AllmessCustomerModel();

				allcust.setId(rs.getInt(1));
				allcust.setName(rs.getString(2));
				allcust.setEmail(rs.getString(3));
				allcust.setContact(rs.getString(4));

				list.add(allcust);
			}

			return list.size()>0?list:null;
		} 
		catch (Exception e) {
			System.out.println("Error is "+e);
			return null;
		}
		
	}
	
}
