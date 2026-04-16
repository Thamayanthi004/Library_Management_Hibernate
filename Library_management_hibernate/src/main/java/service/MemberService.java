package service;
import dao.*;
import entity.*;
import java.util.List;

public class MemberService {

    private MemberDAO memberDAO = new MemberDAO();
    private BookDAO bookDAO = new BookDAO();

    public void registerMember(int id, String name, String phone) {
        memberDAO.addMember(new Member(id, name, phone));
        System.out.println("Registered!");
    }

    public boolean login(int id) {
        return memberDAO.findMember(id) != null;
    }

    public void issueBook(int bookId) {
        Book b = bookDAO.findBook(bookId);
        if (b != null && b.getStatus().equals("Available")) {
            b.setStatus("Issued");
            bookDAO.updateBook(b);
            System.out.println("Issued!");
        } else {
            System.out.println("Not Available!");
        }
    }

    public void returnBook(int bookId) {
        Book b = bookDAO.findBook(bookId);
        if (b != null && b.getStatus().equals("Issued")) {
            b.setStatus("Available");
            bookDAO.updateBook(b);
            System.out.println("Returned!");
        }
    }

    public void viewAvailableBooks() {
        List<Book> list = bookDAO.getAllBooks();
        list.stream()
                .filter(b -> b.getStatus().equals("Available"))
                .forEach(b -> System.out.println(b.getBookName()));
    }

    public void searchBook(int id) {
        Book b = bookDAO.findBook(id);
        if (b != null)
            System.out.println(b.getBookName() + " " + b.getStatus());
        else
            System.out.println("Not Found!");
    }
}