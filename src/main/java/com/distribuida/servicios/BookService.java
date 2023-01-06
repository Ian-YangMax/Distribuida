package com.distribuida.servicios;

import com.distribuida.db.Book;

import java.util.List;

public interface BookService {
    Book findById(Integer id);
    List<Book> findAll();
    void insert (Book book); //lo mismo que el create
    void create(Book p);
    void update (Book p,Integer id);
    void delete (Integer id);
}
