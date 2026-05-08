package com.proyectotienda.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection conectar() throws SQLException {
        String url = "postgresql://ep-orange-feather-apv32610-pooler.c-7.us-east-1.aws.neon.tech/neondb?sslmode=require&channel_binding=require";
        String user = "neondb_owner";
        String password = "npg_0qFki9urvSbs";

        return DriverManager.getConnection(url, user, password);
    }

}
