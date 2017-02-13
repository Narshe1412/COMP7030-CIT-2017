
public class myMain_L06_ADT_Intro_myList {

	//-------------------------------------
	//	MAIN method 
	//-------------------------------------	
	public static void main(String[] args) {
		boolean mode = false;
		
		//-------------------------------------
		//	1. We create myList 
		//-------------------------------------
		myList m;
		if (mode == true){
			//m = my_create_empty(); //--> We cannot create a new myList using explicitly my_create_empty()
			m = new myListArray(); //--> Instead we choose to follow the implementation 1 (i.e., myListArray). 
		}
		else{
			//m = my_create_empty(); //--> We cannot create a new myList using explicitly my_create_empty()			
			m = new myListArrayList(); //--> Instead we choose to follow the implementation 2 (i.e., myListArrayList).	
		}

		//-------------------------------------
		//	2. Print the length 
		//-------------------------------------
		System.out.println("Length: " + m.my_get_length()); //--> The current length is 0 as myList is created initially empty
				
		//-------------------------------------
		//	3. Add three elements and fail to add a fourth one 
		//-------------------------------------
		m.my_add_element(0, 3); //--> m : [3]
		m.my_add_element(1, 4);	//--> m : [3, 4]	
		m.my_add_element(1, 5); //--> m : [3, 5, 4]
		m.my_add_element(10, 6); //--> Fails, as index is out of bounds
		
		//-------------------------------------
		//	4. Get one element and fail to get another one  
		//-------------------------------------	
		System.out.println("Integer at position 0 = " + m.my_get_element(0)); //--> Returns 3
		System.out.println("Integer at position 10 = " + m.my_get_element(10)); //--> Fails, as index is out of bounds
		
		//-------------------------------------
		//	5. Remove one element and fail to get another one
		//-------------------------------------			
		m.my_remove_element(2); //--> m : [3, 4]
		m.my_remove_element(10); //--> Fails, as index is out of bounds
				
	}
		
}
