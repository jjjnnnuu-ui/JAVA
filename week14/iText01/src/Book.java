public class Book {
    private String title;
    private int price;
    private int qty;
    private String isbn;

    public Book(String title, int price, int qty, String isbn) {
        this.title = title;
        this.price = price;
        this.qty = qty;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }
}
