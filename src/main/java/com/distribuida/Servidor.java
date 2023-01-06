package com.distribuida;

import java.sql.Connection;
import com.distribuida.util.ConnectionUtil;
import java.sql.SQLException;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) {io.helidon.microprofile.cdi.Main.main(args);

        ConnectionUtil db = new ConnectionUtil();
        Connection conn = db.connect_to_db("books", "postgres", "80467391");
        //db.createTable(conn, "public.books");

    }
}
