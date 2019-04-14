

public class myListArrayInt implements myListInt {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private int items[]; 
	private int num_items;
	private final int NUM_MAX = 80;

	//-------------------------------------------------------------------
	// Basic Operation --> Create an empty myList: my_create_empty
	//-------------------------------------------------------------------
	//public myList my_create_empty(){}
	
	public myListArrayInt(){
		this.items = new int[NUM_MAX];
		this.num_items = 0;
	}
		
	//-------------------------------------------------------------------
	// Basic Operation --> Get number of integers in myList: my_get_length
	//-------------------------------------------------------------------	
	public int my_get_length(){
		return this.num_items;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get integer of myList at a concrete index: my_get_element
	//-------------------------------------------------------------------
	public int my_get_element(int index){
		int value = 0;	
		try{
			if (index < num_items)
				value = this.items[index];	
			else
				System.out.println("Sorry, not such an index to access");				
		}
		catch (Exception e){
			System.out.println("Sorry, not such an index to access");
		}
		return value;	
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Add integer to myList at a concrete index: my_add_element 
	//-------------------------------------------------------------------
	public void my_add_element(int index, int value){
		try{
			if (index <= num_items){
				for (int i = (this.num_items - 1); i >= index; i--)
					this.items[i+1] = this.items[i];
				this.items[index] = value;	
				this.num_items = this.num_items + 1;
			}
			else
				System.out.println("Sorry, not such an index to add");							
		}
		catch (Exception e){
			System.out.println("Sorry, not such an index to add");
		}		
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Remove index of myList: my_remove_element 
	//-------------------------------------------------------------------	
	public void my_remove_element(int index){
		try{
			if (index < num_items){
				for (int i = index; i < (this.num_items - 1); i++)
					this.items[i] = this.items[i+1];
				this.num_items = this.num_items - 1;
			}
			else
				System.out.println("Sorry, not such an index to remove");				
		}
		catch (Exception e){
			System.out.println("Sorry, not such an index to remove");
		}		
	}	
	
}

