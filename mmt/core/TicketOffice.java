package mmt.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import mmt.core.exceptions.BadDateSpecificationException;
import mmt.core.exceptions.BadTimeSpecificationException;
import mmt.core.exceptions.ImportFileException;
import mmt.core.exceptions.MissingFileAssociationException;
import mmt.core.exceptions.NoSuchPassengerIdException;
import mmt.core.exceptions.NoSuchServiceIdException;
import mmt.core.exceptions.NoSuchStationNameException;
import mmt.core.exceptions.NoSuchItineraryChoiceException;
import mmt.core.exceptions.NonUniquePassengerNameException;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import mmt.app.main.Message;

//FIXME import other classes if necessary

/**
 * Façade for handling persistence and other functions.
 */
public class TicketOffice {

  /** The object doing most of the actual work. */
  private TrainCompany _trainCompany;

  //private Message _message;

  //FIXME define other fields

  public void reset() {
    // TODO clear Itenerary
    _trainCompany.getListPassageiros().clear();

  }

  // Apenas quer limpar os iternerarios e os passageiros

  public void save(String filename) throws FileNotFoundException, IOException{
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
    out.writeObject(_trainCompany);
    //_trainCompany = (TrainCompany)out.readObject();
    out.close();
  }

  public void load(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
    _trainCompany = (TrainCompany)in.readObject();
    in.close();
  }

  public void importFile(String datafile) throws ImportFileException {
    NewParser nP = new NewParser();
    _trainCompany = nP.parseFile(datafile);
  }

  //FIXME complete and implement the itinerary search (and pre-commit store) method
//  public /*FIXME choose return type */ searchItineraries(int passengerId, String departureStation, String arrivalStation, String departureDate,
//                                              String departureTime) /*FIXME define thrown exceptions */ {
    //FIXME implement method
//  }

  //FIXME complete and implement the itinerary commit method
//  public /*FIXME choose return type */ commitItinerary(int passengerId, int itineraryNumber) /*FIXME define thrown exceptions */ {
    //FIXME implement method
//  }

  //FIXME add methods for passenger registration and passenger name update
  
  //FIXME add other functions if necessary

  public List<String> exportListofServices() {
    List<String> listOfServices = new ArrayList<>();
    List<Service> listOfServicesId = new ArrayList<>(_trainCompany.getListService().values());

    Collections.sort(listOfServicesId);

    for (Service s : listOfServicesId){
      listOfServices.add(s.toString());
    }
    return listOfServices;
  }

  public void changePassengerName(int id, String newName) throws NoSuchPassengerIdException{
    //_trainCompany.changePassengerName(id, newName);
    Passenger p = _trainCompany.getlistPassageiros().get(id);
    if (p == null) {
      throw new NoSuchPassengerIdException(id);
    }
    p.setName(newName);
  }

  public void registerPassenger(String name){
    _trainCompany.addPassenger(name);
  }

  public List<String> exportListOfAllPassenger() {

    List<String> listAllPassengers = new ArrayList<>();
    List<Passenger> listPassengersId = new ArrayList<>(_trainCompany.getlistPassageiros().values());

    Collections.sort(listPassengersId);

    for (Passenger p : listPassengersId){
      listAllPassengers.add(p.toString());
    }
    return listAllPassengers;
  }

  public String showPassengerById(int id) throws NoSuchPassengerIdException {
    Passenger p =_trainCompany.getlistPassageiros().get(id);
    if (p == null) { throw new NoSuchPassengerIdException(id); }
    return p.toString();
  }

  public String showServiceById(int id) throws NoSuchServiceIdException{
    Service s = _trainCompany.getListService().get(id);
    if (s == null) { throw new NoSuchServiceIdException(id); }
    return s.toString();
  }

  public List<String> getIsServiceDeparture(String name) throws NoSuchStationNameException {
    List<String> listOfServices = new ArrayList<>();
    Station st = _trainCompany.getListEstacoes().get(name);
    
    if (st == null) { throw new NoSuchServiceIdException(name); }
    
    for (Stop stp: st.getStops()){
      Service s = stp.getService();
      if (s.isDeparture(stp)){
        listOfServices.add(s);
      }
    }
  }  
}
