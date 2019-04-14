
public class myNode {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private Object myInfo;
	private myNode myNext;
	
	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------
	public myNode(Object i, myNode n){
		this.myInfo = i;
		this.myNext = n;
	}
	
	//--------------------------------------------------
	// Get methods
	//--------------------------------------------------
	public Object get_my_info(){
		return this.myInfo;
	}
	
	public myNode get_my_next(){
		return this.myNext;
	}
	
	//--------------------------------------------------
	// Set methods
	//--------------------------------------------------
	public void set_my_info(Object i){
		this.myInfo = i;
	}
	
	public void set_my_next(myNode n){
		this.myNext = n;
	}
	
}
