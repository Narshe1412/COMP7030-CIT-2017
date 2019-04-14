import java.util.Scanner;

public class myMain_L10_ADT_Generics_Plus_Exceptions {

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
		myList<Integer> m1 = null;
		myList<Boolean> m2 = null;
		myList<String> m3 = null;
		
		switch(mode){
		case 1: 
			//m = my_create_empty(); //--> We cannot create a new myList using explicitly my_create_empty()
			Integer dummy1 = new Integer(0);
			m1 = new myListArray<Integer>(dummy1.getClass(), 10);  
			Boolean dummy2 = new Boolean(true);
			m2 = new myListArray<Boolean>(dummy2.getClass(), 10);  
			String dummy3 = new String("");
			m3 = new myListArray<String>(dummy3.getClass(), 10); 
			break;
		case 2: 
			//m = my_create_empty(); //--> We cannot create a new myList using explicitly my_create_empty()			
			m1 = new myListArrayList<Integer>(); 
			m2 = new myListArrayList<Boolean>(); 
			m3 = new myListArrayList<String>(); 
			break;
		default: 
			//m = my_create_empty(); //--> We cannot create a new myList using explicitly my_create_empty()			
			m1 = new myListLinkedList<Integer>(); 
			m2 = new myListLinkedList<Boolean>(); 
			m3 = new myListLinkedList<String>(); 
			break;
		}
		
		//-------------------------------------
		//	2. Print the length 
		//-------------------------------------
		System.out.println("Length m1 : " + m1.my_get_length()); 
		m1.my_add_element(0, 3); //--> m1 : [3]
		m1.my_add_element(1, 5);	//--> m1 : [3, 5]	
		m1.my_add_element(1, 7); //--> m1 : [3, 7, 5]
		System.out.println("Length m1 : " + m1.my_get_length()); 
			
		System.out.println("Length m2 : " + m2.my_get_length()); 
		m2.my_add_element(0, true); //--> m2 : [true]
		m2.my_add_element(1, true);	//--> m2 : [true, true]	
		m2.my_add_element(1, false); //--> m2 : [true, false, true]
		System.out.println("Length m2 : " + m2.my_get_length()); 
		
		System.out.println("Length m3 : " + m3.my_get_length()); 
		m3.my_add_element(0, "Hello"); //--> m3 : ["Hello"]
		m3.my_add_element(1, "Hola");	//--> m3 : ["Hello", "Hola"]	
		m3.my_add_element(1, "Bonjour"); //--> m3 : ["Hello", "Bonjour", "Hola"]
		System.out.println("Length m3 : " + m3.my_get_length()); 
		
		//-------------------------------------
		//	3. get_element 
		//-------------------------------------		
		System.out.println(m1.my_get_element(2)); //Case 1: Success

		try{
			System.out.println(m1.my_get_element(8)); //Case 2: Fails	
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}

		try{
			System.out.println(m1.my_get_element(15)); //Case 2: Fails	
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		System.out.println(m2.my_get_element(2)); //Case 1: Success

		try{
			System.out.println(m2.my_get_element(8)); //Case 2: Fails	
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}

		try{
			System.out.println(m2.my_get_element(15)); //Case 2: Fails	
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}

		System.out.println(m3.my_get_element(2)); //Case 1: Success

		try{
			System.out.println(m3.my_get_element(8)); //Case 2: Fails	
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}

		try{
			System.out.println(m3.my_get_element(15)); //Case 2: Fails	
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
				
		//-------------------------------------
		//	4. Add three elements and fail to add a fourth one 
		//-------------------------------------
		m1.my_add_element(2, 9); //Case 1: Success
		m1.my_remove_element(2);

		m1.my_add_element(0, 9); //Case 2: Success
		m1.my_remove_element(0);

		m1.my_add_element(3, 9); //Case 3: Success
		m1.my_remove_element(3);		
		
		try{
			m1.my_add_element(8, 9); //Case 4: Fails		
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		try{
			m1.my_add_element(15, 9); //Case 4: Fails		
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		
		m2.my_add_element(2, false); //Case 1: Success
		m2.my_remove_element(2);

		m2.my_add_element(0, false); //Case 2: Success
		m2.my_remove_element(0);

		m2.my_add_element(3, false); //Case 3: Success
		m2.my_remove_element(3);		
		
		try{
			m2.my_add_element(8, false); //Case 4: Fails		
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}

		try{
			m2.my_add_element(15, false); //Case 4: Fails		
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		

		m3.my_add_element(2, "Ciao"); //Case 1: Success
		m3.my_remove_element(2);
		
		m3.my_add_element(0, "Ciao"); //Case 2: Success
		m3.my_remove_element(0);

		m3.my_add_element(3, "Ciao"); //Case 3: Success
		m3.my_remove_element(3);		

		try{
			m3.my_add_element(8, "Ciao"); //Case 4: Fails		
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}

		try{
			m3.my_add_element(15, "Ciao"); //Case 4: Fails		
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		//-------------------------------------
		//	5. Remove three elements and fail to remove a fourth one 
		//-------------------------------------
		m1.my_remove_element(1); //Case 1: Success
		m1.my_add_element(1, 7); 

		m1.my_remove_element(0); //Case 2: Success
		m1.my_add_element(0, 3); 

		m1.my_remove_element(2);	//Case 3: Success	
		m1.my_add_element(2, 5); 

		try{
			m1.my_remove_element(8); //Case 4: Fails
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}

		try{
			m1.my_remove_element(15); //Case 4: Fails
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}

		
		m2.my_remove_element(1); //Case 1: Success
		m2.my_add_element(1, false); 
		
		m2.my_remove_element(0); //Case 2: Success
		m2.my_add_element(0, true); 

		m2.my_remove_element(2);	//Case 3: Success	
		m2.my_add_element(2, true); 
		
		try{
			m2.my_remove_element(8); //Case 4: Fails
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}

		try{
			m2.my_remove_element(15); //Case 4: Fails
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}

		
		m3.my_remove_element(1); //Case 1: Success
		m3.my_add_element(1, "Bonjour"); 

		m3.my_remove_element(0); //Case 2: Success
		m3.my_add_element(0, "Hello"); 

		m3.my_remove_element(2);	//Case 3: Success	
		m3.my_add_element(2, "Hola"); 
		
		try{
			m3.my_remove_element(8); //Case 4: Fails
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}

		try{
			m3.my_remove_element(15); //Case 4: Fails
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
		
}
