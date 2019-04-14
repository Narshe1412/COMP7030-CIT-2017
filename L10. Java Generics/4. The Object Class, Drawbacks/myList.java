
public interface myList {
	
	//-------------------------------------------------------------------
	// Basic Operation --> Create an empty myList: my_create_empty
	//-------------------------------------------------------------------
		//public myList my_create_empty(); --> Java does not support constructors in interfaces. Use instead:
											   //myListArray()	
											   //myListArrayList()
			
	//-------------------------------------------------------------------
	// Basic Operation --> Get number of integers in myList: my_get_length
	//-------------------------------------------------------------------	
	public int my_get_length();
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get integer of myList at a concrete index: my_get_element
	//-------------------------------------------------------------------
	public Object my_get_element(int index);
		
	//-------------------------------------------------------------------
	// Basic Operation --> Add integer to myList at a concrete index: my_add_element 
	//-------------------------------------------------------------------
	public void my_add_element(int index, Object value);
	
	//-------------------------------------------------------------------
	// Basic Operation --> Remove index of myList: my_remove_element 
	//-------------------------------------------------------------------	
	public void my_remove_element(int index);
	
}
