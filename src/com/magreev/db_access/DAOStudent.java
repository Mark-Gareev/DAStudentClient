package com.magreev.db_access;

import com.magreev.db_entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class DAOStudent {
    private ConnectionPool pool;
    private Connection connection;

    public ResultSet getAll()throws SQLException{
        connection = pool.getDataConnection();
        String sql = "SELECT*FROM students";
        PreparedStatement stat = getPreparedStatement(sql);
        return stat.executeQuery();

    }
    public void addStudent(Student student)throws SQLException {
        connection = pool.getDataConnection();
        String sql = "INSERT students(name,lastname,fathersname,studgroup,birthdate,id)VALUES(?,?,?,?,?,?)";
        PreparedStatement stat = getPreparedStatement(sql);
        stat.setString(1,student.getName());
        stat.setString(2,student.getLastName());
        stat.setString(3,student.getFatherName());
        stat.setString(4,student.getStudGroup());
        stat.setString(5,student.getBirthDate());
        stat.setInt(6,student.getId());
        stat.execute();
        pool.putConnection(connection);
    }
    public void deleteByID(int ID)throws SQLException{
        connection = pool.getDataConnection();
        String sql = "DELETE FROM students WHERE id =?;";
        PreparedStatement stat = getPreparedStatement(sql);
        stat.setInt(1,ID);
        stat.execute();
        pool.putConnection(connection);
    }
    public DAOStudent()
    {
        this.pool = new ConnectionPool();
    }
    private PreparedStatement getPreparedStatement(String sql) throws SQLException
    {
        PreparedStatement statement;
        statement = connection.prepareStatement(sql);
        return statement;
    }
    public ResultSet getIDSet()throws SQLException{
        connection = pool.getDataConnection();
        String sql = "SELECT id FROM students";
        PreparedStatement stat = getPreparedStatement(sql);
        //pool.putConnection(connection);
        return stat.executeQuery();
    }

}
