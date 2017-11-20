package mmt.core;

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
  private Map<Integer,Service> listService;
    /**
      * listEstacoes - Serve para guardar a lista de estacoes 
      */
  private Map<String,Station> listEstacoes;
  /**
    * listPassageiros - Serve para guardar a lista de todos os passageiros
    */
  private Map<Integer,Passenger> listPassageiros;


  /**
    * Contrutor que comeca por inicializar as listas de servicos, passageiros e estacoes
    */
  TrainCompany(){
    listService = new HashMap<>();
    listEstacoes = new HashMap<>();
    listPassageiros = new HashMap<>();
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
    * Metodo que trata de adicionar um novo passageiro a lista de passageiros
    * @param name do tipo String
    * @return p novo passageiro que foi adicionado
    */
  Passenger addPassenger(String name) {
    Integer id = getNextPassengerID();
    Passenger p = new Passenger(id.intValue(), name);
    listPassageiros.put(id, p);
    return p;
  }
  

  /**
    * Metodo que trata de adicionar um novo servico a lista de servicos
    * @param id do tipo int, cost do tipo double
    * @return s novo servico que foi adicionado
    */
  Service addService(Integer id, double cost){
    Service s = new Service(id, cost);
    listService.put(id,s);
    return s;
  }
 

  /**
    * Metodo que trata de adicionar uma nova estacao a lista de estacoes
    * @param name do tipo String
    * @return s nova estacao que foi adicionada
    */
  Station addStation(String name){
    Station s = listEstacoes.get(name);
    if (!(s==null)) { return s; }
    s = new Station(name);
    listEstacoes.put(name, s);
    return s;
  }


  /**
    * Metodo que trata de dar a lista de servicos totais, 
    * e retornado mesmo a lista concreta porque queremos dar parte do
    * ownership de alterar estas listas a classe que usar esta instancia
    * @return listaService que e a lista de todos os servicos
    */
  Map<Integer,Service> getListService() { 
	return listService; 
  }

  /**
    * Metodo que trata de dar a lista de estacoes totais
    * e retornado mesmo a lista concreta porque queremos dar parte do
    * ownership de alterar estas listas a classe que usar esta instancia
    * @return listaEstacoes que e a lista de todas as estacoes
    */
  Map<String,Station> getListEstacoes() { 
	return listEstacoes; 
  }


  /**
    * Metodo que trata de dar a lista de passageiros totais
    * e retornado mesmo a lista concreta porque queremos dar parte do
    * ownership de alterar estas listas a classe que usar esta instancia
    * @return listaPassageiros que e a lista de todos os passageiros
    */
  Map<Integer,Passenger> getlistPassageiros() { 
	return listPassageiros; 
  }

}