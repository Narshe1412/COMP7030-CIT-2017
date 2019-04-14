
public class myListLinkedList implements myList {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private myNode head; 

	//-------------------------------------------------------------------
	// Basic Operation --> Create an empty myList: my_create_empty
	//-------------------------------------------------------------------
	//public myList my_create_empty(){}

	public myListLinkedList(){
		this.head = null;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Get number of integers in myList: my_get_length
	//-------------------------------------------------------------------	
	public int my_get_length(){
		myNode current = this.head;
		int count = 0; 
		
		while (current != null){
			current = current.get_my_next();
			count = count + 1;
		}
		
		return count;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get integer of myList at a concrete index: my_get_element
	//-------------------------------------------------------------------
	public int my_get_element(int index){
		int element = 0;
		
		//1. We declare the reference nodes
		myNode current = this.head;
		int count = 0; 
		
		//2. We look for the node to be consulted  
		while ((count < index) && (current != null)){
			current = current.get_my_next();
			count = count + 1;
		}
		
		//3.a. If there is such a node we retrieve its info
		if (current != null)
			element = current.get_my_info();
		//3.b. Otherwise we print an error message
		else{
			System.out.println("Sorry, not such an index to access");
			element = Integer.MIN_VALUE;
		}
		
		return element;	
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Add integer to myList at a concrete index: my_add_element 
	//-------------------------------------------------------------------
	public void my_add_element(int index, int element){
		//1. We declare the reference nodes
		myNode current_node = head;
		myNode previous_node = null;
		int count = 0;
			
		//2. We look for the place the node should be inserted  
		while ((count < index) && (current_node != null)){
			previous_node = current_node;
			current_node = current_node.get_my_next();
			count = count + 1;
		}
			
		//3.a. If there such a position where to insert the node
		if (count == index){
			//3.a.1. We create the node 
			myNode new_node = new myNode(element, null);

			//3.a.2. We adjust its previous node next pointer
			if (previous_node == null)
				this.head = new_node;
			else
				previous_node.set_my_next(new_node);
			
			//3.a.3. We set the next node pointer
			new_node.set_my_next(current_node);
		}
		//3.b. If not we just print the message
		else
			System.out.println("Sorry, not such an index to add");			

	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Remove index of myList: my_remove_element 
	//-------------------------------------------------------------------	
	public void my_remove_element(int index){
		//1. We declare the reference nodes
		myNode current_node = head;
		myNode previous_node = null;
		int count = 0;
			
		//2. We look for the node to be removed  
		while ((count < index) && (current_node != null)){
			previous_node = current_node;
			current_node = current_node.get_my_next();
			count = count + 1;
		}

		//3.a. If there such a node to be removed
		if (count == index){
			//3.a.1. We adjust its previous node next pointer
			if (previous_node == null)
				this.head = current_node.get_my_next();
			else
				previous_node.set_my_next(current_node.get_my_next());
		}
		//3.b. If not we just print the message
		else
			System.out.println("Sorry, not such an index to remove");			
	}
	
	
}
