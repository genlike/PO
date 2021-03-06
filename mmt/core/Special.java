package mmt.core;

public class Special extends Category{
/**
	* Classe responsavel pelo registo da categoria relativa ao passageiro
	* @author Ines Albano	 87664
	* @author Ricardo Silva  87700
	* @version 1.0
*/

	final static double DISCOUNT = 0.5;
	final static String DESCRIPTION = "ESPECIAL";


	double getDiscount(){
		return DISCOUNT;
	}

	String getCategoryDescription(){
		return this.DESCRIPTION;
	}

	double getPartOfPayingPrice(){
		return 1-getDiscount();
	}
}