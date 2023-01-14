import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String category;
    private String status;
    private String date_published;
    private boolean loaned;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDate_published() {
        return date_published;
    }
    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }
    public boolean isLoaned() {
        return loaned;
    }
    public void setLoaned(boolean loaned) {
        this.loaned = loaned;
    }
    

    
}
