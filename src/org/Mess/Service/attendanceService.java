package org.Mess.Service;

import org.Mess.Model.attendanceModel;
import org.Mess.Repository.attendanceRepository;

public class attendanceService {

	attendanceRepository attendrepo=new attendanceRepository();
	public boolean isaddPresent(attendanceModel attendmodel) {
		
		return attendrepo.isaddPresent(attendmodel);
	}

}
