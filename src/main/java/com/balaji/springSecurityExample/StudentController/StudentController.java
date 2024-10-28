package com.balaji.springSecurityExample.StudentController;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return service.getStudents();
    }

    @GetMapping("/csrf")
    public CsrfToken getcsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
        /*
        * To make other sites access the post,put and delete mappings(making changes to server)
        * every time sending csrf token in header along with the request
        * key is "X-CSRF-TOKEN" and value will be your token
        * you will get this token after hitting this request(localhost:8080/csrf) for this application
        * */
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student)
    {
        return service.saveStudent(student);
    }

}
