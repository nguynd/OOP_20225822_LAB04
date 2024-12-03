package hust.soict.dsai.aims.cart;
import java.util.*;

import hust.soict.dsai.aims.media.Media;

public class carts {
	 public static final int MAX_NUMBERS_ORDERED = 20;
	 
	 private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	 
	 	public int qtyOrdered = 0; 
	    
	 	public void addMedia(Media media) {
	 		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
	 			System.out.println("The cart is almost full!");
	 		} else {
	 			itemsOrdered.add(media);
	 			System.out.println(media.getTitle() + " has been added.");
	 			qtyOrdered +=1;
	 		}
	 	}
	 	public void removeMedia(Media media) {
	        if (itemsOrdered.size() == 0) {
	            System.out.println("Nothing to remove!");
	        } else {
	            if (itemsOrdered.remove(media)) {
	                System.out.println(media.getTitle() + " has been removed from the cart.");
	                qtyOrdered -=1;
	            } else {
	                System.out.println("Media not found in cart!");
	            }
	        }
	    }
	    public float totalCost() {
	    	float total=0;
	    	for(Media media : itemsOrdered)
	    	{	total=total+media.getCost();}
	    	return total;
	    }
	    
	    public void print() {
	    	System.out.println("***********************CART***********************");
	    	System.out.println("Ordered Items:");
	    	for(Media media : itemsOrdered) {
	    		System.out.println(media);
	    	}
	    	System.out.println("Total cost:" + totalCost());
	    	System.out.println("***************************************************");
	    }
	    public void empty() {
	        if (itemsOrdered.size() == 0) {
	            System.out.println("Nothing to remove!");
	        } else {
	            qtyOrdered = 0;
	            itemsOrdered.clear();
	            System.out.println("Remove all");
	            System.out.println();
	        }
	    }
	    public void placeOrder() {
	    	if (itemsOrdered.size() == 0) {
	    		System.out.println("Your cart is empty!");
	        } else {
	        	System.out.println("Order placed");
	        	itemsOrdered.clear();
	        }
	    }
	    public void searchTitle(String kword) {
	    	boolean match = false;
	    	for (Media media : itemsOrdered) {
	    		if(media.isMatch(kword)) {
	    			System.out.println("Found " + media);
	    			match = true;
	    		}
	    	}
	    	if (!match) {
	    		System.out.println("Cant find DVDs with " + kword +" in the title");
	    	}
	    }
	   
	    public void searchID(int sId) {
	    	boolean found = false;
	    	for(Media media : itemsOrdered) {
	    		if(media.getId() == sId) {
	    			System.out.println("Found " + media);
	    			found = true;
	    		}
	    	}
	    	if (!found) {
	    		System.out.println("Cant find DVD with id:" + sId);
	    	}
	    }
	    public Media searchToRemove(String title) {
			for (Media media : itemsOrdered) {
				if (media.getTitle().equals(title)) {
					return media;
				}
			}
			return null;
		}
	    public void sortMediaByTitle() {
	        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	        Iterator<Media> iterator = itemsOrdered.iterator();
	        iterator = itemsOrdered.iterator();
	    
	        while (iterator.hasNext()) {
	            System.out.println(((Media)iterator.next()).toString());
	        }
	    }
	    public void sortMediaByCost() {
	        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	        Iterator<Media> iterator = itemsOrdered.iterator();
	        iterator = itemsOrdered.iterator();
	    
	        while (iterator.hasNext()) {
	            System.out.println(((Media)iterator.next()).toString());
	        }
	    }
	    
}
