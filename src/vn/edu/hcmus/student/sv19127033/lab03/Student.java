package vn.edu.hcmus.student.sv19127033.lab03;

import java.util.Scanner;

/**
 * vn.edu.hcmus.student.sv19127033.lab03
 * Created by trinh
 * Date 10/31/2021 - 1:09 PM
 * Description: ...
 */
public class Student {
    /**
     * Attributes
     */
    private String id;
    private String name;
    private double gpa;
    private String image;
    private String address;
    private String notes;

    /**
     * Default constructor
     */
    public Student(){
        this.id = "";
        this.name = "";
        this.gpa = 0.0;
        this.address = "";
        this.image = "";
        this.notes = "Nothing";
    }

    /**
     * Constructor with parameters
     * @param id string
     * @param name string
     * @param gpa double
     * @param image string
     * @param address string
     * @param notes string
     */
    public Student(String id, String name, Double gpa, String image, String address, String notes){
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.image = image;
        this.address = address;
        this.notes = notes;
    }

    /**
     * Copy constructor
     * @param student student
     */
    public Student(Student student){
        this.id = student.id;
        this.name = student.name;
        this.gpa = student.gpa;
        this.image = student.image;
        this.address = student.address;
        this.notes = student.notes;
    }

    /**
     * Getter id
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Setter id
     * @param id string
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter name
     * @param name string
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter GPA
     * @return GPA
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * Setter GPA
     * @param gpa Double
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * Getter image
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * Setter image
     * @param image string
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Getter address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter address
     * @param address string
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter note
     * @return note
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Setter note
     * @param notes string
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Enter student information
     */
    public void input(){
        Scanner scan = new Scanner (System.in);

        System.out.print("Enter id: ");
        String ID = scan.nextLine();
        setId(ID);

        System.out.print("Enter name: ");
        String Name = scan.nextLine();
        setName(Name);

        System.out.print("Enter gpa: ");
        Double GPA = Double.parseDouble(scan.nextLine());
        setGpa(GPA);

        System.out.print("Enter image link: ");
        String Image = scan.nextLine();
        setImage(Image);

        System.out.print("Enter address: ");
        String Address = scan.nextLine();
        setAddress(Address);

        System.out.print("Enter note: ");
        String Notes = scan.nextLine();
        setNotes(Notes);
    }

    @Override
    public String toString() {

        return this.id + " - " + this.name + " - " + this.gpa + " - " + this.image + " - " + this.address + " - " + this.notes + "\n";
    }

    /**
     * Print student information
     */
    public void output(){
        System.out.println("- ID: " + this.id);
        System.out.println("- Name: " + this.name);
        System.out.println("- GPA: " + this.gpa);
        System.out.println("- Image: " + this.image);
        System.out.println("- Address: " + this.address);
        System.out.println("- Note: " + this.notes);
        System.out.println();
    }

    /**
     * Parse student information
     * @param s string
     * @return sutdent 
     */
    public static Student parseStudent(String s) {
        Student student = new Student();
        String [] str = s.split(" - ");
        student.id = str[0];
        //System.out.println(student.id);
        student.name = str[1];
        //System.out.println(student.name);

        String a = String.valueOf(student.gpa);
        a = str[2];

        //System.out.println(a);
        student.image = str[3];
        //System.out.println(student.image);
        student.address = str[4];
        //System.out.println(student.address);
        student.notes = str[5];
        //System.out.println(student.notes);
        return student;
    }

}
