
public class myMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Creating a stack of five elements");
		myStackArray stack = new myStackArray(5);
		System.out.println("Adding elements:");
		for (int i = 1; i <= 6; i++) 
			System.out.println(stack.push(i)? "Number " + i + " added successfully."/* + stack.printArray()*/:"Unable to add number " + i );
		System.out.println();
		System.out.println("Removing items now");
		for (int i = 6; i > 0; i--)
			System.out.println("Item " + stack.pop() + " removed successfully."/* + stack.printArray()*/);
		System.out.println("Removing an extra item");
		stack.pop();
	}

}
