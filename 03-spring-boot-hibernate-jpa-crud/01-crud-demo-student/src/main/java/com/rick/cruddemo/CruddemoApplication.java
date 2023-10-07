package com.rick.cruddemo;

import com.rick.cruddemo.dao.StudentDAO;
import com.rick.cruddemo.entity.Student;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(CruddemoApplication.class, args);
  }

  // Inject StudentDAO
  @Bean
  public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
    return runner -> {
      //createStudent(studentDAO);
      //createMultipleStudents(studentDAO);
      //readStudent(studentDAO);
      //queryAllStudent(studentDAO);
      //   queryStudentByLastName(studentDAO);
      //   updateStudent(studentDAO);
      //removeStudent(studentDAO);
      removeAllStudent(studentDAO);
    };
  }

  private void removeAllStudent(StudentDAO studentDAO) {
    Integer numRows = studentDAO.deleteAll();
    System.out.format("Deleted %d rows...", numRows);
  }

  private void removeStudent(StudentDAO studentDAO) {
    Integer id = 3;
    System.out.println("Deleting student with id: " + id);
    studentDAO.delete(id);
  }

  private void updateStudent(StudentDAO studentDAO) {
    // retrive student by id
    int studentid = 1;

    System.out.println("Getting studint with id: " + studentid);
    Student tempStudent = studentDAO.findById(studentid);
    // change first name to "Scooby"
    String newFirstName = "Scooby";
    System.out.println("Changing student firstName to: " + newFirstName);
    tempStudent.setFirstName(newFirstName);
    // update student
    System.out.println("Updating to database...");
    studentDAO.update(tempStudent);
    // display the updated student
    System.out.println("Updated Student: " + tempStudent);
  }

  private void queryStudentByLastName(StudentDAO studentDAO) {
    System.out.println("Reading student objects by lastName ...");
    List<Student> students = studentDAO.findByLastName("Tran");
    for (Student student : students) {
      System.out.println(student);
    }
  }

  private void queryAllStudent(StudentDAO studentDAO) {
    System.out.println("Reading all student objects ...");
    List<Student> students = studentDAO.findAll();
    for (Student student : students) {
      System.out.println(student);
    }
  }

  private void readStudent(StudentDAO studentDAO) {
    // create student object
    System.out.println("Creating new student object ...");
    Student tempStudent = new Student("Micha", "Ho", "MicahHo@gmail.com");
    // save the student
    System.out.println("Saving the student ...");
    studentDAO.save(tempStudent);
    // display id of the saved student
    System.out.println("Saved student. Generated id: " + tempStudent.getId());
    // retrieve student based on the id: primary key
    Student reaStudent = studentDAO.findById(tempStudent.getId());
    // display student
    System.out.println(reaStudent);
  }

  private void createMultipleStudents(StudentDAO studentDAO) {
    System.out.println("Creating 3 student objects ...");
    Student tempStudent1 = new Student("Rick1", "Tran", "RickHo1@gmail.com");
    Student tempStudent2 = new Student("Rick2", "Tran", "RickHo2@gmail.com");
    Student tempStudent3 = new Student("Rick3", "Tran", "RickHo3@gmail.com");

    System.out.println("Saving 3 students ...");
    studentDAO.save(tempStudent1);
    studentDAO.save(tempStudent2);
    studentDAO.save(tempStudent3);

    System.out.println("Saved student. Generated id: " + tempStudent1.getId());
    System.out.println("Saved student. Generated id: " + tempStudent2.getId());
    System.out.println("Saved student. Generated id: " + tempStudent3.getId());
  }

  private void createStudent(StudentDAO studentDAO) {
    // create the student object
    System.out.println("Creating new student object ...");
    Student tempStudent = new Student("Rick", "Ho", "RickHo0104@gmail.com");
    // save the student object
    System.out.println("Saving the student ...");
    studentDAO.save(tempStudent);
    // display if of the saved student
    System.out.println("Saved student. Generated id: " + tempStudent.getId());
  }
}
