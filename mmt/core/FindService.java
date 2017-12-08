package mmt.core;

import java.util.List;
import java.util.Collections;


public abstract class  FindService {

	abstract List<Service> fillService();
	abstract void sortList(List<Service> lstService);


	List<Service> getResultListService() {
		List<Service> lstS = fillService();
		sortList(lstS);
		return Collections.unmodifiableList(lstS); }
	
	public String toString() {
		String stringOfServices = new String();

    		List<Service> lstS = fillService();
		sortList(lstS);
		
    		for(Service s : lstS){
      			stringOfServices += s.toString() + "\n";
    		}
    		return stringOfServices;
	}
}