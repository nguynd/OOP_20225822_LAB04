package hust.soict.dsai.aims.media;
import java.util.Comparator;

public abstract class Media implements Comparable<Media> {
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
    private int id;
	private String title;
	private String category;
	private float cost;
	private static int nbMedia = 0;
	public Media(String title) {
        this.title = title;
		this.id = ++nbMedia;
    }
    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        this.id = ++nbMedia;
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbMedia;
    }
	public Media() {	
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public boolean isMatch(String ktitle) {
		return this.getTitle().toLowerCase().contains(ktitle.toLowerCase());
	}
	public void play() {
        System.out.println("Playing media");
    }
	@Override
    public String toString() {
        return this.getId()+ ". Media - " + this.getTitle() +" - " + this.getCategory() +" - " + this.getCost() + "$";
    }
	@Override
	public boolean equals(Object obj) {
		if(obj == this) {
			return true;
		}
		if (!(obj instanceof Media)) {
			return false;
		}
	return ((Media)obj).getTitle() == this.getTitle();
	}
	@Override
	public int compareTo(Media other) {
		int titleComp = this.getTitle().compareTo(other.getTitle());
		if (titleComp != 0) {
			return titleComp;
		}else {
				return Double.compare(this.getCost(), other.getCost());
			}
		}
	}


