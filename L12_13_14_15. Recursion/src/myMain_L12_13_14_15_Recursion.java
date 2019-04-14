
public class myMain_L12_13_14_15_Recursion {

	//-------------------------------------
	//	EXAMPLE 1 
	//-------------------------------------	

	//-------------------------------------
	//	iterative_sumList
	//-------------------------------------	
	public static int iterative_sumList(myList<Integer> l){
		int x = 0;
		int len = l.my_get_length();
		
		for (int i = len; i > 0; i--)
			x = x + l.my_get_element(i-1);
		
		return x;
	}
	
	//-------------------------------------
	//	recursive_sumList 
	//-------------------------------------	
	public static int recursive_sumList(myList<Integer> l){
		int res;
		
		if (l.my_get_length() == 0)
			res = 0;
		else{
			int index = l.my_get_length()-1;
			
			int value = l.my_get_element(index);
			l.my_remove_element(index);
			int y = recursive_sumList(l);
			res = y + value;
		}
		
		return res;		
	}
	
	//-------------------------------------
	//	recursive_tail_sumList 
	//-------------------------------------	
	public static int recursive_tail_sumList(myList<Integer> l){
		return extra(l, l.my_get_length(), 0);
	}
	
	//-------------------------------------
	//	extra 
	//-------------------------------------	
	public static int extra(myList<Integer> l, int size, int accum){
		if (size == 0)
			return accum;
		else{
			accum = accum + l.my_get_element(size-1);
			size = size - 1;
			return extra(l, size, accum); 
		}
	}

	//-------------------------------------
	//	EXAMPLE 2 
	//-------------------------------------	

	//-------------------------------------
	//	recursive_fibonacci 
	//-------------------------------------		
	public static int recursive_fibonacci(int n){
		int res = 0; 

		switch(n){
		case 0: 
			res = 0;
			break;
		case 1: 
			res = 1;
			break;
		default: 
			res = recursive_fibonacci(n-1) + recursive_fibonacci(n-2);
			break;
		}
		
		return res;
	}
	
	//-------------------------------------
	//	iterative_fibonacci 
	//-------------------------------------		

	public static int iterative_fibonacci(int n){	
		myList<Integer> l = new myListArrayList<Integer>();
		
		for (int i = 0; i <= n; i++){
			if ((i == 0) || (i == 1))
				l.my_add_element(i, i);
			else
				l.my_add_element(i, l.my_get_element(i-1) + l.my_get_element(i-2));
		}
		
		return l.my_get_element(n); 
	}
	
	//-------------------------------------
	//	EXAMPLE 3 
	//-------------------------------------	

	//-------------------------------------
	//	extra_hanoi 
	//-------------------------------------	
	public static void extra_hanoi(int n, 
								   myPair<String, myStack<Integer>> source, 
								   myPair<String, myStack<Integer>> intermediate, 
								   myPair<String, myStack<Integer>> destination, 
							       myQueue<myTuple<Integer, String, String>> movements){
		//1. Base Case
		if (n == 1){
			//1.1. Get the disk to be moved
			int disk = (source.getSecond()).my_peek();
			
			//1.2. Remove it from the source stack
			(source.getSecond()).my_pop();
			
			//1.3. Add it to the destination stack
			(destination.getSecond()).my_push(disk);
			
			//1.4. Create the new movement
			myTuple<Integer, String, String> t = new myTuple<Integer, String, String>(disk, source.getFirst(), destination.getFirst()); 
			
			//1.5. Add the movement to the queue of movements			
			movements.my_enqueue(t);
		}
		//2. Recursive Case
		else{
			//2.1. Move n-1 disks from source to intermediate (using destination as intermediate stack) 
			extra_hanoi(n-1, source, destination, intermediate, movements);
			
			//2.2. Move 1 disks from source to destination (using intermediate as intermediate stack) 
			extra_hanoi(1, source, intermediate, destination, movements);
			
			//2.3. Move n-1 disks from intermediate to destination (using source as intermediate stack) 
			extra_hanoi(n-1, intermediate, source, destination, movements);
		}
	}
	
	//-------------------------------------
	//	hanoi 
	//-------------------------------------	
	public static void hanoi(int n){
		//1. Get the initial status of the puzzle
		myStack<Integer> source = new myStack_as_myList<Integer>(1);
		for (int i = n; i > 0; i--)
			source.my_push(i);
		myPair<String, myStack<Integer>> a = new myPair<String, myStack<Integer>>("A", source); 
		
		myStack<Integer> intermediate = new myStack_as_myList<Integer>(1);
		myPair<String, myStack<Integer>> b = new myPair<String, myStack<Integer>>("B", intermediate); 
		
		myStack<Integer> destination = new myStack_as_myList<Integer>(1);
		myPair<String, myStack<Integer>> c = new myPair<String, myStack<Integer>>("C", destination); 
		
		myQueue<myTuple<Integer, String, String>> movements = new myQueue_as_myList<myTuple<Integer, String, String>>(1);
		
		//2. Solve the puzzle
		extra_hanoi(n, a, b, c, movements);
		
		//3. Show the solution
		int count = 1;
		while (movements.my_is_empty() == false){
			myTuple<Integer, String, String> elem = movements.my_peek();
			System.out.println("Move " + count + " = Disk " + elem.getFirst() + " from " + elem.getSecond() + " to " + elem.getThird());
			movements.my_dequeue();
			count = count + 1;
		}
	}
	
	//-------------------------------------
	//	MAIN method 
	//-------------------------------------	
	public static void main(String[] args) {
		
		//--------- EXAMPLE 1 -----------//		
		myList<Integer> m = new myListArrayList<Integer>();
		m.my_add_element(0, 3);
		m.my_add_element(1, 2);
		m.my_add_element(2, 9);
			
		System.out.println(iterative_sumList(m));
		System.out.println(recursive_tail_sumList(m));
		System.out.println(recursive_sumList(m));
		
		//--------- EXAMPLE 2 -----------//
		System.out.println(recursive_fibonacci(5));
		System.out.println(iterative_fibonacci(5));
					
		//--------- EXAMPLE 3 -----------//
		hanoi(4); 	
		
	}
	
}
