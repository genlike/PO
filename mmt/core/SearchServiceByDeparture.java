package mmt.core;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class SearchServiceByDeparture extends FindServiceByStation {

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