import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n-----Student Management System--------");
            System.out.println("1. Create student");
            System.out.println("2. View all students");
            System.out.println("3. Update student");
            System.out.println("4. Find student by ID");
            System.out.println("5. Delete student");
            System.out.println("6. Exit");
            System.out.println("Enter your choice (1-6): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 6.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID: ");
                    String id = scanner.nextLine();

                    System.out.println("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter student age: ");
                    int age = scanner.nextInt();
                    if (age < 0) {
                        System.out.println("Age shouldn't be negative");
                        System.out.println("Enter student age: ");
                        age = scanner.nextInt();
                    }

                    scanner.nextLine();

                    System.out.println("Enter student course: ");
                    String course = scanner.nextLine();

                    System.out.println("Enter student home town: ");
                    String homeTown = scanner.nextLine();

                    studentManager.createStudent(new Student(id, name, age, course, homeTown));
                    break;

                case 2:
                    studentManager.viewAllStudents();
                    break;

                case 3:
                    System.out.println("Enter student ID: ");
                    String updateId = scanner.nextLine();

                    System.out.println("Enter student name: ");
                    String updateName = scanner.nextLine();

                    System.out.println("Enter student age: ");
                    int updateAge = scanner.nextInt();
                    if (updateAge < 0) {
                        System.out.println("Age shouldn't be negative");
                        System.out.println("Enter student age: ");
                        updateAge = scanner.nextInt();
                    }

                    scanner.nextLine();

                    System.out.println("Enter student course: ");
                    String updateCourse = scanner.nextLine();

                    System.out.println("Enter student home town: ");
                    String updateHomeTown = scanner.nextLine();

                    studentManager.updateStudent(updateId, updateName, updateAge, updateCourse, updateHomeTown);
                    break;

                case 4:
                    System.out.println("Enter student ID to find: ");
                    String searchId = scanner.nextLine();
                    Student found = studentManager.findStudentById(searchId);
                    if (found != null) {
                        System.out.println("\nRecord Found:\n" + found);
                    } else {
                        System.out.println("No records found.");
                    }
                    break;

                case 5:
                    System.out.println("Enter student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    studentManager.deleteStudent(deleteId);
                    break;

                case 6:
                    System.out.println("Exit the system.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid selection, choose between 1 to 6");
                    break;
            }
        }

    }
}