
public class myTuple<T1,T2,T3> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private T1 first;
	private T2 second;
	private T3 third;
	
	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------
	public myTuple(T1 f, T2 s, T3 t){
		this.first = f;
		this.second = s;
		this.third = t;
	}
	
	//--------------------------------------------------
	// Get methods
	//--------------------------------------------------
	public T1 getFirst(){
		return this.first;
	}

	public T2 getSecond(){
		return this.second;
	}

	public T3 getThird(){
		return this.third;
	}
	
	//--------------------------------------------------
	// Set methods
	//--------------------------------------------------
	public void setFirst(T1 i){
		this.first = i;
	}

	public void setSecond(T2 i){
		this.second = i;
	}

	public void setThird(T3 i){
		this.third = i;
	}
	
}
