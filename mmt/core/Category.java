package mmt.core;

public abstract class Category{

	private String _description;
	private double _discount;

	protected Category(String description){
		_description = description;
		setDiscount(description);
	}

	protected String getCategory(){
		return _description;
	}

	protected double getDiscount(){
		return _discount;
	}

	protected void setDiscount(String description){
		if ( description == "Normal" )
			_discount = 0;
		else if ( description == "Frequent" )
			_discount = 0.15;
		else if ( description == "Special" )
			_discount = 0.5;
	}

	protected String toString(){
		return "" + _discount;
	}






}
