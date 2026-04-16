package service;
import dao.BookDAO;
import entity.Book;
import java.util.List;

public class BookService {
	

	    private BookDAO dao = new BookDAO();
         
	    public void addBook(int id, String name, String author, double price) {
	        dao.addBook(new Book(id, name, author, price));
	        System.out.println("Book Added!");
	    }

	    public void removeBook(int id) {
	        dao.deleteBook(id);
	        System.out.println("Book Removed!");
	    }

	    public void updateBook(int id, String name, String author, double price) {
	        Book b = dao.findBook(id);
	        if (b != null) {
	            b.setBookName(name);
	            b.setAuthorName(author);
	            b.setPrice(price);
	            dao.updateBook(b);
	            System.out.println("Updated!");
	        }
	    }

	    public void searchBook(int id) {
	        Book b = dao.findBook(id);
	        if (b != null)
	            System.out.println(b.getBookName() + " " + b.getStatus());
	        else
	            System.out.println("Not Found!");
	    }

	    public void showAllBooks() {
	        List<Book> list = dao.getAllBooks();
	        list.forEach(b -> System.out.println(
	                b.getBookId() + " " + b.getBookName() + " " + b.getStatus()));
	    }

	    public List<Book> getAllBooks() {
	        return dao.getAllBooks();
	    }
	}

