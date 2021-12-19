package ru.dima.studySpringMVC.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dima.studySpringMVC.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StudentsDAO {




    private static String URL = "jdbc:postgresql://localhost:5432/studyDB";
    private static String NAME = "postgres";
    private static String PASSWORD = "Poipoilion123";

    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

        public List<Student> getStudentList()  {
            List<Student> studentsList = new ArrayList<>();
            try {
                Statement statement = connection.createStatement();
                String SQL = "SELECT*FROM student";
                ResultSet resultSet =  statement.executeQuery(SQL);

                while (resultSet.next()) {
                    Student student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("name"));
                    student.setGroup(resultSet.getString("student_group"));
                    studentsList.add(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


        return studentsList;
    }


    public Student getStudent(int id){
       /* for (Student student:studentList){
            if (student.getId() == id)
                return student;
        }*/
        return null;
    }
    public void addStudent(Student student){
       /* try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO student VALUES()";
            ResultSet resultSet =  statement.executeUpdate(SQL);
    } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }

    public void editStudent(Student newStudent){
       /* for (Student student: studentList){
            if (newStudent.getId() == student.getId()){
                student.setName(newStudent.getName());
                student.setGroup(newStudent.getGroup());
            }
        }*/
    }

    public void deleteStudent(int id){
       /* studentList.removeIf(p -> p.getId() == id);*/
    }

}

