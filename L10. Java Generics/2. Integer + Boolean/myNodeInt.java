
public class myNodeInt {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private int myInfo;
	private myNodeInt myNext;
	
	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------
	public myNodeInt(int i, myNodeInt n){
		this.myInfo = i;
		this.myNext = n;
	}
	
	//--------------------------------------------------
	// Get methods
	//--------------------------------------------------
	public int get_my_info(){
		return this.myInfo;
	}
	
	public myNodeInt get_my_next(){
		return this.myNext;
	}
	
	//--------------------------------------------------
	// Set methods
	//--------------------------------------------------
	public void set_my_info(int i){
		this.myInfo = i;
	}
	
	public void set_my_next(myNodeInt n){
		this.myNext = n;
	}
	
}
