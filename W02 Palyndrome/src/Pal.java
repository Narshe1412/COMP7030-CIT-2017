
//---------------------------------------
//	Imports
//---------------------------------------
import java.util.*;

//---------------------------------------
//
// Class Pal
//
//---------------------------------------
public class Pal {

	//---------------------------------------
	//	Attributes of the class
	//---------------------------------------
	private ArrayList<Integer> v = new ArrayList<>();
	private int pos;
	private int nm;

	//---------------------------------------
	//	Constructor
	//---------------------------------------
	public Pal(int num){
		//Initialise v
		while (num > 0){
			this.v.add(0, (num % 10));
			num = num / 10;
		}
		
		//Initialise pos
		Random rand = new Random();
		this.pos = rand.nextInt(this.v.size());

		//Initialise nm
		this.nm = 0;		
	}
	
	//---------------------------------------
	//	is_palindrome
	//---------------------------------------
	public boolean is_palindrome(){
		boolean b = true;	
		int lb = 0;
		int ub = this.v.size() -1;
		while (b && lb < ub) {
			if (this.v.get(lb) == this.v.get(ub)) {
				lb ++;
				ub --;
			} else {
				b = false;
			}
		}
		return b;
	}

	//---------------------------------------
	//	print_status
	//---------------------------------------
	public void print_status(){
		String garibalusito = " ";
		for (int i = 0; i< this.pos; i++) {
			garibalusito+= new String("   ");
		}

		System.out.println(Arrays.toString(v.toArray()));
		System.out.println(garibalusito.concat("^"));
		System.out.println("Movements: " + this.nm);
	}

	//---------------------------------------
	//	update_status
	//---------------------------------------
	public void update_status(String s){

		switch(s) {
		case "a": 
			if (this.pos > 0) {
				this.nm ++;
				this.pos --;
			}
			break;
		case "d":
			if (this.pos <= v.size()) {
				this.pos ++;
				this.nm ++;
			}
			break;
		case "w":
			if (this.v.get(pos) < 9) {
				this.v.set(pos, this.v.get(pos)+1);
				this.nm ++;
			}
			break;
		case "x":
			if (this.v.get(pos) > 0) {
				this.v.set(pos, this.v.get(pos)-1);
				this.nm ++;
			break;
			}
		}
	}
}




	
