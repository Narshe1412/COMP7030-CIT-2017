import java.util.Arrays;

public class myStackArray implements myStack{

	private Integer[] myArray;
	private int index;
	
	public myStackArray(int size){
		//constructor
		this.myArray = new Integer[size];
		this.index = 0;
	}
	
	public boolean push(int num) {
		try {
			if (isFull()) {
				this.myArray = resize(this.myArray);
			}
			this.myArray[index] = num;
			this.index += 1;
		} catch (Exception e){
			System.out.println("There was a problem adding " + num + " to the stack.");
			return false;
		}
		return true;
	}
	
	public int pop() {
		int value=-1;
		if(isEmpty()) {
			System.out.println("Array is empty, cannot remove more elements.");
		} else {
			this.index -= 1;
			value= this.myArray[this.index];
		}
		return value;

	}
	
	private Integer[] resize(Integer[] original) {
		Integer[] newArray = new Integer[(int) Math.round(original.length * 1.5)];
		for (int i = 0; i< original.length; i++) 
			newArray[i] = original[i];
		return newArray;
	}
	
	private boolean isFull(){
		return this.index >= this.myArray.length;
	}
	
	private boolean isEmpty(){
		return this.index == 0;
	}

	public String printArray(){
		return Arrays.toString(this.myArray) + " size: " +  this.index;
	}
}
