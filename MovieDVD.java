public class MovieDVD extends Media{
	private double size;
	
	public MovieDVD(int id, int yearPub, String title, double size, boolean rented) {
		super(id, yearPub, title, rented);
		this.size = size;
}
	//overloading constructor to parse string with xml tags for its values
    public MovieDVD(String line) {
        super(line);
        size = Double.parseDouble(line.substring(line.indexOf("<size>") + 6, line.indexOf("</size>")));
    }  
	public double getSize() {
		return size; 
	}
	public void setSize(double size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "<MovieDVD>" +  "<id>" + this.getID() + "</id> " + "<title>" + this.getTitle() + "</title>" +  "<published>" + this.getYearPub() + "</published>" + "<size>" + size + "</size> " + "<Rented>" + this.getIsRented() + "</Rented>";
	}
}
	
