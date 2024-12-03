package hust.soict.dsai.aims.media;

public class DVD extends Disc implements Playable {
	public DVD(String title) {
        super(title);
    }    
    public DVD(String title, String category, float cost) {
        super(title, category, cost);
    }
    public DVD(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }
    public DVD(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
	@Override
	public String toString() {
			return this.getId() + ". DVD - " + this.getTitle() + " - " + this.getCategory() +" - " + this.getDirector() +" - "+ this.getLength() +" - " + this.getCost() + "$";
	}
	 
	public boolean isMatch(String ktitle) {
		return this.getTitle().toLowerCase().contains(ktitle.toLowerCase());
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength()); 	
	}
	
}
