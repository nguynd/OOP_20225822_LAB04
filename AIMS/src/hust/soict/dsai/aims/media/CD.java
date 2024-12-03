package hust.soict.dsai.aims.media;
import java.util.List;
import java.util.ArrayList;

public class CD extends Disc implements Playable{
	
	public CD() {	// TODO Auto-generated constructor stub
	}
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public CD(String title) {
        super(title);
    }    
    public CD(String title, String category, float cost) {
        super(title, category, cost);
    }
    public CD(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }
	public String getArtist() {
		return artist;
	}
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("Track: " + track.getTitle() + " has been added to CD: " + this.getTitle());
			}else {
			 System.out.println("Track already added.");
			}
	}
	public void removeTrack (Track track) {
		if(!tracks.contains(track)) {
			tracks.remove(track);
		}
		else System.out.println("Can't find author");
	}
	@Override
	public int getLength() {
		int totalLength = 0;
		for (Track track : tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		for(Track track:tracks) {
			track.play();
		}
	}
		
	@Override
    public String toString() {
        return this.getId() + ". CD - " + this.getTitle() +" - " + this.getCategory() +" - " + this.getArtist() +" - " + this.getLength() + " seconds" + " - " + this.getCost() + "$";
    }
	
}
	

