package com.example.jpastart;

import com.example.jpastart.model.Student;
import com.example.jpastart.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaStartApplicationTests {

    @Autowired
    StudentRepository studentRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void testStudent() {
        Student s1 = new Student();
        s1.setBorn(LocalDate.now());
        s1.setName("Bobz");
        studentRepository.save(s1);

        List<Student> lst = studentRepository.findAll();

        assertEquals(3, lst.size());

        studentRepository.delete(s1);
        lst = studentRepository.findAll();
        assertEquals(2, lst.size());

        Optional<Student> s3 = studentRepository.findById(1);
        if (s3.isPresent()) {
            Student ss3 = s3.get();
            assertEquals(ss3.getName(), "Bobz");
        }


    }

}
