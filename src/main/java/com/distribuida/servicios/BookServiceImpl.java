package com.distribuida.servicios;

import com.distribuida.db.Book;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collections;
import java.util.List;

import com.distribuida.config.DbConfig;
import com.distribuida.db.Book;

import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.Entity;


@ApplicationScoped
public class BookServiceImpl implements BookService{

    @Inject
    EntityManager em;

    public Book findById(Integer id){
        Book ret = new Book();

        ret.setId(id);
        ret.setIsbn("isbn" + id);
        ret.setTitle("title " + id);
        ret.setAuthor("author " + id);
        ret.setPrice(id*30.24);
        return ret;
    }

    @Override
    public void create(Book p) {
        EntityManager en=em;
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }


    }


    @Override
    public void insert(Book book) {

    }

    @Override
    public List<Book> findAll() {
        CriteriaQuery<Book> cq= em.getCriteriaBuilder().createQuery(Book.class);
        cq.select(cq.from(Book.class));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public void delete(Integer id) {
        Book p=em.find(Book.class, id);
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }


    @Override
    public void update(Book p,Integer id) {
        EntityManager en=em;
        Book book=em.find(Book.class,id);
        try {
            em.getTransaction().begin();
            book.setIsbn(p.getIsbn());
            book.setTitle(p.getTitle());
            book.setAuthor(p.getAuthor());
            book.setPrice(p.getPrice());
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }


}
