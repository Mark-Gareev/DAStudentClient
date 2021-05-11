package com.magreev.console_menu;

import java.util.Scanner;

public class Menu {
    EventFromUser event;
    public void run() {
        System.out.println("Student table manager 1.0");
        System.out.println();
        help();
        String command;
        while (true) {
            System.out.println("Enter command : ");
            Scanner scanInput = new Scanner(System.in);
            command = scanInput.nextLine();
            if(command.equals("exit"))
                break;
            switch (command) {
                case ("del"):
                    event = new DeleteStudentByID();
                    break;
                case ("show"):
                    event = new PrintAllStudents();
                    break;
                case ("add"):
                    event = new AddingStudent();
                    break;
                case ("help"):
                    help();
                    event = null;
                    break;
                default:
                    event = null;
            }
            if(event != null) {
                event.happen();
            }
            else {
                System.out.println("Incorrect command");
            }
        }

        //choose event and execute instructions;


    }
    private void help(){
        System.out.println("Type \"show\" to get all students\r\n" +
                "Type \"del\" to delete student by ID\r\n" +
                "Type\"add\" to add new student to DB\r\n" +
                "Type\"help\" to see this message again\r\n" +
                "Type\"exit\" to finish");
    }

}
