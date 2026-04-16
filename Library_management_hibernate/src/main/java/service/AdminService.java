package service;

public class AdminService {
	

	    private BookService bookService = new BookService();

	    public void addBook(int id, String name, String author, double price) {
	        bookService.addBook(id, name, author, price);
	    }

	    public void removeBook(int id) {
	        bookService.removeBook(id);
	    }

	    public void updateBook(int id, String name, String author, double price) {
	        bookService.updateBook(id, name, author, price);
	    }

	    public void searchBook(int id) {
	        bookService.searchBook(id);
	    }

	    public void showAllBooks() {
	        bookService.showAllBooks();
	    }
	}

