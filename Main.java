import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import controller.StudentController;
import model.Student;
import view.StudentView;
import java.util.List;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/db";
    private static final String USER = "root";
    private static final String PASSWORD = "Ranit@321";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            StudentController controller = new StudentController(connection);
            StudentView view = new StudentView();

            while (true) {
                int choice = view.getChoice();
                switch (choice) {
                    case 1:
                        controller.createStudent(view.getStudentDetails());
                        break;
                    case 2:
                        List<Student> students = controller.getAllStudents();
                        view.displayStudents(students);
                        break;
                    case 3:
                        controller.updateStudent(view.getStudentDetails());
                        break;
                    case 4:
                        controller.deleteStudent(view.getStudentIDToDeleteOrUpdate());
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
