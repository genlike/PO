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
import java.time.LocalTime;
import java.util.Map;
import java.util.TreeMap;
import mmt.app.main.Message;


/**
 * Façade for handling persistence and other functions.
 */

public class TicketOffice {
  /**
  * Classe responsavel pelo funcionamento da aplicacao
  * @author Ines Albano    87664
  * @author Ricardo Silva  87700
  * @version 1.0
  */


  /** The object doing most of the actual work. */
  private TrainCompany _trainCompany;


  /**
     * Contrutor que comeca por inicializar o objeto que faza maior parte do trabalho)
     */
  public TicketOffice(){
    _trainCompany = new TrainCompany();
  }


  /**
     * Metodo que trata de limpar a lista de passageiros
     * Posteriormente limpara a lista de itenerarios
     */
  public void reset() {
    // TODO clear Itenerary
    _trainCompany.getlistPassageiros().clear();
  }


  /**
     * Metodo que trata de guardar o _trainCompany num determinado ficheiro 
     * @param filename do tipo String
     */
  public void save(String filename) throws IOException{
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
    out.writeObject(_trainCompany);
    out.close();
  }


  /**
     * Metodo que trata de ler o ficheiro de input 
     * @param filename do tipo String
     */
  public void load(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
    _trainCompany = (TrainCompany)in.readObject();
    in.close();
  }

  /**
     * Metodo que trata de importar o ficheiro de input
     * Passa pelo NewParser
     * @param datafile do tipo String
     */
  public void importFile(String datafile) throws ImportFileException {
    NewParser nP = new NewParser();
    _trainCompany = nP.parseFile(datafile);
  }


  /**
     * Metodo que trata ordenar a Lista de Servicos 
     * @return String com os servicos ordenados
     */
  public String exportListofServices() {
    String stringOfServices = new String();
    List<Service> listOfServicesId = new ArrayList<>(_trainCompany.getListService().values());

    Collections.sort(listOfServicesId);

    for (Service s : listOfServicesId){
      stringOfServices += s.toString()+"\n";
    }
    return stringOfServices;
  }


  /**
     * Metodo que trata de listar servicos por partida
     * @param name do tipo String
     * @return lista de servicos com determinado local de partida 
     */
  public String getIsServiceDeparture(String name) throws NoSuchStationNameException {
    String stringOfServices = new String();
    Map<LocalTime,Service> listOfServices = new TreeMap<LocalTime, Service>();
    Station st = _trainCompany.getListEstacoes().get(name);
    
    if (st == null) { throw new NoSuchStationNameException(name); }
    
    for (Stop stp: st.getStops()){
      Service s = stp.getService();
      if (s.isDeparture(stp)){
        listOfServices.put(stp.getSchedule(), s);
      }
    }


    for(Service s : listOfServices.values()){
      stringOfServices += s.toString() + "\n";
    }
    return stringOfServices;
  }  



  /**
     * Metodo que trata de alterar o nome de um passageiro ja existente
     * @param id do tipo int, newName do tipo String
     */
  public void changePassengerName(int id, String newName) throws NoSuchPassengerIdException{
    Passenger p = _trainCompany.getlistPassageiros().get(id);
    if (p == null) {
      throw new NoSuchPassengerIdException(id);
    }
    p.setName(newName);
  }


  /**
     * Metodo que trata de registar um passageiro
     * @param name do tipo String
     */
  public void registerPassenger(String name){
    _trainCompany.addPassenger(name);
  }


  /**
     * Metodo que trata de ordenar a Lista de Passegeiros 
     * @return String com os passageiros ordenados
     */
  public String exportListOfAllPassenger() {

    String stringAllPassengers = new String();
    List<Passenger> listPassengersId = new ArrayList<>(_trainCompany.getlistPassageiros().values());

    Collections.sort(listPassengersId);

    for (Passenger p : listPassengersId){
      stringAllPassengers += p.toString() + "\n";
    }
    return stringAllPassengers;
  }


  /**
     * Metodo que trata de listar passageiros por id
     * @param id do tipo int
     * @return String com passageiros ordenados 
     */
  public String showPassengerById(int id) throws NoSuchPassengerIdException {
    Passenger p =_trainCompany.getlistPassageiros().get(id);
    if (p == null) { throw new NoSuchPassengerIdException(id); }
    return p.toString();
  }


  /**
     * Metodo que trata de listar passageiros com dado id
     * @param id do tipo int
     * @return String com passageiro de id  
     */
  public String showServiceById(int id) throws NoSuchServiceIdException{
    Service s = _trainCompany.getListService().get(id);
    if (s == null) { throw new NoSuchServiceIdException(id); }
    return s.toString();
  }
}