
public class myMainTest {
	
	//-------------------------------------
	//	MAIN
	//-------------------------------------	
	public static void main(String[] args) {
		int mode = 2;
		myListInt m = null;
		
		switch(mode){
		case 1:
			m = new myListArrayInt();
			break;
		case 2: 
			m = new myListArrayListInt();
			break;
		default: 
			m = new myListLinkedListInt();
			break;
		}
		
		m.my_add_element(0, 3);
		m.my_add_element(1, 7);
		m.my_add_element(2, 5); //--> m = [3, 7, 5]
		
		System.out.println(m.my_get_length());
		System.out.println(m.my_get_element(2));
		
		//But what does it happen if I want now to have a myList of Boolean?
		myListBool m2 = new myListArrayListBool();
		m2.my_add_element(0, true);
		m2.my_add_element(1, false);
		m2.my_add_element(2, true); //--> m = [true, false, true]
		
		System.out.println(m2.my_get_length());
		System.out.println(m2.my_get_element(2));
	
	}

}
