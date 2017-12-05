package mmt.core;

public class Segment{

	private Stop _origin;
	private Stop _destiny;


	Segment(Stop origin, Stop destiny){
		_origin  = origin;
		_destiny = destiny;
	}

	double getCost(){
		Service s = _origin.getService();
		return s.getCost(_origin, _destiny);
	}

	Duration getDuration(){
		Service s = _origin.getService();
		return s.getDuration(_origin, _destiny); 
	}

	//TODO toString que chama o toString do Service
}