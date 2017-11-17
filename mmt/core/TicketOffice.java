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

import mmt.core.TrainCompany;
//FIXME import other classes if necessary

/**
 * Façade for handling persistence and other functions.
 */
public class TicketOffice {

  /** The object doing most of the actual work. */
  private TrainCompany _trainCompany;

  //FIXME define other fields

  public void reset() {
  }
  // Apenas quer limpar os iternerarios e os passageiros

  public void save(String filename) throws FileNotFoundException, IoException{
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
    out.writeObject(_trainCompany);
    _trainCompany = (TrainCompany)out.realObject();
    out.close();
  }

  public void load(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
    ObjectInputStream in = new ObjectInputStream(new FileOutputStream(filename));
    _trainCompany = (TrainCompany)in.realObject();
    in.close();
  }

  public void importFile(String datafile) throws ImportFileException {
    _trainCompany.importFile(datafile);
  }

  //FIXME complete and implement the itinerary search (and pre-commit store) method
  public /*FIXME choose return type */ searchItineraries(int passengerId, String departureStation, String arrivalStation, String departureDate,
                                              String departureTime) /*FIXME define thrown exceptions */ {
    //FIXME implement method
  }

  //FIXME complete and implement the itinerary commit method
  public /*FIXME choose return type */ commitItinerary(int passengerId, int itineraryNumber) /*FIXME define thrown exceptions */ {
    //FIXME implement method
  }

  //FIXME add methods for passenger registration and passenger name update

  //FIXME add other functions if necessary

}
