 
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

public class myListArrayList implements myList {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private ArrayList<myPlayer> items; //See the use of a dynamic data structure: ArrayList

	//-------------------------------------------------------------------
	// Basic Operation 1. --> Create an empty myList: my_create_empty
	//-------------------------------------------------------------------
	//public myList my_create_empty();

	public myListArrayList(){
		this.items = new ArrayList<myPlayer>();
	}

	//-------------------------------------------------------------------
	// Basic Operation 2. --> Get number of elements in MyList: my_get_length
	//-------------------------------------------------------------------	
	public int my_get_length(){
		return this.items.size();
	}
	
	//-------------------------------------------------------------------
	// Basic Operation 3. --> Get element at of MyList at a concrete position: my_get_element
	//-------------------------------------------------------------------
	public myPlayer my_get_element(int index){
		myPlayer value = null;
		
		try{			
			value = this.items.get(index);		
		}
		catch (Exception e){
			System.out.println("Sorry, not such an index to access");
		}
		
		return value;	
	}
	
	//-------------------------------------------------------------------
	// Basic Operation 4. --> Add element to MyList at a concrete position: my_add_element 
	//-------------------------------------------------------------------
	public void my_add_element(int index, myPlayer value){
		try{
			this.items.add(index, value);		
		}
		catch (Exception e){
			System.out.println("Sorry, not such an index to add");
		}		
	}
	
	//-------------------------------------------------------------------
	// Basic Operation 5. --> Remove element of MyList at a concrete position: my_remove_element 
	//-------------------------------------------------------------------	
	public void my_remove_element(int index){
		try{			
			this.items.remove(index);		
		}
		catch (Exception e){
			System.out.println("Sorry, not such an index to remove");
		}		
	}

	//-------------------------------------------------------------------
	// Extended Operation 1. --> Load a MyList from file: load_file
	//-------------------------------------------------------------------
	public void load_file(String s){				
		
		try {
			//1. We create the file variable
			File my_file = new File(s);
			Scanner sc = new Scanner(my_file);

			//2. We empty the list
			int size = this.my_get_length();
			for (int i = 0; i < size; i++)
				this.my_remove_element(0);
						
			//3. We fill MyList with the content of the file
			int count = 0;
			while (sc.hasNext()){
				myPlayer player = new myPlayer(sc.next(), sc.nextInt());
				this.my_add_element(count, player);
				count = count + 1;
			}
			
			//4. We close the scanner
			sc.close();

			System.out.println("Load Operation Completed");
		} 
		catch (Exception e) {
			System.out.println("Sorry but there is not such file");
		}	
	}

	//-------------------------------------------------------------------
	// Extended Operation 2. --> Display MyFile content: show_elements
	//-------------------------------------------------------------------
	public void show_elements(){

	}
	
	//-------------------------------------------------------------------
	// Extended Operation 3. --> Check if element is in MyList: find_element
	//-------------------------------------------------------------------
	public int find_element(String s){
		int i = 0;				
		return i;
	}

	//-------------------------------------------------------------------
	// Extended Operation 4. --> Show info of element in MyList: show_info
	//-------------------------------------------------------------------
	public void show_info(String s){

	}
	
	//-------------------------------------------------------------------
	// Extended Operation 5. --> Add new element to MyList: add_by_keyboard
	//-------------------------------------------------------------------
	public void add(String s, int i){

	}

	//-------------------------------------------------------------------
	// Extended Operation 6. --> Update element of MyList: update
	//-------------------------------------------------------------------
	public void update(String s, int g){

	}
	
	//-------------------------------------------------------------------
	// Extended Operation 7. --> Remove element of MyList: remove_element
	//-------------------------------------------------------------------
	public void remove(String s){

	}
	
	//-------------------------------------------------------------------
	// Extended Operation 8. --> sort elements of MyList: bubble_sort
	//-------------------------------------------------------------------
	public void bubble_sort(){

	}
	
	//-------------------------------------------------------------------
	// Extended Operation 9. --> Write a MyList to file: write_file
	//-------------------------------------------------------------------
	public void write_file(String s){

	}
		
}

