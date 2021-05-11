package com.magreev.console_menu;

import com.magreev.db_access.DAOStudent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Validator {
    public static boolean validateID(String ID) throws SQLException {
        DAOStudent daoStud = new DAOStudent();
        ResultSet set = daoStud.getIDSet();
        boolean result = true;
        try {
            Integer.parseInt(ID);
        } catch (NumberFormatException e) {
            return false;
        }
        int id = Integer.parseInt(ID);
        while (set.next()) {
            if (set.getInt(1) == id) {
                result = false;
                break;
            }

        }
        return result;
    }

    public static boolean validateDate(String date) {

        if ((date.length() != 10)
                || (date.charAt(4) != '.')
                || (date.charAt(7) != '.')) {
            return false;
        }
        for (int i = 0; i < 10; i++) {

            if (!(Character.isDigit(date.charAt(i))) && (date.charAt(i) != '.')) {
                return false;
            }
        }
        if ((Integer.parseInt(date.substring(5, 7)) > 12)
                || (Integer.parseInt(date.substring(8)) > 31)) {
            return false;
        }
        return true;
    }

    public static boolean validateStringField(String field) {
        for (int i = 0; i < field.length(); i++) {
            if ((field.charAt(i) == ';') || (field.charAt(i) == ','))
                return false;
        }
        return true;
    }
}
