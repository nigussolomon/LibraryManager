import java.io.Serializable;

public class Loan implements Serializable{
    private String first_name;
    private String last_name;
    private String Programme;
    Book loaned_book;
    
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getProgramme() {
        return Programme;
    }
    public void setProgramme(String programme) {
        Programme = programme;
    }
    public Book getLoaned_book() {
        return loaned_book;
    }
    public void setLoaned_book(Book loaned_book) {
        this.loaned_book = loaned_book;
    }

    
}
