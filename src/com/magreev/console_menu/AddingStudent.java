package com.magreev.console_menu;

import com.magreev.db_access.ConnectionPool;
import com.magreev.db_access.DAOStudent;
import com.magreev.db_entities.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AddingStudent extends EventFromUser {
    @Override
    public void happen() {
        Student student = new Student();
        DAOStudent daoStudent = new DAOStudent();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        System.out.println("Let us collect info about student");
        while (!(input.equals("back"))) {
            try {
                System.out.println("Enter student ID : ");
                input = scanner.nextLine();
                if (Validator.validateID(input)) {
                    student.setId(Integer.parseInt(input));
                } else {
                    System.out.println("Incorrect ID. Try again");
                    continue;
                }
                System.out.println("Enter student name : ");
                input = scanner.nextLine();
                if (Validator.validateStringField(input)) {
                    student.setName(input);
                } else {
                    System.out.println("Incorrect string field. Try again");
                    continue;
                }
                System.out.println("Enter student last name : ");
                input = scanner.nextLine();
                if (Validator.validateStringField(input)) {
                    student.setLastName(input);
                } else {
                    System.out.println("Incorrect string field. Try again");
                    continue;
                }
                System.out.println("Enter student fathers name(otchestvo) : ");
                input = scanner.nextLine();
                if (Validator.validateStringField(input)) {
                    student.setFatherName(input);
                } else {
                    System.out.println("Incorrect string field. Try again");
                    continue;
                }
                System.out.println("Enter student group : ");
                input = scanner.nextLine();
                if (Validator.validateStringField(input)) {
                    student.setStudGroup(input);
                } else {
                    System.out.println("Incorrect string field. Try again");
                    continue;
                }
                System.out.println("Enter student birth date in format yyyy.mm.dd : ");
                input = scanner.nextLine();
                if (Validator.validateDate(input)) {
                    student.setBirthDate(input);
                } else {
                    System.out.println("Incorrect date. Try again");
                    continue;
                }
                daoStudent.addStudent(student);
                break;

            } catch (Exception e) {
                e.printStackTrace();
                break;
            }

        }
    }


}
