package hust.soict.dsai.aims.media;
import java.util.List;
import java.util.ArrayList;

public class Book extends Media{
	public Book(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String category) {
		super(title, category);
		// TODO Auto-generated constructor stub
	}

	public Book(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	private List<String> authors = new ArrayList<String>();
	public Book() {
	}
	
	public List<String> getAuthors() {
		return authors;
	}

	public void addAuthor(String authorName){
		if(!authors.contains(authorName)) {
			authors.add(authorName);
		}
		else System.out.println("Already in the list.");
	}
	
	public void removeAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			authors.remove(authorName);
		}
		else System.out.println("Can't find author");
	}
	@Override
	public String toString() {
		return this.getId() + ". Book - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getCost() + "$";
}
}
