package com.magreev.console_menu;


import com.magreev.db_access.DAOStudent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStudentByID extends EventFromUser {
    @Override
    public void happen() {
        DAOStudent daoStudent = new DAOStudent();
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!(input.equals("back"))) {
            try {
                System.out.println("Enter student ID : ");
                input = scanner.nextLine();
                if (validateIdToDel(input)) {
                    daoStudent.deleteByID(Integer.parseInt(input));
                    System.out.println("Success!");
                    break;
                } else {

                    System.out.println("Student does not exists");
                }

            } catch (Exception e) {
                System.out.println("Something with connection!");
                e.printStackTrace();
                break;
            }
        }
        //scanner.close();
    }

    public static boolean validateIdToDel(String ID) throws SQLException {
        DAOStudent daoStud = new DAOStudent();
        ResultSet set = daoStud.getIDSet();
        boolean result = false;
        try {
            Integer.parseInt(ID);
        } catch (NumberFormatException e) {
            return false;
        }
        int id = Integer.parseInt(ID);
        while (set.next()) {
            if (set.getInt(1) == id) {
                result = true;
                break;
            }

        }
        return result;
    }
}


