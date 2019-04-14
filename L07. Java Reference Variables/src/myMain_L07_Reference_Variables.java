import java.util.Scanner;

public class myMain_L07_Reference_Variables {

	//-------------------------------------------------------------------
	// 0. Static class variable sc to read from user
	//-------------------------------------------------------------------	
	static Scanner sc = new Scanner(System.in);
		
	//-------------------------------------
	//
	//	EXAMPLE 1
	//
	//-------------------------------------	
	public static void example1(){
		//1. Create 3 variables
		int i;
		boolean b;
		myObject j;
		
		//2. Assign the 3 variables
		i = 3;
		b = true;
		j = new myObject(7);
		
		//3. Print the variable values
		System.out.println(i);
		System.out.println(b);
		System.out.println(j); //--> j Prints a Memory address! The address of myObject previously created. 
		
	}
	
	//-------------------------------------
	//
	//	EXAMPLE 2
	//
	//-------------------------------------	
	public static void example2(){
		//1. We can initialise reference variables with the special address 'null'.
		System.out.println("------------ 1 -------------");
		myObject j = null;	//--> It is a way of telling the Java compiler: "Hey, I'm declaring this reference variable. However, as I still don't know where is it going to point, I just make it to point to null by the moment"
		System.out.println(j);
		
		//2. When we create the object, the Reference variable points to it.
		System.out.println("------------ 2 -------------");
		j = new myObject(7);
		System.out.println(j); //--> Now j does not print to 'null', but to the concrete heap address where the new myObject has been created.
		
		//3. We cannot access to myObject explicitly. 
		//   Instead, we need to access to it implicitly via the Reference Variable pointing to it.
		System.out.println("------------ 3 -------------");
		System.out.println(j.get_value()); //--> We access to myObject operations via j. Here we use j to access to an observer operation. 
		j.set_value(12); 	 			   //--> Here we use j to access to a mutable operation.	
				
		//4. If we loose the reference variable, we can no longer access to myObject. 
		System.out.println("------------ 4 -------------");
		j = null;	
		System.out.println(j);
		//You see, how do I access to myObject now?
		//myObject?? Who is myObject?
		//Indeed, as myObject is no longer accessible, the Java Garbage Collector removes it. 
		//The Java Garbage Collector acts on the heap:
		//For each Object placed there, it checks if it is still accesible by the stack: "Hey, Object, are you still accessible? Are you referenced (directly or by transitivity) by any variable alive in the stack?"																					
			//If the answer is 'yes', then perfect. Object I allow you to keep staying in the heap.  
			//If the answer is 'no', then Object, I'm sorry but I have to remove you from the heap, as you are occupying memory and nobody can access to you.   
	}
	
	//-------------------------------------
	//
	//	EXAMPLE 3
	//
	//-------------------------------------	
	public static void example3(){
		int i = 3;

		System.out.println("example3: Value Before example3_function1 = " + i);
		example3_function1(i);			
		System.out.println("example3: Value After example3_function1 = " + i);
	}

	//-------------------------------------
	//	example3_function1
	//-------------------------------------
	public static void example3_function1(int n){
		System.out.println("example3_function1: Value At Start = " + n);

		//You see, example3 used i as a parameter, but in this function the parameter is called n. 
		//Java uses "Value parameter passing" --> The argument is copied.
	
		//Also, you see, we can define one variable called 'i' here (let's call it example3_function1::i). 
		//This variable is different from example3::'i' of example3. 
		int i = 4;
		
		//We can modify 'n' here. But, as 'n' is a copy of example3::'i', this latter is not affected. 
		n = 5;	
		System.out.println("example3_function1: Value Before example3_function2 = " + n);
	
		example3_function2(n);
		
		System.out.println("example3_function1: Value After example3_function2 = " + n);
	}
	
	
	//-------------------------------------
	//	example3_function2
	//-------------------------------------
	public static void example3_function2(int n2){
		System.out.println("example3_function2: Value At Start = " + n2);

		n2 = 9;
		
		System.out.println("example3_function2: Value At End = " + n2);
	}
	
	//-------------------------------------
	//
	//	EXAMPLE 4
	//
	//-------------------------------------	
	public static void example4(){
		myObject i = null;
		i = new myObject(3);
		System.out.println("example4 Reference Variable Pointed Address = " + i); //--> Address pointed by i
		
		System.out.println("example4: Value Before example4_function1 = " + i.get_value());
		example4_function1(i);			
		System.out.println("example4: Value After example3_function1 = " + i.get_value());
	}

	//-------------------------------------
	//	example4_function1
	//-------------------------------------
	public static void example4_function1(myObject n){		
		//You see, example4 used i as a parameter, but in this function the parameter is called n. 
		//Java uses "Value parameter passing" --> The argument is copied.
		//However, here n is a reference variable. So, yes, 'n' is a copy of 'i', they are DIFFERENT variables. But BOTH POINT to the SAME Object in the heap!
		System.out.println("example4_function1 Reference Variable Pointed Address = " + n); //--> Address pointed by n
		System.out.println("example4_function1: Value At Start = " + n.get_value());
			
		//We can modify myOjbect via its reference variable 'n'. 
		//As example4_function1::'n' and example4::i point to the same myObject, if we modify it from 'n' will see myObject it points to modified as well!  
		n.set_value(5);	
		System.out.println("example4_function1: Value At Finish = " + n.get_value());
	}
			
	//-------------------------------------
	//
	//	EXAMPLE 5
	//
	//-------------------------------------	
	public static void example5(){
		//1. We create one reference variable
		myObject o1 = null;
		o1 = new myObject(3);
				
		//2. We create another one. As we see, both point to the same myObject.
		System.out.println("------------ 1 -------------");
		myObject o2 = o1;
		System.out.println("Do o1 and o2 reference the same object? ");  
		System.out.println(o1 == o2);		
		System.out.println("Do the objects referenced by o1 and o2 contain the same integer? ");  
		System.out.println(o1.get_value() == o2.get_value());  
	
		//3. Let's suppose now we create a new object and make o2 point to it. 
		System.out.println("------------ 2 -------------");
		o2 = new myObject(7);
		System.out.println("Do o1 and o2 reference the same object?");  
		System.out.println(o1 == o2);		
		System.out.println("Do the objects referenced by o1 and o2 contain the same integer?");  
		System.out.println(o1.get_value() == o2.get_value());  

		//3. Let's suppose now we create a new object (with same value as the first we created) and make o2 point to it. 
		System.out.println("------------ 2 -------------");
		o2 = new myObject(3); //Please remember, at this moment the object created before is removed by the Java Garbage Collector.
		System.out.println("Do o1 and o2 reference the same object?");  
		System.out.println(o1 == o2);		
		System.out.println("Do the objects referenced by o1 and o2 contain the same integer?");  
		System.out.println(o1.get_value() == o2.get_value());  		
	}

	
		
	public static int select_option(){
		int option = 0;
			
		System.out.println("------------------------------------");
		System.out.println("			    MENU				");
		System.out.println("------------------------------------");
		System.out.println("1. example1: Normal Variables vs. Reference Variables.");
		System.out.println("2. example2: Reference Variable Controls the Variable referenced.");
		System.out.println("3. example3: Normal Variables Parameter Passing.");
		System.out.println("4. example4: Reference Variables Parameter Passing.");
		System.out.println("5. example5: Assigning Reference Variables.");
		System.out.println("0. Exit");
		
		boolean selected = false;
		
		while (selected == false){
			System.out.println("Please enter an option");
			try {
				option = sc.nextInt();
				sc.nextLine();
				if ((option >= 0) && (option <= 9))
					selected = true;
				else
					System.out.println("Sorry but the option must be 0..5");
				
			}
			catch (Exception e) {
				System.out.println("Sorry you did not enter a valid option");
				sc.next();
			}		
		}
				
		return option;
	}
	
	//-------------------------------------
	//	MAIN
	//-------------------------------------	
	public static void main(String[] args) {
		boolean finish = false;

		while (finish == false){

			//2.1. We clear the screen
			for (int i = 0; i < 100; i++)
				System.out.println();
			
			//2.2. Ask for the next operation to be performed
			int option = select_option();
			
			//2.3. Perform the operations
			switch (option){
			case 1: 
				example1();
				break;
			case 2: 
				example2();
				break;
			case 3: 
				example3();
				break;
			case 4: 
				example4();
				break;
			case 5: 
				example5();
				break;
			default: 
				finish = true;
				break;
			}
			System.out.println("---Please a key to continue---");
			sc.nextLine();
		}	
	}
	
}
