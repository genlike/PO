package mmt.core;

import java.util.List;
import java.util.ArrayList;

public class Station implements java.io.Serializable {
/**
	* Classe que representa uma Estacao, que é composto por uma agregacao de Paragens
	* @author Ines Albano	 87664
	* @author Ricardo Silva  87700
	* @version 1.0
*/
/**
	* String usada para identificar a estacao
*/
	private String _description;
/**
	* Lista de paragens para conseguir identificar os varios servicoes desta estacao
*/
	private List<Stop> _listStops;
/**
	* Construtor
	* @param description Descricao da estacao 
*/
	Station(String description){
		setDescription(description);
		_listStops = new ArrayList<>();
	}

/**
	* Retorna a descricao da estacao
*/	
	String getDescription(){
		return _description;
	}
/**
	* Funcao para alterar a descricao da estacao.
	* @param description nova descricao da estacao.
*/
	void setDescription(String description){
		_description = description;		
	}
/**
	* Funcao que cria a ligacao da estacao com dado servico atravez da sua paragem
	* @param a Adiciona dada paragem a lista de paragens 
*/
	void addStop(Stop a){
		_listStops.add(a);
	}
/**
	* Retorna as paragens desta estacao.
*/	
	List<Stop> getStops(){
		return _listStops;
	}
/**
	* Retorna a descricao da estacao.
*/
	public String toString() {
		return _description;
	}
}