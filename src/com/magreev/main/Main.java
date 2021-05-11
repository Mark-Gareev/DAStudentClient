package com.magreev.main;

import com.magreev.console_menu.AddingStudent;
import com.magreev.console_menu.Menu;
import com.magreev.db_access.ConnectionPool;
import com.magreev.db_access.DAOStudent;
import com.magreev.db_entities.Student;

import java.sql.Connection;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Menu menu = new Menu();
        menu.run();


    }
}
