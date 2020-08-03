package BookPackage;

public class Book {
    private String name;
    private long price;
    private String date;
    private String author;
    private String publisher;
    private String category;
    private String iD;

    public Book(String name, long price, String date, String author, String publisher,String category,String iD) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.author = author;
        this.publisher = publisher;
        this.category= category;
        this.iD=iD;
    }

    @Override
    public String toString(){
        return "Author "+ this.getAuthor()+"\n"+
                "Name "+ this.getName()+"\n"+
                "Date "+ this.getDate()+"\n"+
                "Price "+ this.getPrice()+"\n"+
                "ID "+ this.getAuthor()+"\n";
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}
