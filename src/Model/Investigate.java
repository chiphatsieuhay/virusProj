package Model;
public class Investigate {
    protected String title;
    protected String linkImage;
    public void getTitle() {
		return title;
	}
    public void getLinkImage() {
		return linkImage;
	}
    public Investigate(String title,String linkImage) {
		this.title = title;
		this.linkImage = linkImage;
	}
}