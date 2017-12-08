package mmt.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SearchServiceByDeparture extends FindService {

	private Station _st;

	SearchServiceByDeparture (Station st) {
		_st = st;
	}

	List<Service> fillService() {
		List<Service> lstService = new ArrayList<>();
		for (Stop stp: _st.getStops()){
			if (isAcceptable(stp)) {
				lstService.add(stp.getService());
			}
		}

		sortList(lstService);

		return lstService;
	}

	boolean isAcceptable(Stop stp) {
		Service s = stp.getService();
		return s.getStops().indexOf(stp) == 0;
	}
	
	void sortList(List<Service> lstService){
		Comparator<Service> compareServiceBySchedule = new Comparator<Service>() { 
			public int compare(Service sa, Service sb) {

                            int v = sa.getStops().get(0).getSchedule().compareTo(sb.getStops().get(0).getSchedule());

                            return v;
			}
		
		};
		Collections.sort(lstService, compareServiceBySchedule);
	}
}