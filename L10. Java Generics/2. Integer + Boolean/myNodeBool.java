
public class myNodeBool {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private boolean myInfo;
	private myNodeBool myNext;
	
	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------
	public myNodeBool(boolean i, myNodeBool n){
		this.myInfo = i;
		this.myNext = n;
	}
	
	//--------------------------------------------------
	// Get methods
	//--------------------------------------------------
	public boolean get_my_info(){
		return this.myInfo;
	}
	
	public myNodeBool get_my_next(){
		return this.myNext;
	}
	
	//--------------------------------------------------
	// Set methods
	//--------------------------------------------------
	public void set_my_info(boolean i){
		this.myInfo = i;
	}
	
	public void set_my_next(myNodeBool n){
		this.myNext = n;
	}
	
}
