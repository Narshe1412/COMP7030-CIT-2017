import java.util.Scanner;

public class myMain_L20_21_22_Sorting_Algorithms {
		
	//--------------------------------------------------
	// are_equal
	//--------------------------------------------------	
	public static boolean are_equal(myComparableList<Integer> l1, myComparableList<Integer> l2){
		// 1. We initially make res = true (so far we have compared nothing, so the property is true
		boolean res = true;
		
		// 2. We get the size of both lists
		int size1 = l1.my_get_length();
		int size2 = l2.my_get_length();
		
		// 3. If their sizes are different, then they cannot be equal
		if (size1 != size2)
			res = false;
		
		// 4. If their sizes are the same, we traverse the elements one by one to see if they are equal
		else{
			int i = 0; 
			
			while ((i < size1) && (res == true)){
				// 4.1. As soon as the two lists are not equal for element i, we can conclude the lists are not equal.
				if (l1.my_get_element(i).compareTo(l2.my_get_element(i)) != 0)
					res = false;
				// 4.2. If they are equal for element i, we continue exploring for the next element
				else
					i = i + 1;
			}			
			
		}
		
		// 5. If we have not set res to false, is because we have traversed the entire lists and conclude they are equal. 
		return res;
	}
	
	//--------------------------------------------------
	// count_apperances
	//--------------------------------------------------	
	public static myComparableList<Integer> count_appearances(myComparableList<Integer> l){
		// 1. We create our appearances list, initially with all elements set to 0
		myComparableList<Integer> res = new myComparableListImpl<Integer>(1);
		for (int i = 0; i < 10; i++)
			res.my_add_element(0, 0);

		// 2. We traverse l counting how many elements are there of each type
		int k = l.my_get_length();
		for (int i = 0; i < k; i++){
			int value = l.my_get_element(i);
			Integer elem = res.my_get_element(value);
			res.my_remove_element(value);
			res.my_add_element(value, elem + 1);
		}	

		// 3. We return res
		return res;
	}	
	
	//--------------------------------------------------
	// anagrams_n2
	//--------------------------------------------------
	public static boolean anagrams_n2(myComparableList<Integer> l1, myComparableList<Integer> l2){		
		boolean res;
		
		// 1. We sort the two lists
		l1.my_bubbleSort();
		l2.my_bubbleSort();
		
		// 2. We compare whether they are equal or not
		res = are_equal(l1, l2);
		
		// 3. We return the result
		return res;	
	}
	
	//--------------------------------------------------
	// anagrams_n
	//--------------------------------------------------
	public static boolean anagrams_n(myComparableList<Integer> l1, myComparableList<Integer> l2){		
		boolean res;
		
		// 1. We count their appearances
		myComparableList<Integer> a1 = count_appearances(l1);
		myComparableList<Integer> a2 = count_appearances(l2);
		
		// 2. We compare whether they are equal or not
		res = are_equal(a1, a2);
		
		// 3. We return the result
		return res;	
	}
		
	//-------------------------------------
	//	sorting
	//-------------------------------------	
	public static void sorting(int size, boolean sorted_list, int algorithm){	
		//1. We declare the list we are going to use		
		myComparableList<Integer> list1 = new myComparableListImpl<Integer>(1);			
		if (sorted_list == true)
			for (int i = size-1; i >= 0; i--)
				list1.my_add_element(0, i);		
		else
			for (int i = 0; i < size; i++)
				list1.my_add_element(0, i);		
	
		//2. We start measuring the time
		long startTime = System.currentTimeMillis();		
		
		//4. Depending on the algorithm selected we run bubble sort, selection sort or insertion sort.
		switch (algorithm){
		case 0: 
			list1.my_bubbleSort();
			break;
		case 1: 
			list1.my_selectionSort();
			break;
		case 2: 
			list1.my_insertionSort();
			break;
		}
	
		//5. After running the algorithm we measure the time again and print it.		
		long time = System.currentTimeMillis() - startTime;			
		System.out.println("Solved in "+(time/(1000 * 1.0))+" seconds. ");				
	}

	//-------------------------------------
	//	anagrams 
	//-------------------------------------	
	public static void anagrams(int size, boolean anagrams, int algorithm){
		//1. We declare the boolean variable hosting the result on whether the two lists are anagrams or not.
		boolean res;
		//2. We declare the two lists we are going to use
		
		//2.1. list1 = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, ...]
		myComparableList<Integer> list1 = new myComparableListImpl<Integer>(1);
		for (int i = size-1; i >= 0; i--)
			list1.my_add_element(0, i % 10);

		//2.2. list2 = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, ...]		
		myComparableList<Integer> list2 = new myComparableListImpl<Integer>(1);	
		for (int i = size-1; i >= 0; i--)
			list1.my_add_element(0, i % 10);
				
		//3. If we receive anagrams = true we just maintain the lists as they are right now (as they are equal and thus for sure anagrams).
		// If we receive anagrams = false we make them not to be anagrams by replacing the first element of list2 (from being a 0 to be a 1).
		if (anagrams == false){
			list2.my_remove_element(0);
			list2.my_add_element(0, 1);
		}
		
		//4. We start measuring the time
		long startTime = System.currentTimeMillis();		
		
		//5. Depending on the algorithm selected we run anagrams_n2 (based on bubble sort) or anagrams_n (based on count appearances).
		if (algorithm == 0)
			res = anagrams_n(list1, list2); 
		else
			res = anagrams_n2(list1, list2); 		
		
		//6. After running the algorithm we measure the time again and print it.
		long time = System.currentTimeMillis() - startTime;		
		System.out.println("Are anagrams = " + res + ". Solved in "+(time/(1000 * 1.0))+" seconds. ");			
	}
	
	//-------------------------------------
	//	select_problem 
	//-------------------------------------		
	public static int select_problem(Scanner sc){
		int option = 0;
			
		System.out.println("--------------------------------------------------");
		System.out.println("	Select Problem you want to run");
		System.out.println("--------------------------------------------------");
		System.out.println("1. Sorting Algorithms");
		System.out.println("2. Anagrams");
		
		boolean selected = false;
		
		while (selected == false){
			try {
				option = sc.nextInt();
				sc.nextLine();
				if ((option >= 1) && (option <= 2))
					selected = true;
				else
					System.out.println("Sorry but the option must be 1..2");
				
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter a valid option");
				sc.next();
			}		
		}
					
		return option;
	}

	//-------------------------------------
	//	select_size 
	//-------------------------------------		
	public static int select_size(Scanner sc){
		int option = 0;
					
		boolean selected = false;
		
		while (selected == false){
			System.out.println("Please enter a size for the lists");
			try {
				option = sc.nextInt();
				sc.nextLine();
				if ((option >= 0) && (option <= 100000))
					selected = true;
				else
					System.out.println("Sorry but the size must be in the range [0..100000]");
				
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter a valid option");
				sc.next();
			}		
		}
			
		return option;
	}
	
	//-------------------------------------
	//	select_mode 
	//-------------------------------------		
	public static boolean select_mode(Scanner sc, int problem){
		boolean res;
		int option = 0;
			
		System.out.println("Please enter the mode you want to run");
		if (problem == 1){
			System.out.println("Option 1 --> Lists are sorted");
			System.out.println("Option 2 --> Lists are sorted in reverse order");
		}
		else{
			System.out.println("Option 1 --> Lists are anagrams");
			System.out.println("Option 2 --> Lists are not anagrams");
		}
		
		boolean selected = false;
		
		while (selected == false){
			try {
				option = sc.nextInt();
				sc.nextLine();
				if ((option >= 1) && (option <= 2))
					selected = true;
				else
					System.out.println("Sorry but the option must be 1..2");
				
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter a valid option");
				sc.next();
			}		
		}
			
		if (option == 1)
			res = true;
		else
			res = false;
		
		return res;
	}

	//-------------------------------------
	//	select_algortihm 
	//-------------------------------------		
	public static int select_algortihm(Scanner sc, int problem){
		int option = 0;
			
		System.out.println("Please enter the algorithm you want to use");
		if (problem == 1){
			System.out.println("Option 0 --> Bubble Sort");
			System.out.println("Option 1 --> Selection Sort");
			System.out.println("Option 2 --> Insertion Sort");
		}
		else{
			System.out.println("Option 0 --> Count Appearances");
			System.out.println("Option 1 --> Bubble Sort Based");
		}
		
		boolean selected = false;
		
		while (selected == false){
			try {
				option = sc.nextInt();
				sc.nextLine();
				if ((option >= 0) && (option <= 2))
					selected = true;
				else
					System.out.println("Sorry but the option must be 0..2");
				
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter a valid option");
				sc.next();
			}		
		}
					
		return option;
	}

	//-------------------------------------
	//	trigger_experiment 
	//-------------------------------------		
	public static void trigger_experiment(){
		//1. We select the problem we want to solve and its parameters
		Scanner sc = new Scanner(System.in);				

		/*
		int problem = select_problem(sc);
		int size = select_size(sc);
		boolean mode = select_mode(sc, problem);
		int algorithm = select_algortihm(sc, problem);  
		*/
		
		int problem = 1;
		
		int size = 50000;
		boolean mode = false;
		
		int algorithm = 0;  
		
		sc.close();
		
		//2. Depending on the problem, we trigger the method associated to it
		if (problem == 1)
			sorting(size, mode, algorithm);
		else
			anagrams(size, mode, algorithm);
	}
	
	//-------------------------------------
	//	MAIN 
	//-------------------------------------		
	public static void main(String[] args) {
		trigger_experiment();
	}
	
}
