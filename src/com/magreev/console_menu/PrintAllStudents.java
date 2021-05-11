package com.magreev.console_menu;

import com.magreev.db_access.ConnectionPool;
import com.magreev.db_access.DAOStudent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintAllStudents extends EventFromUser {
    @Override
    public void happen() {
        DAOStudent daoStudent = new DAOStudent();
        try {
            ResultSet result = daoStudent.getAll();
            int col = result.getMetaData().getColumnCount();
            while (result.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(result.getString(i) + " | ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Something wrong,try again");
            e.printStackTrace();
        }

    }
}
