
public class myPair {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private Object first;
	private Object second;
	
	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------
	public myPair(Object f, Object s){
		this.first = f;
		this.second = s;
	}
	
	//--------------------------------------------------
	// Get methods
	//--------------------------------------------------
	public Object getFirst(){
		return this.first;
	}

	public Object getSecond(){
		return this.second;
	}
	
	//--------------------------------------------------
	// Set methods
	//--------------------------------------------------
	public void setFirst(Object i){
		this.first = i;
	}

	public void setSecond(Object i){
		this.second = i;
	}
	
}
