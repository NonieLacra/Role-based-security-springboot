package com.example.springsecurityactivity.Service.Implementation;

import com.example.springsecurityactivity.Entity.Student;
import com.example.springsecurityactivity.Repository.StudentRepository;
import com.example.springsecurityactivity.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getById(Long studentId) {
        return studentRepository.findById(studentId) ;
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateById(Long studentId, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("Student ID not found ."));
        existingStudent.setFirstName(updatedStudent.getFirstName());
        existingStudent.setLastName(updatedStudent.getLastName());
        existingStudent.setCourse(updatedStudent.getCourse());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setGPA(updatedStudent.getGPA());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteById(Long studentId) {
        studentRepository.deleteById(studentId);

    }
}
