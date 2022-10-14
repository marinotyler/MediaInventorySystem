
public abstract class Media{
	private int id;
	private int yearPublished;
	private String title;
	private boolean isRented;

	//constructor
	public Media(int id, int yearPub, String title, boolean isRented) {
		this.id = id;
		yearPublished = yearPub;
		this.title = title;
		this.isRented = false;

	}
	 // constructor to parse string with xml tags for its values
    public Media(String line) {
        id = Integer.parseInt(line.substring(line.indexOf("<id>") + 4, line.indexOf("</id>")));
        yearPublished = Integer.parseInt(line.substring(line.indexOf("<published>") + 11, line.indexOf("</published>")));
        title = line.substring(line.indexOf("<title>") + 7, line.indexOf("</title>"));
        isRented = Boolean.parseBoolean(line.substring(line.indexOf("<Rented>") + 8, line.indexOf("</Rented>")));	
    }
 
    //getters
	public int getID() {
		return id;
	}
	public int getYearPub() {
		return yearPublished;
	}
	public String getTitle() {
		return title;
	}
	
	public boolean getIsRented() {
		if(isRented) {
			return isRented; 
		}else
			return isRented;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setYearPub(int yearPub) {
		this.yearPublished = yearPub;
	}
	public double calcRentFee() {
		return 3.50;
	}
	public void setIsRented() {
		if(!isRented)
			this.isRented = true;
	}
}



