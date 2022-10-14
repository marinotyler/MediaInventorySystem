import java.util.Calendar;

public class MusicCD extends Media{
	
	private int length;
	
	public MusicCD(int id, int yearPub, String title, int length, boolean rented) {
		super(id, yearPub, title, rented);
		this.length = length;
	}
	
	//overloading constructor to parse string with xml tags for its values
    public MusicCD(String line) {
        super(line);
        length = Integer.parseInt(line.substring(line.indexOf("<length>") + 8, line.indexOf("</length>")));
    }
    
	public double getLength() {
		return length; 
	}
	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public double calcRentFee() {
		double fee = length * .02;
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		
		if(this.getYearPub() == currYear) {
			fee += 1;
		}
			return fee;
	}
	
	@Override
	public String toString() {
		return "<MusicCD>" +  "<id>" + this.getID() + "</id> " + "<title>" + this.getTitle() + "</title>" +  "<published>" + this.getYearPub() + "</published>" + "<length>" + length + "</length>" + "<Rented>" + this.getIsRented() + "</Rented>";
	}
}
