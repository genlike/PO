package mmt.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import mmt.core.exceptions.ImportFileException;
import mmt.core.exceptions.NoSuchPassengerIdException;
import mmt.core.exceptions.NoSuchServiceIdException;
import mmt.core.exceptions.NoSuchStationNameException;
import mmt.core.exceptions.BadDateSpecificationException;
import mmt.core.exceptions.BadTimeSpecificationException;
import mmt.core.exceptions.NoSuchItineraryChoiceException;
import mmt.core.exceptions.NonUniquePassengerNameException;

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
    _trainCompany.reset();
  }


  /**
     * Metodo que trata de guardar o _trainCompany num determinado ficheiro 
     * @param filename do tipo String
     * @throws IOException quando existe problema no ficheiro para exportacao da informacao
     */
  public void save(String filename) throws IOException{
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
    out.writeObject(_trainCompany);
    out.close();
  }


  /**
     * Metodo que trata de ler o ficheiro de input 
     * @param filename do tipo String
     * @throws FileNotFoundException, IOException, ClassNotFoundException quando ha problema com o ficheiro existente
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
     * @throws ImportFileException quando ha' problema na importacao do ficheiro
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
    return _trainCompany.exportListofServices();
  }

  /**
     * Metodo que trata de listar servicos por partida
     * @param name do tipo String
     * @return lista de servicos com determinado local de partida 
     * @throws NoSuchStationNameException quando o nome da estacao dada nao existe
     */
  public String getIsServiceDeparture(String name) throws NoSuchStationNameException {
    return _trainCompany.getIsServiceDeparture(name);
  }  

  /**
     * Metodo que trata de listar servicos por partida
     * @param name do tipo String
     * @return lista de servicos com determinado local de partida 
     * @throws NoSuchStationNameException quando o nome da estacao dada nao existe
     */
  public String getIsServiceArrival(String name) throws NoSuchStationNameException {
    return _trainCompany.getIsServiceArrival(name);
  } 

  /**
     * Metodo que trata de alterar o nome de um passageiro ja existente
     * @param id do tipo int, newName do tipo String
     * @throws NoSuchPassengerIdException quando o id do passageiro e' invalido
     */
  public void changePassengerName(int id, String newName) throws NoSuchPassengerIdException{
    _trainCompany.changePassengerName(id, newName);
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
    return _trainCompany.exportListOfAllPassenger();
  }


  /**
     * Metodo que trata de listar passageiros por id
     * @param id do tipo int
     * @return String com passageiros ordenados
     * @throws NoSuchPassengerIdException quando o id do passageiro e' invalido 
     */
  public String showPassengerById(int id) throws NoSuchPassengerIdException {
    return _trainCompany.showPassengerById(id);
  }


  /**
     * Metodo que trata de listar passageiros com dado id
     * @param id do tipo int
     * @return String com passageiro de id 
     * @throws NoSuchServiceIdException quando o nome do servico nao e' valido 
     */
  public String showServiceById(int id) throws NoSuchServiceIdException{
    return _trainCompany.showServiceById(id);
  }


  /**
     * Metodo que retorna a string com a lista de todos os itenerarios 
     * @return string com a lista de itenerarios
     */
  public String exportListOfAllItineraries() {
    return _trainCompany.exportListOfAllItineraries();
  }

  /**
     * Metodo que retorna a lista de itenerarios de um determinado passageiro 
     * @param id do tipo int
     * @return string com a lista de itenerarios do passageiro
     */
  public String showItinerariesById(int id) throws NoSuchPassengerIdException {
    return _trainCompany.showItinerariesById(id);
  }
  

  /**
     * Metodo que retorna uma string com os itenerios com os requisitos 
     * @param estcao de partida do tipo String, estacao de chegada do tipo String, 
     *        data de partida do tipo String, hora de partida do tipo String
     * @return string com os itenerarios
     */
  public String searchItinerary(String departureStation, String arrivalStation, String departureDate, String departureHour) 
	 throws NoSuchPassengerIdException, NoSuchStationNameException, BadDateSpecificationException, BadTimeSpecificationException {
    return _trainCompany.searchItinerary(departureStation, arrivalStation, departureDate, departureHour); 
  }

  
  /**
     * Metodo que trata de fazer a compra do itenerario  
     * @param id do passageiro do tipo int, numero de escolhas do tipo int
     */
  public void commitItinerary (int p, int itChoice) throws NoSuchPassengerIdException, NoSuchItineraryChoiceException {
    _trainCompany.commitItinerary(p, itChoice);
  }

 }