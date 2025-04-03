package view;

import model.Student;
import java.util.List;
import java.util.Scanner;

public class StudentView {
    private Scanner scanner = new Scanner(System.in);

    public int getChoice() {
        System.out.println("\n1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public Student getStudentDetails() {
        System.out.print("Enter StudentID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        Student student = new Student();
        student.setStudentID(studentID);
        student.setName(name);
        student.setDepartment(department);
        student.setMarks(marks);
        return student;
    }

    public void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println("ID: " + student.getStudentID() + ", Name: " + student.getName() +
                               ", Department: " + student.getDepartment() + ", Marks: " + student.getMarks());
        }
    }

    public int getStudentIDToDeleteOrUpdate() {
        System.out.print("Enter StudentID to delete or update: ");
        return scanner.nextInt();
    }
}
