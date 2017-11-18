package mmt.core;

import mmt.core.exceptions.BadDateSpecificationException;
import mmt.core.exceptions.BadEntryException;
import mmt.core.exceptions.BadTimeSpecificationException;
import mmt.core.exceptions.InvalidPassengerNameException;
import mmt.core.exceptions.NoSuchDepartureException;
import mmt.core.exceptions.NoSuchPassengerIdException;
import mmt.core.exceptions.NoSuchServiceIdException;
import mmt.core.exceptions.NoSuchStationNameException;
import mmt.core.exceptions.NoSuchItineraryChoiceException;
import mmt.core.exceptions.NonUniquePassengerNameException;

import java.util.Map;
import java.util.HashMap;

//FIXME import other classes if necessary

/**
 * A train company has schedules (services) for its trains and passengers that
 * acquire itineraries based on those schedules.
 */
public class TrainCompany implements java.io.Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201708301010L;

<<<<<<< HEAD
  private static int _nextPassengerID = 0;

  private ArrayList<Form> Passengers = new ArrayList<Form>();
=======
  private int _nextPassengerID = 0;
>>>>>>> master
  
  private Map<Integer,Service> listService;
  private Map<String,Station> listEstacoes;
  private Map<Integer,Passenger> listPassageiros;

  //TODO
  TrainCompany(){
    listService = new HashMap<>();
    listEstacoes = new HashMap<>();
    listPassageiros = new HashMap<>();
  }
  /*FIXME
   * add methods for
   *   registerPassenger, changePassengerName
   *   searchItineraries, commitItinerary
   */
  int getNextPassengerID(){
    return _nextPassengerID++;
  }
  
  Passenger addPassenger(String name) {
    Integer id = getNextPassengerID();
    Passenger p = new Passenger(id.intValue(), name);
    listPassageiros.put(id, p);
    return p;
  }
  
  Service addService(Integer id, double cost){
    Service s = new Service(id, cost);
    listService.put(id,s);
    return s;
  }
  //FIXME implement other functions if necessary
  Station addStation(String name){
    Station s = listEstacoes.get(name);
    if (!(s==null)) { return s; }
    s = new Station(name);
    listEstacoes.put(name, s);
    return s;
  }

  Map<Integer,Service> getListService(){ return listService; }
  Map<String,Station> getListEstacoes(){ return listEstacoes; }
  Map<Integer,Passenger> getlistPassageiros() { return listPassageiros; }


}
