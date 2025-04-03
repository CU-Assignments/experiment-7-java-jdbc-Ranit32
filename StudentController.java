package controller;

import model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private Connection connection;

    public StudentController(Connection connection) {
        this.connection = connection;
    }

    public void createStudent(Student student) throws SQLException {
        String query = "INSERT INTO Student (StudentID, Name, Department, Marks) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, student.getStudentID());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getDepartment());
            stmt.setDouble(4, student.getMarks());
            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        }
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM Student";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Student student = new Student();
                student.setStudentID(rs.getInt("StudentID"));
                student.setName(rs.getString("Name"));
                student.setDepartment(rs.getString("Department"));
                student.setMarks(rs.getDouble("Marks"));
                students.add(student);
            }
        }
        return students;
    }

    public void updateStudent(Student student) throws SQLException {
        String query = "UPDATE Student SET Name = ?, Department = ?, Marks = ? WHERE StudentID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getDepartment());
            stmt.setDouble(3, student.getMarks());
            stmt.setInt(4, student.getStudentID());
            stmt.executeUpdate();
            System.out.println("Student updated successfully!");
        }
    }

    public void deleteStudent(int studentID) throws SQLException {
        String query = "DELETE FROM Student WHERE StudentID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, studentID);
            stmt.executeUpdate();
            System.out.println("Student deleted successfully!");
        }
    }
}
