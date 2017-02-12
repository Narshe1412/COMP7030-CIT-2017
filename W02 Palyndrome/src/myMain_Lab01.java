
import java.io.*;

public class myMain_Lab01 {
	
	//---------------------------------------
	//	check_message
	//---------------------------------------
	public static boolean check_message(int m){
		return (m >= 100000 && m< 1000000);
	}
	
	//---------------------------------------
	//	get_number
	//---------------------------------------
	public static int get_number(BufferedReader br){
		int i = 0;
		Boolean satisfied = false;
		while (!satisfied) {
			try {
				i = Integer.parseInt(br.readLine());
				satisfied = check_message(i);
				if (satisfied) return i;
			} catch (Exception e){
				continue;
			}
			System.out.println("Number too small or too big");
		}
		return i;
	}

	//---------------------------------------
	//	ask_for_movement
	//---------------------------------------
	public static String ask_for_movement(BufferedReader br){
		String s = "";
		Boolean satisfied = false;
		while(!satisfied) {
			try {
				s = br.readLine().toLowerCase();
				if (s.contains("a") || s.contains("d") || s.contains("w") || s.contains("x")) return s;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.println("Incorrect Command");
		}
		return s;
	}
	
	//---------------------------------------
	//	main
	//---------------------------------------
	public static void main(String[] args) {
		//Set the initial status of the game				
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Type a number");
			int number = get_number(br);
			Pal my_pal = new Pal(number);
		
			//While the number is not a palindrome
			while (my_pal.is_palindrome() == false){
				//We print the current status
				my_pal.print_status();
			
				//We ask for a new movement
				System.out.println("Please issue a command A D / W X");
				String mov = ask_for_movement(br);

				//We process the movement
				my_pal.update_status(mov);
			}
		
			//We print the end of game message and the status
			System.out.println("-----------------");
			System.out.println(" Solved!");
			System.out.println("-----------------");
			my_pal.print_status();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
}
