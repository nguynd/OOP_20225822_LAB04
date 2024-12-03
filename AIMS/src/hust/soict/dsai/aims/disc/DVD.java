package hust.soict.dsai.aims.disc;

public class DVD {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	private static int nbDVD = 0;
	private int id;
	public DVD(String title) {
		super();
		this.title = title;
		this.id=++nbDVD;
	}
	public DVD(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id=++nbDVD;
	}
	public DVD(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id=++nbDVD;
	}
	public DVD(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id=++nbDVD;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	 @Override
	public String toString() {
			return this.id + ". DVD - " + this.title + " - " + this.category +" - " + this.director +" - "+ this.length +" - " + this.cost + "$";
	}
	 
	public boolean isMatch(String ktitle) {
		return this.title.toLowerCase().contains(ktitle.toLowerCase());
	}
	
}
