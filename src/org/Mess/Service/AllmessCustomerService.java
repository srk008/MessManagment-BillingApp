package org.Mess.Service;
import java.util.*;

import org.Mess.Model.AllmessCustomerModel;
import org.Mess.Repository.AllmessCustomerRepository;

public class AllmessCustomerService {
	ArrayList<AllmessCustomerModel> list=new ArrayList<AllmessCustomerModel>(); 
	AllmessCustomerRepository allcustrepo=new AllmessCustomerRepository();
	public boolean isAddCustomer(AllmessCustomerModel allcust)
	{
		return allcustrepo.isAddCustomer(allcust);
	}
	
	public List<AllmessCustomerModel> isgetcustomer()
	{
		return allcustrepo.isgetcustomer();
	}

	public int ischeckcutomerpresent(String custmail) {
		
		return allcustrepo.ischeckcutomerpresent(custmail);
	}

	public int ischeckcutomerpresentattendance(String cemail) {
		
		return allcustrepo.ischeckcutomerpresentattendance(cemail);
	}

	public List<AllmessCustomerModel> isgetbillcustomer(String uemail) {
		
		return allcustrepo.isgetbillcustomer(uemail);
	}

	

	
}
