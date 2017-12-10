package mmt.core;

public abstract class Category implements java.io.Serializable {
/**
	* Classe responsavel pelo registo da categoria relativa ao passageiro
	* @author Ines Albano	 87664
	* @author Ricardo Silva  87700
	* @version 1.0
	*/

/**
   * Devolve a categoria 
   * @return _description do tipo String
   */
	abstract String getCategoryDescription();

/**
   * Devolve qual o desconto relativo a cada categoria 
   * @return _discount do tipo double
   */
	abstract double getDiscount();

/**
   * Devolve qual a fracao do preco a pagar dependendo do desconto 
   * @return _discount do tipo double
   */
	abstract double getPartOfPayingPrice();
	
	@Override
	public String toString(){
		return "" + getCategoryDescription();
	}

}
