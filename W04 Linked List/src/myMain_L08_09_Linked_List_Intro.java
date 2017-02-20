
import java.util.Scanner;

public class myMain_L08_09_Linked_List_Intro {
	
	//-------------------------------------
	//	select_option 
	//-------------------------------------		
	public static int select_option(){
		Scanner sc = new Scanner(System.in);
		int option = 0;
			
		System.out.println("--------------------------------------------------");
		System.out.println("	Select Concrete ADT myList Implementation");
		System.out.println("--------------------------------------------------");
		System.out.println("1. Array");
		System.out.println("2. ArrayList.");
		System.out.println("3. LinkedList.");
		
		boolean selected = false;
		
		while (selected == false){
			System.out.println("Please enter an option");
			try {
				option = sc.nextInt();
				sc.nextLine();
				if ((option >= 1) && (option <= 3))
					selected = true;
				else
					System.out.println("Sorry but the option must be 1..3");
				
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter a valid option");
				sc.next();
			}		
		}
			
		sc.close();
		
		return option;
	}
	
	//-------------------------------------
	//	MAIN method 
	//-------------------------------------	
	public static void main(String[] args) {
		int mode = select_option();
		
		//-------------------------------------
		//	1. We create myList 
		//-------------------------------------
		myList m = null;
		
		switch(mode){
		case 1: 
			//m = my_create_empty(); //--> We cannot create a new myList using explicitly my_create_empty()
			m = new myListArray(); //--> Instead we choose to follow the implementation 1 (i.e., myListArray). 
			System.out.println("m = " + m);
			break;
		case 2: 
			//m = my_create_empty(); //--> We cannot create a new myList using explicitly my_create_empty()			
			m = new myListArrayList(); //--> Instead we choose to follow the implementation 2 (i.e., myListArrayList).	
			break;
		default: 
			//m = my_create_empty(); //--> We cannot create a new myList using explicitly my_create_empty()			
			m = new myListLinkedList(); //--> Instead we choose to follow the implementation 3 (i.e., myListLinkedList).	
			break;
		}
		
		//-------------------------------------
		//	2. Print the length 
		//-------------------------------------
		System.out.println("Length: " + m.my_get_length()); //--> The current length is 0 as myList is created initially empty
		m.my_add_element(0, 3); //--> m : [3]
		m.my_add_element(1, 5);	//--> m : [3, 5]	
		m.my_add_element(1, 7); //--> m : [3, 7, 5]
		m.my_get_length();

		//-------------------------------------
		//	3. get_element 
		//-------------------------------------		
		System.out.println(m.my_get_element(2)); //Case 1: Success

		System.out.println(m.my_get_element(10)); //Case 2: Fails	
				
		//-------------------------------------
		//	4. Add three elements and fail to add a fourth one 
		//-------------------------------------
		m.my_add_element(2, 9); //Case 1: Success
		m.my_remove_element(2);
		
		m.my_add_element(0, 9); //Case 2: Success
		m.my_remove_element(0);
		
		m.my_add_element(3, 9); //Case 3: Success
		m.my_remove_element(3);		
		
		m.my_add_element(10, 9); //Case 4: Fails		
		
		//-------------------------------------
		//	5. Remove three elements and fail to remove a fourth one 
		//-------------------------------------
		m.my_remove_element(1); //Case 1: Success
		m.my_add_element(1, 7); 
		
		m.my_remove_element(0); //Case 2: Success
		m.my_add_element(0, 3); 
		
		m.my_remove_element(2);	//Case 3: Success	
		m.my_add_element(2, 5); 
		
		m.my_remove_element(10); //Case 4: Fails
					
	}
		
}
