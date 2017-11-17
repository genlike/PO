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

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

//FIXME import other classes if necessary

/**
 * A train company has schedules (services) for its trains and passengers that
 * acquire itineraries based on those schedules.
 */
public class TrainCompany implements java.io.Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 201708301010L;

  private int _nextPassengerID = 0;
  
  private List<Service> listaServicos = new ArrayList<Service>();
  private List<Station> listaEstacoes = new ArrayList<Station>();
  private Map<int,Passenger> listaPassageiros = new HashMap<>();

  //TODO
  /*FIXME
   * add methods for
   *   registerPassenger, changePassengerName
   *   searchItineraries, commitItinerary
   */
  int getNextPassangerID(){
    return _nextPassengerID++;
  }
  
  //Passenger criarPassageiro(String name) {
  
  //}
  
  //FIXME implement other functions if necessary

}
