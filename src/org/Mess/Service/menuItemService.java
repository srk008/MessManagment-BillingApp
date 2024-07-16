package org.Mess.Service;

import java.util.List;

import org.Mess.Model.menuModel;
import org.Mess.Repository.menuItemRepository;
	
public class menuItemService {
	List <menuModel> list;
	menuItemRepository m=new menuItemRepository(); 
  public boolean isAddItem(menuModel menu)
   {
	   return m.isAddItem(menu);
   }
  
  public List<menuModel> isgetMenu()
  {
	  return m.isgetMenu();
  }

public boolean isupdatelunchPrice(int nlunchprice, String lunchName) {
	
	return m.isupdatelunchPrice(nlunchprice,lunchName);
}

public boolean ischecklunchname(String lunchName) {
	
	return m.ischecklunchname(lunchName);
}


}
