package mmt.core;

public class Normal extends Category{
/**
	* Classe responsavel pelo registo da categoria relativa ao passageiro
	* @author Ines Albano	 87664
	* @author Ricardo Silva  87700
	* @version 1.0
*/

	final static double DISCOUNT = 0.0;
	final static String DESCRIPTION = "NORMAL";


	double getDiscount(){
		return DISCOUNT;
	}

	String getCategoryDescription(){
		return DESCRIPTION;
	}

	double getPartOfPayingPrice(){
		return 1-getDiscount();
	}
}