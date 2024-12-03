package hust.soict.dsai.aims.media;

public class Track implements Playable{

	public Track() {
		// TODO Auto-generated constructor stub
	}

	private int length;
	private String title;
	
	public Track(String title, int length) {
	        this.title = title;
	        this.length = length;
	    }
	
	public int getLength() {
		return length;
	}
	public String getTitle() {
		return title;
	}
	
	@Override
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("track length: " + this.getLength());
	}
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {  
	            return true;
	        }
	        if (!(obj instanceof Track)) {
	            return false;
	        }
	        return ((Track)obj).getTitle() == this.getTitle() && ((Track)obj).getLength() == this.getLength();
	    }
	
	
	
}
