package org.Mess.Service;

import org.Mess.Model.admisionModel;
import org.Mess.Repository.admisionRepository;

public class admisionService {

	admisionRepository admisionrepo=new admisionRepository();
	public boolean isaddadmision(admisionModel admisionmodel) {
		
		return admisionrepo.isaddadmision(admisionmodel);
	}
	public int isgettotal() {
		
		return admisionrepo.isgettotal();
	}

}
