	
public class InvalidOptionException extends IllegalArgumentException {
	
	//use of a custom exception to further restrict illegal argument
	public InvalidOptionException(int userInput) {
		if(userInput > 4)
			System.out.println("Invalid input. Please enter a valid menu option.");
	}

}
