import java.io.*;
import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> studentList;
    private final String FILE_NAME = "students.txt";

    public StudentManager() {
        studentList = new ArrayList<>();
        loadFromFile();
    }

    //Create
    public void createStudent(Student student) {
        if (findStudentById(student.getId()) != null) {
            System.out.println("Error student ID exist.");
            return;
        }
        studentList.add(student);
        saveToFile();
        System.out.println("Student added successfully");
    }

    //Read
    public void viewAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("-----------Student Records--------------");
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println("----------------------------------------");
    }

    //Update
    public void updateStudent(String id, String name, int age, String course, String homeTown) {
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found from the given ID");
            return;
        }
        student.setName(name);
        student.setAge(age);
        student.setCourse(course);
        student.setHomeTown(homeTown);
        saveToFile();
        System.out.println("Student updated successfully");
    }

    //Delete
    public void deleteStudent(String id) {
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found from the given ID");
            return;
        }
        studentList.remove(student);
        saveToFile();
        System.out.println("Student deleted successfully");
    }

    //Helper methods
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return; // No file to load yet

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            studentList = (ArrayList<Student>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Error loading data.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data. Creating a clean record list.");
            studentList = new ArrayList<>();
        }
    }

    public Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(studentList);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
