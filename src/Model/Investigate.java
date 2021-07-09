package Model;
public class Investigate {
    protected String title;
    protected String linkImage;
    public String getTitle() {
		return title;
	}
    public String getLinkImage() {
		return linkImage;
	}
    public Investigate(String title,String linkImage) {
		this.title = title;
		this.linkImage = linkImage;
	}
}