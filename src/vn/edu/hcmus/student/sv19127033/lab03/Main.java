package vn.edu.hcmus.student.sv19127033.lab03;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Classroom c = new Classroom();
        int choose = -1;

        while(choose != 0) {
            System.out.println("---- MANAGE STUDENTS ----");
            System.out.println("1. Print list");
            System.out.println("2. Add a new student");
            System.out.println("3. Remove a student");
            System.out.println("4. Update information for a student");
            System.out.println("5. Sort students in list by GPA");
            System.out.println("6. Sort students in list by ID");
            System.out.println("7. Save list into text file");
            System.out.println("8. Load list from text file");
            System.out.println("0. Exit");
            System.out.print("\n ==> Enter your choice: ");
            Scanner scan = new Scanner(System.in);
            choose = scan.nextInt();
            switch (choose) {
                case 1:
                    c.PrintList();
                    break;
                case 2:
                    c.addStudent();
                    break;
                case 3:
                    c.removeStudent();
                    break;
                case 4:
                    c.updateStudent();
                    break;
                case 5:
                    c.sortGpaAscending();
                    break;
                case 6:
                    c.sortIdAscending();
                    break;
                case 7:
                    c.saveListIntoTxt();
                    break;
                case 8:
                    c.loadListFromTxt();
                    break;
                default:
                    break;
            }
        }
    }
}
