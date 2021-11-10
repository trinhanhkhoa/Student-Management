package vn.edu.hcmus.student.sv19127033.lab03;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * vn.edu.hcmus.student.sv19127033.lab03
 * Created by Anh Khoa
 * Date 10/31/2021 - 1:58 PM
 * Description student list
 */
public class Classroom {
    /**
     * Attribute
     */
    private Vector<Student> studentList = new Vector<>();
/*

    */
/**
     * Default constructor
     *//*

    public Classroom() {
        this.studentList = null;
    }

    */
/**
     * Constructor with parameters
     * @param studentList vector student
     *//*

    public Classroom(Vector<Student> studentList) {
        this.studentList = studentList;
    }

    */
/**
     * Copy constructor
     * @param c classroom
     *//*

    public Classroom(Classroom c){
        for(int i = 0; i < c.studentList.size(); i++){
            Student s = new Student(c.studentList.get(i));
            c.studentList.addElement(s);
        }
    }

    */
/**
     * Getter Student List
     * @return student list
     *//*

    public Vector<Student> getStudentList() {
        return studentList;
    }

    */
/**
     * Setter Student List
     * @param list vector student
     *//*

    public void setStudentList(Vector<Student> list) {
        for(int i = 0; i < list.size(); i++){
            Student s = new Student(list.get(i));
            list.add(s);
        }
    }
*/

    /**
     * Print List Of Student
     */
    public void PrintList()
    {
        if(studentList.isEmpty())
        {
            System.out.println("==> List is empty !!!");
            return;
        }
        System.out.println("----- List of Student -----");
        for (Student student : studentList)
            student.output();
    }

    /**
     * Add a new student to list, if the new student was availale then return
     */
    public void addStudent(){
        Student student = new Student();
        student.input();
        studentList.add(student);
        System.out.println("==> Add a student successful !!!");
        System.out.println(student);
    }

    /**
     * Remove a student, if the student was not in the class then return
     */
    public void removeStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("=> Enter ID: ");
        String ID = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getId().equals(ID)) {
                studentList.remove(student);
                break;
            }
        }
    }

    /**
     * Update information for a student
     */
    public void updateStudent() {
        System.out.println("---- Update information of student ----");
        Scanner scan = new Scanner(System.in);
        int i = -1;
        System.out.print("=> Enter ID Student: ");
        String ID = scan.nextLine();
        for (Student student : studentList) {
            if (student.getId().equals(ID)) {
                i++;
                break;
            }
        }
        if (i == -1) {
            System.out.println("==> Can not find student");
            return;
        }

        int choose = -1;
        while (choose != 0) {
            System.out.println("---CHOOSE---");
            System.out.println("1. Name");
            System.out.println("2. GPA");
            System.out.println("3. Image Link");
            System.out.println("4. Address");
            System.out.println("5. Notes");
            System.out.println("0. Back");
            System.out.print("=> Enter your choice: ");
            choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scan.nextLine();
                    studentList.get(i).setName(name);
                    break;
                case 2:
                    System.out.print("Enter GPA: ");
                    Double GPA = Double.parseDouble(scan.nextLine());
                    studentList.get(i).setGpa(GPA);
                    break;
                case 3:
                    System.out.print("Enter Image: ");
                    String Image = scan.nextLine();
                    studentList.get(i).setImage(Image);
                    break;
                case 4:
                    System.out.print("Enter address: ");
                    String address = scan.nextLine();
                    studentList.get(i).setAddress(address);
                    break;
                case 5:
                    System.out.print("Enter notes: ");
                    String notes = scan.nextLine();
                    studentList.get(i).setNotes(notes);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("-> Choose Again !");
                    break;
            }
        }
    }

    /**
     * Swap student in list
     * @param a student a
     * @param b studen b
     */
    public void swap(Student a, Student b){
        Student temp = new Student(a);

        a.setId(b.getId());
        a.setName(b.getName());
        a.setGpa(b.getGpa());
        a.setImage(b.getImage());
        a.setAddress(b.getAddress());
        a.setNotes(b.getNotes());

        b.setId(temp.getId());
        b.setName(temp.getName());
        b.setGpa(temp.getGpa());
        b.setImage(temp.getImage());
        b.setAddress(temp.getAddress());
        b.setNotes(temp.getNotes());
    }

    /**
     * Sort GPA list of student in ascending order
     */
    void sortGpaAscending(){
        System.out.println("---- Sort list of gpa's student in ascending order ----");
        for(int i = 0; i < this.studentList.size() - 1; i++){
            for(int j = i + 1; j < this.studentList.size(); j++){
                if(this.studentList.get(i).getGpa() < this.studentList.get(j).getGpa())
                    this.swap(this.studentList.get(i), this.studentList.get(j));
            }
        }
    }

    /**
     * Sort ID list of student in ascending order
     */
    public void sortIdAscending(){
        System.out.println("---- Sort list of id student in ascending order ----");
        for(int i = 0; i < this.studentList.size() - 1; i++){
            for(int j = i + 1; j < this.studentList.size(); j++){
                if(Integer.parseInt(String.valueOf(this.studentList.get(i).getId())) > Integer.parseInt(String.valueOf(this.studentList.get(j).getId())))
                    this.swap(this.studentList.get(i), this.studentList.get(j));
            }
        }
    }

    /**
     * Save list into text file
     * @throws IOException
     */
    public void saveListIntoTxt() throws IOException {
        FileWriter fw;
        try
        {
            fw = new FileWriter("output.txt");
        }
        catch(IOException exc)
        {
            System.out.println("Error opening file");
            return ;
        }

        System.out.println("Writting to file");
        Scanner scan = new Scanner (System.in);
        for (int i = 0; i <= studentList.size() - 1; i++)
        {
            String name = studentList.get(i).getName();
            String id = studentList.get(i).getId();
            Double gpa = studentList.get(i).getGpa();
            String img = studentList.get(i).getImage();
            String addr = studentList.get(i).getAddress();
            String note = studentList.get(i).getNotes();
            Student student = new Student(id, name, gpa, img, addr, note);
            fw.write(String.valueOf(student )+ "\n");
        }

        fw.close();
        System.out.println("Finished ! Check your file !");
    }

    /**
     * Load list from text file
     * @throws IOException
     */
    public void loadListFromTxt() throws IOException {
        String fileName = "list.txt";
        File f = new File(fileName);
        if (f.exists() && !f.isDirectory()) {
            try (Stream<String> stream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)) {
                stream.forEach(line -> {
                    String[] str = line.split(" - ");
                    if (str.length == 6) {
                        Student newStudent = Student.parseStudent(line);
                        studentList.add(newStudent);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
