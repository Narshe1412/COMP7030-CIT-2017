
public interface myStack {
	//Add an INT to the top of the stack. Returns true if success, false otherwise
	public boolean push(int num);
	
	//Removes the top element of the stack. Returns the number removed. -1 if unsuccessful
	public int pop();
	
	//For troubleshooting purposes
	public String printArray();
	
}
