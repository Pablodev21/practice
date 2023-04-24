
/*
package com.example.proyecto.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexion {
    private static HikariConfig config = new HikariConfig();

    private static HikariDataSource ds;

    static {

        config.setJdbcUrl("");
        config.setUsername("");
        config.setPassword("");
        config.addDataSourceProperty("database", "Fisio");
        config.addDataSourceProperty("encrypt","true");
        config.addDataSourceProperty("trustServerCertificate","value");
        config.addDataSourceProperty("loginTimeout","30");
        ds= new HikariDataSource(config);


    }

    public static Connection getConnection() throws SQLException{

        return  ds.getConnection();
    }
}
*/