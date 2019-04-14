
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
		
		m.my_add_element(0, 3);
		m.my_add_element(1, 7);
		m.my_add_element(2, 5); //--> m = [3, 7, 5]
		
		System.out.println(m.my_get_length());
		System.out.println(m.my_get_element(2));
		
		//But what does it happen if I want now to have a myList of Boolean?
		//myList m2 = new myListArrayList();
		//m2.my_add_element(0, true);
		
		
		
	
	}

}
