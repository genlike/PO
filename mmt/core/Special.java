package mmt.core;

public class Special extends Category{
/**
	* Classe responsavel pelo registo da categoria relativa ao passageiro
	* @author Ines Albano	 87664
	* @author Ricardo Silva  87700
	* @version 1.0
*/

	private static double _discount = 0.5;
	private static String _description = Category.Special();


	double getDiscount(){
		return _discount;
	}

	String getCategoryDescription(){
		return _description;
	}
}