
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
		// 1. The elements of the list can be of any type, the compiler allows it
		//----------------
		System.out.println("\n\n\nInteger");	
		m.my_add_element(0, 3);
		m.my_add_element(1, "7"); //--> MISTAKE
		m.my_add_element(2, 5); //--> m = [3, "7", 5]
		
		System.out.println(m.my_get_length());
		int i1 = (Integer) m.my_get_element(0);
		System.out.println(i1);
		int i2 = (Integer) m.my_get_element(1); //--> THIS COMPILES BUT OBVIOUSLY MAKES THE APPLICATION CRASH!!!
		System.out.println(i2);
		
		//----------------
		// 2. Every element has to be cast. 
		//----------------
		//----------------
		// Pairs of whatever
		//----------------
		System.out.println("\n\n\nPairs of int + boolean");	
		myList m4 = new myListArrayList();
		myPair p1 = new myPair(3, true);
		myPair p2 = new myPair(5, false);
		myPair p3 = new myPair(7, true);	
		m4.my_add_element(0, p1);
		m4.my_add_element(1, p2);
		m4.my_add_element(2, p3); //--> m = [(3,true), (5,false), (7,true)]		

		System.out.println(m4.my_get_length());		
		myPair o1 = m4.my_get_element(2); //--> This does not work, it has to be cast
		//myPair o1 = (myPair) m4.my_get_element(2); //--> This does not work, it has to be cast
		System.out.println(o1.getFirst() + ", " + o1.getSecond());			
		
		

	
	}

}
