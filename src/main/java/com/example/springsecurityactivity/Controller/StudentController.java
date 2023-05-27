package com.example.springsecurityactivity.Controller;

import com.example.springsecurityactivity.Entity.Student;
import com.example.springsecurityactivity.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("student/{studentId}")
    public Optional<Student> getById(@PathVariable Long studentId){
        return studentService.getById(studentId);
    }
    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @PutMapping("/updateStudent/{studentId}")
    public ResponseEntity<Student> updateById(@PathVariable Long studentId, @RequestBody Student updatedStudent){
        Student updated = studentService.updateById(studentId, updatedStudent);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/deleteStudent/{studentId}")
    public void deleteById(@PathVariable Long studentId){
        studentService.deleteById(studentId);
        System.out.print("Student deleted successfully .");
    }
}
