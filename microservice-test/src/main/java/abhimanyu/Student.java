package abhimanyu;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Student implements Serializable {

    private String name;
    private String regno;
    private String emailId;
    private String address;

    public Student(String name, String regno, String emailId, String address) {
        this.name = name;
        this.regno = regno;
        this.emailId = emailId;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  "name='" + name + '\'' +
                ", regno='" + regno + '\'' +
                ", emailId='" + emailId + '\'' +
                ", address='" + address + '\'';
    }

    public static void main(String[] args) {
        Student s1 = new Student("Abhimanyu","BCE-123", "abhimanyu@gmail.com", "vellore");
        Student s2 = new Student("rajat","CSE-123", "rajat@gmail.com", "bangalore");
        Student s3 = new Student("jatin","BCE-324", "jatin@gmail.com", "vellore");

        Student[] students = new Student[3];
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;

        try {
            //Write Student array to file.
            FileOutputStream fos = new FileOutputStream("student.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();

            //Read Student array from file.
            FileInputStream fis = new FileInputStream("student.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student[] studentsFromSavedFile = (Student[]) ois.readObject();
            ois.close();

            List<Student> studentList = Arrays.stream(studentsFromSavedFile)
                    .filter(student -> student.getRegno().contains("BCE")
                            && student.getAddress().toLowerCase().contains("vellore"))
                    .collect(Collectors.toList());

            if(studentList.isEmpty()) {
                System.out.println("No Such Students Match the Criteria");
            } else {
                System.out.println("Students matching the criteria:");
                studentList.forEach(student ->
                    System.out.println(student.toString())
                );

            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
