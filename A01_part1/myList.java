
public interface myList {
	
	//-------------------------------------------------------------------
	// Basic Operation 1. --> Create an empty MyList: create_empty
	//-------------------------------------------------------------------
	//public myList create_empty(); --> Java does not support constructors in interfaces
										//Use public myListArrayList() instead.
	
	//-------------------------------------------------------------------
	// Basic Operation 2. --> Get number of elements in MyList: my_get_length
	//-------------------------------------------------------------------	
	public int my_get_length();
	
	//-------------------------------------------------------------------
	// Basic Operation 3. --> Get element at of MyList at a concrete position: my_get_element
	//-------------------------------------------------------------------
	public myPlayer my_get_element(int index);
		
	//-------------------------------------------------------------------
	// Basic Operation 4. --> Add element to MyList at a concrete position: my_add_element 
	//-------------------------------------------------------------------
	public void my_add_element(int index, myPlayer player);
	
	//-------------------------------------------------------------------
	// Basic Operation 5. --> Remove element of MyList at a concrete position: my_remove_element 
	//-------------------------------------------------------------------	
	public void my_remove_element(int index);	
	
	//-------------------------------------------------------------------
	// Extended Operation 1. Load a MyList from file: load_file
	//-------------------------------------------------------------------
	public void load_file(String s);

	//-------------------------------------------------------------------
	// Extended Operation 2. Display MyFile content: show_elements
	//-------------------------------------------------------------------
	public void show_elements();

	//-------------------------------------------------------------------
	// Extended Operation 3. Find element in MyList: find_element
	//-------------------------------------------------------------------
	public int find_element(String s);

	//-------------------------------------------------------------------
	// Extended Operation 4. Show info of element in MyList: show_info
	//-------------------------------------------------------------------
	public void show_info(String s);
	
	//-------------------------------------------------------------------
	// Extended Operation 5. Add new element to MyList: add_by_keyboard
	//-------------------------------------------------------------------
	public void add(String s, int i);

	//-------------------------------------------------------------------
	// Extended Operation 6. Update element of MyList: update
	//-------------------------------------------------------------------
	public void update(String s, int g);
	
	//-------------------------------------------------------------------
	// Extended Operation 7. Remove element of MyList: remove
	//-------------------------------------------------------------------
	public void remove(String s);

	//-------------------------------------------------------------------
	// Extended Operation 8. sort elements of MyList: bubble_sort
	//-------------------------------------------------------------------
	public void bubble_sort();
	
	//-------------------------------------------------------------------
	// Extended Operation 9. Write a MyList to file: write_file
	//-------------------------------------------------------------------
	public void write_file(String s);
	
	
}
