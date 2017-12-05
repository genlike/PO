package mmt.core;

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
import java.util.Map;
import java.util.HashMap;


/**
  * A train company has schedules (services) for its trains and passengers that
  * acquire itineraries based on those schedules.
  */

public class TrainCompany implements java.io.Serializable {
  /**
    * Classe responsavel pelo funcionamento das classes do core
    * @author Ines Albano    87664
    * @author Ricardo Silva  87700
    * @version 1.0
    */

  /** 
    * Serial number for serialization. 
    */
  private static final long serialVersionUID = 201708301010L;

  /** 
    * Atributo relativo ao id do Passageiro, comeca em 0 
    */
  private int _nextPassengerID = 0;
  
  /**
    * listService - Serve para guardar a lista de todos os servicos
    */
  private Map<Integer,Service> _listService;
    /**
      * listEstacoes - Serve para guardar a lista de estacoes 
      */
  private Map<String,Station> _listEstacoes;
  /**
    * listPassageiros - Serve para guardar a lista de todos os passageiros
    */
  private Map<Integer,Passenger> _listPassageiros;


  /**
    * Contrutor que comeca por inicializar as listas de servicos, 
    * passageiros e estacoes
    */
  TrainCompany(){
    _listService     = new HashMap<>();
    _listEstacoes    = new HashMap<>();
    _listPassageiros = new HashMap<>();
  }


  /**
    * Metodo que trata de incrementar o id do proximo passageiro
    * Fica pronto para ser adicionado outro
    * @return _nextPassengerID retorna o id e incrementa.
    */
  int getNextPassengerID(){
    return _nextPassengerID++;
  }
  
  /**
     * Metodo que trata de limpar a lista de passageiros
     * Posteriormente limpara a lista de itenerarios a qual os clientes estao relacionados
     */
  void reset() {
    _listPassageiros.clear();
  }
  /**
    * Metodo que trata de adicionar um novo passageiro a lista de passageiros
    * @param name do tipo String
    * @return p novo passageiro que foi adicionado
    */
  Passenger addPassenger(String name) {
    Integer id = getNextPassengerID();
    Passenger p = new Passenger(id.intValue(), name);
    _listPassageiros.put(id, p);
    return p;
  }
  

  /**
    * Metodo que trata de adicionar um novo servico a lista de servicos
    * @param id do tipo int, cost do tipo double
    * @return s novo servico que foi adicionado
    */
  Service addService(Integer id, double cost){
    Service s = new Service(id, cost);
    _listService.put(id,s);
    return s;
  }
 

  /**
    * Metodo que trata de adicionar uma nova estacao a lista de estacoes
    * caso a estacao ja exista devolve a instancia desta
    * @param name do tipo String
    * @return s nova estacao que foi adicionada
    */
  Station addStation(String name){
    Station s = _listEstacoes.get(name);
    if (!(s==null)) { return s; }
    s = new Station(name);
    _listEstacoes.put(name, s);
    return s;
  }


  Station getStation(String name) throws NoSuchStationNameException{
    Station s = _listEstacoes.get(name);
    if ((s==null)){ throw new NoSuchStationNameException(name); }
    return s;
  }

  /**
     * Metodo que imprime dado servico dado o id
     * @param id do tipo int
     * @return String com passageiro de id 
     * @throws NoSuchServiceIdException quando o nome do servico nao e' valido 
     */
  String showServiceById(int id) throws NoSuchServiceIdException{
    Service s = _listService.get(id);
    if (s == null) { throw new NoSuchServiceIdException(id); }
    return s.toString();
  }
  /**
     * Metodo que imprime dado passageiro dado o id
     * @param id do tipo int
     * @return String com passageiros ordenados
     * @throws NoSuchPassengerIdException quando o id do passageiro e' invalido 
     */
  String showPassengerById(int id) throws NoSuchPassengerIdException {
    Passenger p = _listPassageiros.get(id);
    if (p == null) { throw new NoSuchPassengerIdException(id); }
    return p.toString();
  }
  /**
     * Metodo que trata de lista todos os passageiros ordenado por id
     * @return String com os passageiros ordenados
     */
  String exportListOfAllPassenger() {

    String stringAllPassengers = new String();
    List<Passenger> listPassengersId = new ArrayList<>(_listPassageiros.values());

    Collections.sort(listPassengersId);

    for (Passenger p : listPassengersId){
      stringAllPassengers += p.toString() + "\n";
    }

    return stringAllPassengers;
  }
  
   /**
     * Metodo que trata de alterar o nome de um passageiro ja existente
     * @param id do tipo int, newName do tipo String
     * @throws NoSuchPassengerIdException quando o id do passageiro e' invalido
     */
  void changePassengerName(int id, String newName) throws NoSuchPassengerIdException{
    Passenger p = _listPassageiros.get(id);
    if (p == null) { throw new NoSuchPassengerIdException(id); }
    p.setName(newName);
  }
  /**
     * Metodo que trata ordenar a Lista de Servicos, ordenado pelo id
     * @return String com os servicos ordenados
     */
  String exportListofServices() {
    String stringOfServices = new String();
    List<Service> listOfServicesId = new ArrayList<>(_listService.values());

    Collections.sort(listOfServicesId);

    for (Service s : listOfServicesId){
      stringOfServices += s.toString()+"\n";
    }
    return stringOfServices;
  }


  /**
     * Retorna a impressao de servicos onde dada estacao e de partida, ordenada pela hora de partida
     * @param name do tipo String
     * @return lista de servicos com determinado local de partida 
     * @throws NoSuchStationNameException quando o nome da estacao dada nao existe
     */
  String getIsServiceDeparture(String name) throws NoSuchStationNameException {
    String stringOfServices = new String();
    Map<LocalTime,Service> listOfServices = new TreeMap<LocalTime, Service>();
    Station st = _listEstacoes.get(name);
    
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



  Segment newSegment(int serviceId, String origin, String destiny) throws NoSuchStationNameException{
    Service s = _listService.get(id);
    Station departure = getStation(origin);
    Station arrival = getStation(destiny);

    Stop st1 = s.getStop(departure);
    Stop st2 = s.getStop(arrival);

    return new Segment(st1, st2);
  }


  Passenger getPassenger(int id){
    return _listPassageiros.get(id);
  }


}