package com.magreev.db_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool{
    private String url = "jdbc:mysql://localhost/testtask2?serverTimezone=Europe/Moscow&useSSL=false";
    private String user = "root";
    private String password = "qwerty";

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUrl(String url){
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public Connection getDataConnection()throws SQLException{
            return DriverManager.getConnection(url,user,password);
    }
    public void putConnection(Connection conn)throws SQLException{
        conn.close();
    }
}
