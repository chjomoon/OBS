package book;


public class Books {

	private String bookID;
    private String isbn;
    private String category;
    private String author; 
    private String title;
    private String publisher;
    private String yearPublished;
    private int edition;
    private int quantity;
    private int price;
    
	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(String yearPublished) {
		this.yearPublished = yearPublished;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

    public Books() {
    	
    }

	public Books(String bookID, String title, String isbn, String category, String author,  String publisher,
			String yearPublished, int edition, int quantity, int price) {
		super();
		this.bookID = bookID;
		this.isbn = isbn;
		this.category = category;
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.yearPublished = yearPublished;
		this.edition = edition;
		this.quantity = quantity;
		this.price = price;
	}
    

    
}