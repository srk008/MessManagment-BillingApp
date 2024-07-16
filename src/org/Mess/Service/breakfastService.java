package org.Mess.Service;
import java.util.*;
import org.Mess.Model.breakfastModel;
import org.Mess.Repository.breakfastRepository;

public class breakfastService {

		breakfastRepository bfast=new breakfastRepository();
		
		public boolean isAddBreakfast(breakfastModel bmodel)
		{
			return bfast.isAddBreakfast(bmodel);
		}
		
		public List<breakfastModel> isgetBreakfast()
		{
			return bfast.isgetBreakfast();
		}

		public boolean isdelete(String did) {
			
			return bfast.isdelete(did);
		}

		public boolean ischeckName(String bname) {
			
			return bfast.ischeckName(bname);
		}

		public boolean isupdateName(String bname, String nname) {
			
			return bfast.isupdateName(bname,nname);
		}

		public boolean ischeckPrice(String pname) {
			
			return bfast.ischeckPrice(pname);
		}

		public boolean isupdatePrice(String bname, int nprice) {
			
			return bfast.isupdatePrice(bname,nprice);
		}
}
