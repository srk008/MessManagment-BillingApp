package org.Mess.Service;

import java.util.List;

import org.Mess.Model.dinnerModel;
import org.Mess.Repository.dinnerRepository;

public class dinnerService {
	
	dinnerRepository dr=new dinnerRepository();
	public boolean isAddDinner(dinnerModel dmodel)
	{
		return dr.isAddDinner(dmodel);
		
	}
	public List<dinnerModel> isgetDinner() 
	{
		
		return dr.isgetDinner();
	}
	public boolean isdelete(String dinnerid) {
		
		return dr.isdelete(dinnerid);
	}
	public boolean ischeckDinnerName(String dinnerName) {
		
		return dr.ischeckDinnerName(dinnerName);
	}
	public boolean isupdatedinnerPrice(int dinnerPrice, String dinnerName) {
		return dr.isupdatedinnerPrice(dinnerPrice,dinnerName);
	}

}
