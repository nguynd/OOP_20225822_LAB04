package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.carts;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.*;
public class AIMS {
	private static Store store = new Store();
	private static carts cart = new carts();
	
	public static void main(String[] args) {
		StoreSetup();
		boolean exit = false;
	while(!exit) {
		showMenu();
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		scanner.nextLine();
		switch(option) {
		case 0:
			exit=true;
			System.out.println("Done");
			break;
		case 1:
			clearConsole();
			storeMenu(scanner);
			break;
		case 2:
			clearConsole();
			updateStoreMenu(scanner);
			break;
		case 3:
			clearConsole();
			cartMenu(scanner);
			break;
		default:
			clearConsole();
			System.out.println("Choose again");
		}
	}
	
	}
	public static void StoreSetup() {

	    // DVD
	    DVD dvd1 = new DVD("Fallen Angels", "Crime/Drama", "Wong Kar Wai", 99, 14.99f);     
	    DVD dvd2 = new DVD("In the Mood for Love", "Romance", "Wong Kar Wai", 98, 19.99f); 
	    DVD dvd3 = new DVD("Chungking Express", "Crime/Romance", "Wong Kar Wai", 102, 12.99f);
	    store.addMedia(dvd1);
	    store.addMedia(dvd2);
	    store.addMedia(dvd3);

	    // Book
	    Book book = new Book("Norwegian Wood", "Fiction", 10.99f);
	    Book book1 = new Book("Kafka on the Shore", "Fiction", 12.99f);
	    Book book2 = new Book("Sapiens: A Brief History of Humankind", "Science", 20.00f);
	    Book book3 = new Book("Atomic Habits", "Self-help", 16.00f);
	    store.addMedia(book);
	    store.addMedia(book1);
	    store.addMedia(book2);
	    store.addMedia(book3);

	    // CD
	    CD cd1 = new CD("Alexander Rybak - No Boundaries", "Music", "Alexander Rybak", 299.99f);
	    Track track1CD1 = new Track("First Kiss", 198);
	    Track track2CD1 = new Track("Europe's Skies", 179);
	    Track track3CD1 = new Track("I'm in Love", 193);
	    Track track4CD1 = new Track("Oah", 191);
	    cd1.addTrack(track1CD1);
	    cd1.addTrack(track2CD1);
	    cd1.addTrack(track3CD1);
	    cd1.addTrack(track4CD1);

	    CD cd2 = new CD("Purpose", "Music", "Justin Bieber", 1000.98f);
	    Track track1CD2 = new Track("The Feeling", 4 * 60 + 5);
	    Track track2CD2 = new Track("No Sense", 4 * 60 + 35);
	    cd2.addTrack(track1CD2);
	    cd2.addTrack(track2CD2);

	    CD cd3 = new CD("The Gods We Can Touch", "Music", "Aurora", 2000.22f);
	    Track track1CD3 = new Track("Everything Matters", 180 + 34);
	    Track track2CD3 = new Track("Blood in the Wine", 180 + 30);
	    Track track3CD3 = new Track("Artemis", 60 * 2 + 39);
	    cd3.addTrack(track1CD3);
	    cd3.addTrack(track2CD3);
	    cd3.addTrack(track3CD3);

	    // Add CDs to store
	    store.addMedia(cd1);
	    store.addMedia(cd2);
	    store.addMedia(cd3);

	    // Clear console (if applicable)
	    clearConsole();
	}
	public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
	public static void showMenu() {
		System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void storeMenu(Scanner scanner) {
		boolean back = false;
		while (!back) {
			store.print();
			System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch(option) {
            case 0:
            	clearConsole();
            	back=true;
            	break;
            case 1:
            	boolean fDetails = false;
            	while (!fDetails) {
            		System.out.println("Enter the title (0 to stop)");
            		String title = scanner.nextLine();
            		if (title.equals("0")) {
            			clearConsole();
            			break;
            		}
            		Media media = store.search(title);
            		if(media != null) {
            			clearConsole();
            			System.out.println("Details: ");
            			System.out.println(media);
            			mediaDetailsMenu(scanner, media);
            			fDetails = true;
            		}else {
            			System.out.println("Not found");
            		}
            	}
            	break;
            case 2:
            	boolean fadd = false;
            	while(!fadd) {
            		System.out.println("Enter the title (0 to stop)");
            		String title = scanner.nextLine();
            		if(title.equals("0")) {
            			clearConsole();
            			break;	
            		}
            		Media media = store.search(title);
            		if (media != null) {
            			cart.addMedia(media);
            			fadd = true;
            		} else {
            			System.out.println("Not found");
            		}
            	}
            	break;
            case 3:
            	boolean fplay = false;
            	while (!fplay) {
            		System.out.println("Enter the title (0 to stop)");
            		String title = scanner.nextLine();
            		if(title.equals("0")) {
            			clearConsole();
            			break;	
            		}
            		 Media media = store.search(title);
                     if (media != null) {
                    	 if(media instanceof Disc || media instanceof CD) {
                    		 media.play();
                    	 } else {
                    		 System.out.println("Cannot play");
                    	 }
                    	 fplay = true;
                     }else {
                    	 System.out.println("Not found");
                     }
            	}
            	break;
            case 4:
            	clearConsole();
            	cartMenu(scanner);
            	break;
            default:
            	clearConsole();
            	System.out.println("Choose again");
            	break;
            }
            
		}
	}
	public static void mediaDetailsMenu(Scanner scanner, Media media) {
		  boolean back = false;
	        while (!back) {
	            System.out.println("Options: ");
	            System.out.println("--------------------------------");
	            System.out.println("1. Add to cart");
	            System.out.println("2. Play");
	            System.out.println("0. Back");
	            System.out.println("--------------------------------");
	            System.out.println("Please choose a number: 0-1-2");
	            int option = scanner.nextInt();
	            scanner.nextLine();
	            switch(option) {
	            case 0:
	            	clearConsole();
	            	back = true;
	            	break;
	            case 1:
	            	cart.addMedia(media);
	            	break;
	            case 2:
	            	if (media instanceof Disc || media instanceof CD) {
                        media.play();
                    } else {
                        System.out.println("Cannot play");
                    }
                    break;
                default:
                    clearConsole(); 
                    System.out.println("Choose again");
	            }	
	        }
	}
	public static void cartMenu(Scanner scanner) {
		boolean back = false;
        while (!back) {
            cart.print();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                	clearConsole();
                	back = true;
                	break;
                case 1:
                	System.out.println("Filter by (1) id or (2) title. (0) to stop");
                	int filterOption = scanner.nextInt();
                	scanner.nextLine();
                	boolean found = false; 
                	while(!found) {
                		if (filterOption == 1) {
                			System.out.println("Enter id(0 to stop)");
                			int id = scanner.nextInt();
                			scanner.nextLine();
                			if(id==0) {
                				clearConsole();
                				break;
                			}
                			cart.searchID(id);
                			found=true;
                		} else if (filterOption == 2) {
                			System.out.println("Enter id(0 to stop)");
                			String title = scanner.nextLine();
                			if(title.equals("0")) {
                				clearConsole();
                				break;
                			}
                			cart.searchTitle(title);
                			found=true;
                		}else if (filterOption == 0) {
                            clearConsole();
                            break;
                		} else {
                			System.out.println("Choose again");
                		}
                	}
                	break;
                case 2: 
                	System.out.println("Sort by (1) title or (2) cost. (0) to stop");
                	int sortOption = scanner.nextInt();
                	scanner.nextLine();
                	if (sortOption == 1) {
                        cart.sortMediaByTitle();
                    } else if (sortOption == 2) {
                        cart.sortMediaByCost();
                    } else {
                        System.out.println("Choose again.");
                    }
                    break;
                case 3:
                	boolean fremove = false;
                	while (!fremove) {
                		System.out.println("Enter title(0 to stop)");
                		String title = scanner.nextLine();
                		if(title.equals("0")) {
                			clearConsole();
                			break;
                		}
                		Media media = cart.searchToRemove(title);
                		if (media != null) {
                			clearConsole();
                			cart.removeMedia(media);
                			fremove= true;
                		} else {
                			System.out.println("Not found");
                		}
                	}
                	break;
                case 4:
                	boolean fplay = false;
                	while (!fplay) {
                		System.out.println("Enter title(0 to stop)");
                		String title = scanner.nextLine();
                		if(title.equals("0")) {
                			clearConsole();
                			break;
                		}
                		Media media = store.search(title);
                		if (media != null) {
                			if (media instanceof Disc || media instanceof CD) {
                				media.play();
                		} else {
                			System.out.println("Cannot play");
                		}
                		fplay = true;
                	} else {
                		System.out.println("Not found");
                		}
                	}
                	break;
                case 5:
                	clearConsole();
                	cart.placeOrder();
                	break;
                default:
                	clearConsole();
                	System.out.println("Choose again");
                	break;
            }
        }
	}
	public static void updateStoreMenu(Scanner scanner) {
		 boolean back = false;
	        while (!back) {
	            System.out.println("Options: ");
	            System.out.println("--------------------------------");
	            System.out.println("1. Add a media");
	            System.out.println("2. Remove a media");
	            System.out.println("0. Back");
	            System.out.println("--------------------------------");
	            System.out.println("Please choose a number: 0-1-2");
	            int option = scanner.nextInt();
	            scanner.nextLine();
	            switch (option) {
	            case 0:
	            	clearConsole();
	            	back=true;
	            	break;
	            case 1:
	            	System.out.println("Enter type (1) book, (2) CD, (3) DVD, (0) exit");
	            	int typeChoice = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (typeChoice == 1) {
                    	 System.out.println("Book title: ");
                         String bookTitle = scanner.nextLine();
                         System.out.println("Book category: ");
                         String bookCategory = scanner.nextLine();
                         System.out.println("Book cost: ");
                         Float bookCost = scanner.nextFloat();
                         scanner.nextLine();
                         
                         Book newBook = new Book(bookTitle, bookCategory, bookCost);
                         store.addMedia(newBook);
                    }
                    else if (typeChoice == 2) {
                        System.out.println("CD title: ");
                        String cdTitle = scanner.nextLine();
                        System.out.println("CD category: ");
                        String cdCategory = scanner.nextLine();
                        System.out.println("CD artist: ");
                        String cdArtist = scanner.nextLine();
                        System.out.println("CD cost: ");
                        Float cdCost = scanner.nextFloat();
                        scanner.nextLine();

                        CD newCD = new CD(cdTitle, cdCategory, cdArtist, cdCost);
                        System.out.println("Add tracks to CD? (1) Yes (0) No:");
                        int addTrack = scanner.nextInt();
                        scanner.nextLine();
                        if (addTrack == 1) {
                            System.out.println("Number of tracks: ");
                            int numTrack = scanner.nextInt();
                            scanner.nextLine();
                            for (int i = 0; i < numTrack; i++) {
                                System.out.println((i+1) + " track: ");
                                System.out.println("Track title: ");
                                String trackTitle = scanner.nextLine();
                                System.out.println("Track length: ");
                                int trackLength = scanner.nextInt();
                                scanner.nextLine();
                                Track newTrack = new Track(trackTitle, trackLength);
                                newCD.addTrack(newTrack);
                            }
                            store.addMedia(newCD);
                        } else if (addTrack == 0) {
                            store.addMedia(newCD);
                        }
                    } else if (typeChoice == 3) {
                    	 System.out.println("DVD title: ");
                         String dvdTitle = scanner.nextLine();
                         System.out.println("DVD category: ");
                         String dvdCategory = scanner.nextLine();
                         System.out.println("DVD director: ");
                         String dvdDirector = scanner.nextLine();
                         System.out.println("DVD length: ");
                         int dvdLength = scanner.nextInt();
                         System.out.println("DVD cost: ");
                         Float dvdCost = scanner.nextFloat();
                         scanner.nextLine();
                         
                         DVD newDVD = new DVD(dvdTitle, dvdCategory, dvdDirector, dvdLength, dvdCost);
                         store.addMedia(newDVD); 
                    } else if (typeChoice == 0) {
                        clearConsole();
                        break;
                    }else {
                        System.out.println("Choose again");
                    }
                    break;
	            case 2:
	            	boolean fremove = false;
	            	while (!fremove) {
	            		System.out.println("Enter title (0 to stop)");
                        String titleForRemove = scanner.nextLine();
                        if (titleForRemove.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(titleForRemove);
                        if (media != null) {
                            clearConsole();
                            store.removeMedia(media);
                            fremove = true;
                        } else {
                            System.out.println("Not found");
                        }
                    }
                    break;
                default:
                	clearConsole();
                    System.out.println("Choose again");
                    break;
	            }
	        }
	}
}
