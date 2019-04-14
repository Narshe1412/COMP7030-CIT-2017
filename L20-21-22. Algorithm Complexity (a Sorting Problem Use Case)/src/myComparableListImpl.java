
public class myComparableListImpl<T extends Comparable<? super T>> implements myComparableList<T> {
	
	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	myList<T> myInternalList;
	
	//-------------------------------------------------------------------
	// Basic Operation --> Create a new empty myListExtended: create_empty
	//-------------------------------------------------------------------
	//public myListExtended create_empty(); --> Java does not support constructors in interfaces	
	
	public myComparableListImpl(int mode){
		if (mode == 1)
			this.myInternalList = new myListArrayList<T>();
		else
			this.myInternalList = new myListLinkedList<T>();
	}

	public myComparableListImpl(Class<?> t, int size){
		this.myInternalList = new myListArray<T>(t, size);  
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get number of elements in MyList: my_get_length
	//-------------------------------------------------------------------	
	public int my_get_length(){
		return this.myInternalList.my_get_length();
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get element at of MyList at a concrete position: my_get_element
	//-------------------------------------------------------------------
	public T my_get_element(int index) throws myException{
		try{
			return myInternalList.my_get_element(index);
		}	
		catch(myException e){
			throw new myException(e.getMessage());
		}
	}
		
	//-------------------------------------------------------------------
	// Basic Operation --> Add element to MyList at a concrete position: my_add_element 
	//-------------------------------------------------------------------
	public void my_add_element(int index, T element) throws myException{
		try{
			myInternalList.my_add_element(index, element);
		}	
		catch(myException e){
			throw new myException(e.getMessage());
		}		
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Remove element of MyList at a concrete position: my_remove_element 
	//-------------------------------------------------------------------	
	public void my_remove_element(int index) throws myException{
		try{
			myInternalList.my_remove_element(index);
		}	
		catch(myException e){
			throw new myException(e.getMessage());
		}			
	}

	//-------------------------------------------------------------------
	// New Operation --> Display elements of myListExtended: my_display_elements 
	//-------------------------------------------------------------------			
	public void my_display_elements(){
		int k = myInternalList.my_get_length();
		System.out.println("Content: ");
		for (int i = 0; i < k; i++)
			System.out.println(myInternalList.my_get_element(i) + " ");
		System.out.println();		
	}	
	
	//-------------------------------------------------------------------
	// New Operation --> Swap two elements: my_swap 
	//-------------------------------------------------------------------		
	public void my_swap(int index1, int index2){
		T tmp1 = my_get_element(index1);
		T tmp2 = my_get_element(index2);		

		myInternalList.my_remove_element(index1);
		myInternalList.my_add_element(index1, tmp2);		

		myInternalList.my_remove_element(index2);
		myInternalList.my_add_element(index2, tmp1);	
	}
	
	//-------------------------------------------------------------------
	// New Operation --> Sort myComparableList by bubbleSort: my_bubbleSort 
	//-------------------------------------------------------------------		
	public void my_bubbleSort(){
		//1. Put the frontier splitting the list into sorted and unsorted at the end of the list
		int k = this.my_get_length() - 1;
		
		//2. While the unsorted list contains more than one element
		while(k > 0){		
			//2.1. Explore all unsorted elements, to bring the maximum to the very last position			
			int j = 0;
			while (j < k){		
				//2.1.1. We compare them one to one, and swap them if needed
				if (this.my_get_element(j).compareTo(this.my_get_element(j + 1)) > 0){
					my_swap(j, j+1);
				}
				//2.2.2. We increase j for trying the next candidate
				j++;
			}
			//2.2. We decrease the frontier k, as a new element has been sorted
			k--;
		}
	}
	
	//-------------------------------------------------------------------
	// New Operation --> Sort myComparableList by selectionSort: my_selectionSort 
	//-------------------------------------------------------------------		
	public void my_selectionSort(){
		//1. Put the frontier splitting the list into sorted and unsorted at the end of the list
		int k = this.my_get_length() - 1;
		
		//2. While the unsorted list contains more than one element
		while(k > 0){				
			//2.1. We pick one index of an unsorted element as the maximum one found so far.
			int maxIndex = k; 
			//2.2. We explore all other unsorted elements, to challenge the current max. 
			int j = 0;
			while (j < k){
				//2.2.1. If it beats it, then it replaces as current max.
				if (this.my_get_element(j).compareTo(this.my_get_element(maxIndex)) > 0){
					maxIndex = j;
				}
				//2.2.2. We increase j for trying the next candidate
				j++;
			}
			
			//2.3. We swap if needed  
			if (maxIndex != k){
				my_swap(maxIndex, k);
			}
			//2.4. We decrease the frontier k, as a new element has been sorted
			k--;
		}	
	}
	
	//-------------------------------------------------------------------
	// New Operation --> Sort myComparableList by selectionSort: my_insertionSort 
	//-------------------------------------------------------------------		
	public void my_insertionSort(){
		int len = this.my_get_length();
		//1. Put the frontier splitting the list into sorted and unsorted at the end of the list minus one element
		//	(otherwise the first iteration will be a dummy one).
		int k = len - 1;
		
		//2. While the unsorted list contains more than one element
		while(k > 0){				
			//2.1. We collect the last element of unsorted sub-list
			T elem = this.my_get_element(k-1);
			
			//2.2. We remove it from unsorted sub-list, also shifting the frontier
			this.my_remove_element(k-1);
			k--;
			
			//2.3. We fit elem among sorted sub-list
			int j = k;
			while (j < len){
				//2.2.1. If elem beats j...
				if ((j == len - 1) || (elem.compareTo(this.my_get_element(j)) <= 0)){
					//2.2.1.1. We add elem just before it
					this.my_add_element(j, elem);
					//2.2.1.2. Also, we set j to len, so as to finish the while loop
					j = len;
				}
				//2.2.2. If elem does not beat j, we increase j for trying the next candidate
				else
					j++;
			}				
		}	
	}

}
