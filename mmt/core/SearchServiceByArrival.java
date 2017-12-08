package mmt.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class SearchServiceByArrival extends FindService {

	private Station _st;

	SearchServiceByArrival (Station st) {
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
		List<Stop> ls = s.getStops();
		return ls.indexOf(stp) == (ls.size()-1);
	}


	void sortList(List<Service> lstService){
		Comparator<Service> compareServiceBySchedule = new Comparator<Service>() { 
			public int compare(Service sa, Service sb) {
			    List<Stop> lsa = sa.getStops();
			    List<Stop> lsb = sb.getStops();
                            int v = lsa.get(lsa.size()-1).getSchedule().compareTo(lsb.get(lsb.size()-1).getSchedule());

                            return v;
			}
		};
		Collections.sort(lstService, compareServiceBySchedule);
	}
}