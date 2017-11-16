package mmt.core;

public class Passenger{

	private int 		_id;
	private String 		_name;
	private boolean 	_status;
	private double 		_totalCost;
	private int 		_totalTravelTime;
	private Category 	_category;

	protected Passenger(String name){
		setName(name);
	}

	protected String getName(){
		return _name;
	}

	protected void setName(String name){
		_name = name;
	}

	protected Category getCategory(){
		return _category;
	}

	protected void setCategory(Category category){
		_category = category;
	}

	/*protected Itenerary[] getIteneraryLista(){

	}*/

	protected int getId(){
		return _id;
	}

	protected boolean getStatus(){
		return _status;
	}

	protected void setStatus(boolean status){
		_status = status;
	}


}
