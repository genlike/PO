package mmt.core;

import java.util.List;
import java.util.ArrayList;



public abstract class  FindServiceByStation {

	List<Service> findServicesByStation(Station st) {
		List<Service> lstService = new ArrayList<>();
		for (Stop stp: st.getStops()){
			if (isAcceptable(stp)) {
				lstService.add(stp.getService());
			}
		}

		sortList(lstService);

		return lstService;
	}
	
	abstract boolean isAcceptable(Stop st);
	abstract void sortList(List<Service> lstService);
}