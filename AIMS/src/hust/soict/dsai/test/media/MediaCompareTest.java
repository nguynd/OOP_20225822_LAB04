package hust.soict.dsai.test.media;

import java.util.*;

import hust.soict.dsai.aims.media.*;

public class MediaCompareTest {
    
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        // DVD
        DVD dvd = new DVD("Fallen Angels", "Crime/Drama", "Wong Kar Wai", 99, 14.99f);
        DVD dvd2 = new DVD("In the Mood for Love", "Romance", "Wong Kar Wai", 98, 19.99f);
        DVD dvd3 = new DVD("Chungking Express", "Crime/Romance", "Wong Kar Wai", 102, 12.99f);

        // Books
        Book book = new Book("Norwegian Wood", "Fiction", 10.99f);
        Book book1 = new Book("Kafka on the Shore", "Fiction", 12.99f);
        Book book2 = new Book("Sapiens: A Brief History of Humankind", "Science", 20.00f);
        Book book3 = new Book("Atomic Habits", "Self-help", 16.00f);

        // CD
        CD cd = new CD("Alexander Rybak - No Boundaries", "Music", "Alexander Rybak", 299.99f);
        Track track1 = new Track("First Kiss", 198);
        Track track2 = new Track("Europe's Skies", 179);
        Track track3 = new Track("I'm in Love", 193);
        Track track4 = new Track("Oah", 191);

        cd.addTrack(track1);
        cd.addTrack(track2);
        cd.addTrack(track3);
        cd.addTrack(track4);

        // Add to list
        mediae.add(cd);
        mediae.add(book);
        mediae.add(book1);
        mediae.add(book2);
        mediae.add(book3);
        mediae.add(dvd);   
        mediae.add(dvd2);     
        mediae.add(dvd3);    

        // Sort using override compareto method
        System.out.println();
        System.out.println("*******SORT USING OVERRIDE compareTo method*******");
        Collections.sort(mediae);
        Iterator<Media> iterator = mediae.iterator();
        
        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
        
        System.out.println("**************************************************");
        
        // Sort by title using comparator
        System.out.println();
        System.out.println("**********SORT BY TITLE USING COMPARATOR**********");
        Collections.sort((List<Media>)mediae, Media.COMPARE_BY_TITLE_COST);
        iterator = mediae.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
        System.out.println("**************************************************");
        
        // Sort by cost using comparator
        System.out.println();
        System.out.println("**********SORT BY COST USING COMPARATOR************");
        Collections.sort((List<Media>)mediae, Media.COMPARE_BY_COST_TITLE);
        iterator = mediae.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
        System.out.println("**************************************************");
    }
}
