
import java.util.Calendar;

public class Ebook extends Media{
	
	private int numChapters;
	
	public Ebook(int id, int yearPub, String title, int numChapters, boolean rented) {
		super(id, yearPub, title, rented);
		this.numChapters = numChapters;
	}
	
	//overloading constructor to parse string with xml tags for its values
    public Ebook(String line) {
        super(line);
        numChapters = Integer.parseInt(line.substring(line.indexOf("<Chapters>") + 10, line.indexOf("</Chapters>")));
    }  
	public int geNumChaps() {
		return numChapters; 
	}
	public void setNumChaps(int numChapters) {
		this.numChapters = numChapters;
	}
	@Override
	public double calcRentFee() {
		double fee = numChapters * .10;
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		
		if(this.getYearPub() == currYear) {
			fee += 1;
		}
			return fee;
	}
	@Override
	public String toString() {
		return "<Ebook>" +  "<id>" + this.getID() + "</id> " + "<title>" + this.getTitle() + " </title>" +  "<published>" + this.getYearPub() + "</published>" + "<Chapters>" + numChapters + "</Chapters> " + "<Rented>" + this.getIsRented() + "</Rented>";
	}
}

