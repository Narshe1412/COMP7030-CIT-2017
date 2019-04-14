
public interface myComparableList<T extends Comparable<? super T>> extends myList<T> {

	//-------------------------------------------------------------------
	// Basic Operation --> Create a new empty myComparableList: create_empty
	//-------------------------------------------------------------------
	//public myComparableList create_empty(); --> Java does not support constructors in interfaces	
		
	//-------------------------------------------------------------------
	// New Operation --> Display elements of myComparableList: my_display_elements 
	//-------------------------------------------------------------------			
	public void my_display_elements();
	
	//-------------------------------------------------------------------
	// New Operation --> Sort myComparableList by bubbleSort: my_bubbleSort 
	//-------------------------------------------------------------------		
	public void my_bubbleSort();	

	//-------------------------------------------------------------------
	// New Operation --> Sort myComparableList by selectionSort: my_selectionSort 
	//-------------------------------------------------------------------		
	public void my_selectionSort();		

	//-------------------------------------------------------------------
	// New Operation --> Sort myComparableList by selectionSort: my_insertionSort 
	//-------------------------------------------------------------------		
	public void my_insertionSort();		
	
	
}
