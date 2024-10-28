package com.balaji.springSecurityExample.StudentController;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService
{

    static List<Student> students = new ArrayList();

    static
    {
         students.addAll(List.of(
                new Student(1,"root1",65),
                new Student(2,"root2",70)
        ));
    }
    public List<Student> getStudents()
    {
        return students;
    }

    public Student saveStudent(Student student)
    {
        students.add(student);
        return students.stream().filter(stud->stud.getId()==student.getId()).findAny().get();
    }

}
