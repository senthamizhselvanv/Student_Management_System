import java.io.Serializable;
import java.io.Serial;

public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private int age;
    private String course;
    private String homeTown;

    public Student(String id, String name, int age, String course, String homeTown) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.homeTown = homeTown;
    }

    //Getter Methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public String getHomeTown() {
        return homeTown;
    }

    //Setter Methods
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    //ToString
    public String toString() {
        return String.format("ID: %-8s | Name: %-12s | Age: %-12d | Course: %-12s | Home Town: %-12s", id, name, age, course, homeTown);
    }
}
