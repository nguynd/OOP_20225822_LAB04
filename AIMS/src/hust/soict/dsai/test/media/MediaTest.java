package hust.soict.dsai.test.media;

import java.util.*;

import hust.soict.dsai.aims.media.*;

public class MediaTest {
    
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        DVD dvd = new DVD("Fallen Angels", "Crime/Drama", "Wong Kar Wai", 99, 19.95f);
        Book book = new Book("1984", "Dystopian", 15.50f);


        CD cd = new CD("Alexander Rybak - No Boundaries", "Music", "Alexander Rybak", 20.99f);
        Track track1 = new Track("First Kiss", 198);
        Track track2 = new Track("Europe's Skies", 179);
        Track track3 = new Track("I'm in Love", 193);
       


        cd.addTrack(track1);
        cd.addTrack(track2);
        cd.addTrack(track3);

        mediae.add(cd);
        mediae.add(book);
        mediae.add(dvd);    

        for (Media media : mediae) {
            System.out.println(media.toString());
        }
    }
    
}