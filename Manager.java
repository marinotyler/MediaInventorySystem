import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
	//initialize attribute
	public ArrayList<Media> orderSystem;
	
	//default constructor
	public Manager() {
		orderSystem = new ArrayList<Media>();
	}
	
	//method to accept the data from the file, parse through it and store as individual objects
	public void manager(String directory) throws FileNotFoundException {
		orderSystem = new ArrayList<Media>();
		
		File directoryPath = new File(directory);
		
		//lists all file names and stores in list
		File mediaFilesList[] = directoryPath.listFiles();
		
		if(mediaFilesList == null)
			throw new FileNotFoundException("Could not load, no such directory");
		
		//local variables
		Media media = null;
		String line = null;
		Scanner scan = null;
		
		//reads the file and stores objects to array
		for(File file : mediaFilesList) {
			if(file.getName().contains("Ebook") || file.getName().contains("MovieDVD") || file.getName().contains("MusicCD")) {
				scan = new Scanner(file);
				line = scan.nextLine();
				
				if(file.getName().contains("Ebook"))
					media = new Ebook(line);
			
				if(file.getName().contains("MovieDVD"))
					media = new MovieDVD(line);
			
				//if(file.getName().contains("MusicCD"));
				//media = new MusicCD(line);
				
				orderSystem.add(media);
			}
		}
	}
	
	//displays all available media objects to the user
	public void displayAllMedia() {
		for(int i = 0; i < orderSystem.size(); i++)
			System.out.println(orderSystem.get(i).toString());
	}
	
	//creates separate files for new media objects
	public void createMediaFiles(String directory) {
		//initiate file writer
		PrintWriter out = new PrintWriter(directory);
		
		//names files based on naming convention
		for(int i = 0; i < orderSystem.size(); i++) {
			String mediaFileName = directory + "\\" + orderSystem.get(i).getClass().getSimpleName() + "-" + orderSystem.get(i).getID() + ".txt";
		try {
			out = new PrintWriter(new FileWriter(mediaFileName));
		} catch (IOException e) {\
			e.printStackTrace();
		}
		out.println(orderSystem.get(i).toString());
		out.flush();    //ensures object prints to file
		out.close();	//closes writer
		}
	}
		
	//add media items to list manually
	public void addMedia(Media media) {
		orderSystem.add(media);
	}
	
	//find media
	public void findMedia(String title) {
		boolean matchFound = false;
		for(int j = 0; j < orderSystem.size(); j++) {
			Media m = orderSystem.get(j);
			m.toString();
			String mediaTitle = m.getTitle();
			if(title.equalsIgnoreCase(mediaTitle)) {
				m.toString();
				matchFound = true;
			}
		}
		if(!matchFound)
			System.out.println("No media with the title " + title + " found");
	}
	
	//rent media
	public double rentMedia(double id) {
		boolean idMatchFound = false;
		double rentFee = 0.0;
		for(int n = 0; n < orderSystem.size(); n++) {
			Media m = orderSystem.get(n);
			int mediaID = m.getID();
				if(id == mediaID) {
					if(m.getIsRented()!= true) {
							m.setIsRented();
							rentFee = m.calcRentFee();
							idMatchFound = true;
							System.out.println("Media has been rented. Rental fee = $" + rentFee);
					}
				}
		}
		if(!idMatchFound)
			System.out.println("Media with ID #" + id + " is not found");
		return rentFee;
	}
}

