package dao;


import entity.Book;
import util.JPAUtil;

import javax.persistence.*;
import java.util.List;

public class BookDAO {

    public void addBook(Book book) {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public Book findBook(int id) {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        Book b = em.find(Book.class, id);
        em.close();
        return b;
    }

    public void deleteBook(int id) {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        em.getTransaction().begin();
        Book b = em.find(Book.class, id);
        if (b != null) em.remove(b);
        em.getTransaction().commit();
        em.close();
    }

    public void updateBook(Book book) {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
        em.close();
    }

    public List<Book> getAllBooks() {
        EntityManager em = JPAUtil.getEMF().createEntityManager();
        List<Book> list = em.createQuery("from Book", Book.class).getResultList();
        em.close();
        return list;
    }
}