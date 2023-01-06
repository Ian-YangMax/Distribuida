package com.distribuida.config;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ApplicationScoped
public class DbConfig {
    //Opcion 2 ENV
    @Inject
    @ConfigProperty(name = "db.user")
    String dbUser;
    @Inject
    @ConfigProperty(name = "db.password")
    String dbPassword;
    @Inject
    @ConfigProperty(name = "db.url")
    String dbUrl;

    @PostConstruct
    public void init(){
        System.out.println("*******************post construct");

        //Opcion 1 API
//        Config config = ConfigProvider.getConfig();
//
//        String user = config.getValue("db.user", String.class);
//        String passwd = config.getValue("db.password", String.class);
//        String url = config.getValue("db.url", String.class);
//
//        System.out.println("op1: user: " + user);
//        System.out.println("op1: pwd: " + passwd);
//        System.out.println("op1: url: " + url);

        //Opcion 2 ENV
        System.out.println("op2: user: " + dbUser);
        System.out.println("op2: pwd: " + dbPassword);
        System.out.println("op2: url: " + dbUrl);

    }

    public void test(){

    }

    private static EntityManagerFactory facade=null;
    private static EntityManager em;

    @Produces
    @ApplicationScoped
    public EntityManager createEntityManager(){
        return Persistence.createEntityManagerFactory("BookPersistencia").createEntityManager();
    }
}
