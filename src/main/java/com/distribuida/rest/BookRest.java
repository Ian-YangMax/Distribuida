package com.distribuida.rest;

import com.distribuida.config.DbConfig;
import com.distribuida.db.Book;
import com.distribuida.servicios.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Collections;
import java.util.List;

import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("/books")
public class BookRest {
    @Inject
    private BookService bookService;

    @Inject
    private DbConfig dbConfig;

    /**
     * GET      /books/{id}     buscar 1
     * GET      /books          listar todos
     * POST     /books          insertar
     * PUT/PACH /books/{id}     actualizar
     * DELETE   /books/{id}     eliminar
     */

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book findById(@PathParam("id") Integer id) {
        dbConfig.test();
        return bookService.findById(id);
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertar(Book p){
        bookService.create(p);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> findAll() {
        return Collections.emptyList();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Book book) {
        bookService.insert(book);
    }

    @PUT()
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Book p,@PathParam("id") Integer id){
        bookService.update(p,id);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Integer id) {
        bookService.delete(id);
    }

}
