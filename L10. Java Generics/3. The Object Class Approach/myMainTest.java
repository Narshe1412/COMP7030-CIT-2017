
public class myMainTest {
	
	//-------------------------------------
	//	MAIN
	//-------------------------------------	
	public static void main(String[] args) {
		int mode = 2;
		myList m = null;
		
		switch(mode){
		case 1:
			m = new myListArray();
			break;
		case 2: 
			m = new myListArrayList();
			break;
		default: 
			m = new myListLinkedList();
			break;
		}

		//----------------
		// integer
		//----------------
		System.out.println("\n\n\nInteger");	
		m.my_add_element(0, 3);
		m.my_add_element(1, 7);
		m.my_add_element(2, 5); //--> m = [3, 7, 5]
		
		System.out.println(m.my_get_length());
		System.out.println(m.my_get_element(2).toString());
		
		//----------------
		// boolean
		//----------------
		System.out.println("\n\n\nBoolean");	
		myList m2 = new myListArrayList();
		m2.my_add_element(0, true);
		m2.my_add_element(1, false);
		m2.my_add_element(2, true); //--> m = [true, false, true]		
		
		System.out.println(m2.my_get_length());
		System.out.println(m2.my_get_element(2).toString());
	
		//----------------
		// String
		//----------------
		System.out.println("\n\n\nString");	
		myList m3 = new myListArrayList();
		m3.my_add_element(0, "Hello");
		m3.my_add_element(1, "Bonjour");
		m3.my_add_element(2, "Hola"); //--> m = ["Hello", "Bonjour", "Hola"]		
		
		System.out.println(m3.my_get_length());
		System.out.println(m3.my_get_element(2).toString());
			
	}

}
