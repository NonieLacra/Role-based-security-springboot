package com.example.springsecurityactivity.Repository;

import com.example.springsecurityactivity.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
