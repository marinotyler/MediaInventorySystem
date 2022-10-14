/*Tyler Marino | CMIS 242 | December 14th, 2021
 * This is program will take an input file of media objects and store them within a manager that allows user to perform functions such as search and add on the data set.
 * The user can also use the system to rent an item from the internal database 
 */
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MediaRentalSystem{
	
	public static void printMenu() {
	System.out.println("Welcome to the media rental system");
	System.out.println("1: Load media objects");
	System.out.println("2: Find media objects");
	System.out.println("3: Rent media objects");
	System.out.println("4: Quit");
}

	public static void main(String[] args) throws InvalidOptionException, FileNotFoundException {
		System.out.println("Tyler Marino | CMIS 242 | December 14th, 2021");
		
		//local variable declarations
		Scanner scan = new Scanner(System.in);
		Scanner scanstr = new Scanner(System.in);
		Manager mediaManager = new Manager();
		String directory;
		int userChoice;
		
		//creates sample to data to test program
		Ebook ebook1 = new Ebook(123456, 1972, "Alice in Wonderland", 13, false);
		Ebook ebook2 = new Ebook(678901, 2001, "Meat Boy", 10, false);
		MovieDVD movieDvd1 = new MovieDVD(777888, 2022, "Fast and Furious 11", 3.5, true);
		MovieDVD movieDvd2 = new MovieDVD(345678, 1980, "Star Wars", 2.5, false);
		//MusicCD musicCd1 = new MusicCD(256734, 2014, "Hallelujah", 62, false);
		//MusicCD musicCd2 = new MusicCD(111111, 1999, "Pimp Squad", 75, true);

		//adds sample data set to manager class
		mediaManager.addMedia(ebook1);
		mediaManager.addMedia(ebook2);
		mediaManager.addMedia(movieDvd1);
		mediaManager.addMedia(movieDvd2);
		//mediaManager.addMedia(musicCd1);
		//mediaManager.addMedia(musicCd2);
		
		//creates files from sample data
		                                                         
			System.out.println("Enter your desired directory path: ");
			directory = scanstr.nextLine();						
			mediaManager.createMediaFiles(directory);                                             
		
		//allows user to navigate menu
		do {
			printMenu();                                   
			System.out.println("Enter you selection: ");
			userChoice = scan.nextInt();
		
			switch(userChoice) {
		
			case 1:
				System.out.println("Enter path(directory) where to load from: ");
				directory = scanstr.next();
				try{
					mediaManager.manager(directory);
				}catch (FileNotFoundException e) {
					System.out.println("File cannot be opened: Could not load,no such directory");
				}
				mediaManager.createMediaFiles(directory);
				mediaManager.displayAllMedia();
				break;
		
			case 2:
				System.out.println("Enter path(directory) where to load from: ");
				directory = scanstr.next();
				
				System.out.println("Please enter the title you wish to find: ");
				String title = scanstr.next();
				mediaManager.findMedia(title);
				break;
			
			case 3:
				System.out.println("Enter path(directory) where to load from: ");
				directory = scanstr.next();
				System.out.println("Please enter the ID number of the item you would like to rent: ");
				int id = scan.nextInt();
				mediaManager.rentMedia(id);
				break;
			case 4:
				break;
			
			default:
				throw new InvalidOptionException(userChoice);
			}
		}while (userChoice != 4);
		
		System.out.println("Thanks for renting from us. Goodbye!");
	}

}
