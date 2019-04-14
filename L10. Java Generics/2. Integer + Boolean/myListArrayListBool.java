
import java.util.ArrayList;

public class myListArrayListBool implements myListBool {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private ArrayList<Boolean> items; 

	//-------------------------------------------------------------------
	// Basic Operation --> Create an empty myList: my_create_empty
	//-------------------------------------------------------------------
	//public myList my_create_empty(){}

	public myListArrayListBool(){
		this.items = new ArrayList<Boolean>();
	}
		
	//-------------------------------------------------------------------
	// Basic Operation --> Get number of integers in myList: my_get_length
	//-------------------------------------------------------------------	
	public int my_get_length(){
		return this.items.size();
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get integer of myList at a concrete index: my_get_element
	//-------------------------------------------------------------------
	public boolean my_get_element(int index){
		boolean value = false;
		
		try{			
			value = this.items.get(index);		
		}
		catch (Exception e){
			System.out.println("Sorry, not such an index to access");
		}
		
		return value;	
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Add integer to myList at a concrete index: my_add_element 
	//-------------------------------------------------------------------
	public void my_add_element(int index, boolean value){
		try{
			this.items.add(index, value);		
		}
		catch (Exception e){
			System.out.println("Sorry, not such an index to add");
		}		
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Remove index of myList: my_remove_element 
	//-------------------------------------------------------------------	
	public void my_remove_element(int index){
		try{			
			this.items.remove(index);		
		}
		catch (Exception e){
			System.out.println("Sorry, not such an index to remove");
		}		
	}
	
}

