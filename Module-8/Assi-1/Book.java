/**
 * @author Madhuri
 */
public class Book implements Comparable<Book> {
	String title;
	String author;
	double price;
	
	public Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	/**
	 * @param that 
	 * comparision function for comparing the title of the books
	 */
	public int compareTo(Book that) {
		return this.title.compareTo(that.title);
	}
}