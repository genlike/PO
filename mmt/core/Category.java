package mmt.core;

public abstract class Category{
/**
	* Classe responsavel pelo registo da categoria relativa ao passageiro
	* @author Ines Albano	 87664
	* @author Ricardo Silva  87700
	* @version 1.0
	*/

/**
	* _description atributo que ira guardar qual a categoria do passageiro
	* _discount atibuto que contem o desconto relativo a cada categoria
	*/
	private String _description;
	private double _discount;


/**
   * Construtor preenche a descricao
   * O desconto e' preenchido de acordo com a categoria
   * @param description do tipo String
   */
	protected Category(String description){
		_description = description;
		setDiscount(description);
	}

/**
   * Devolve a categoria 
   * @return _description do tipo String
   */
	protected String getCategoryDescription(){
		return _description;
	}

/**
   * Define qual o desconto relativo a uma dada categoria
   * @param description do tipo String
   */
	protected void setDiscount(String description){
		if ( description == "Normal" )
			_discount = 0;
		else if ( description == "Frequent" )
			_discount = 0.15;
		else if ( description == "Special" )
			_discount = 0.5;
	}

/**
   * Devolve qual o desconto relativo a cada categoria 
   * @return _discount do tipo double
   */
	protected double getDiscount(){
		return _discount;
	}
// Este desconto e' relativo a cada cliente ou e' o da categoria?

@Override
	protected String toString(){
		return "" + _discount;
	}






}
