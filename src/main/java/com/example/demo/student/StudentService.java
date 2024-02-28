package com.example.demo.student;

import com.example.demo.student.exception.BadRequestException;
import com.example.demo.student.exception.StudentNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudentService {

   private final StudentRepository studentRepository;

   public List<Student> getAllStudents() {
      return studentRepository.findAll();
   }

   public void addStudent(Student student) {
      boolean existsEmail = studentRepository.selectExistsEmail(student.getEmail());
      if (existsEmail) {
         throw new BadRequestException("Email " + student.getEmail() + " taken");
      }
      studentRepository.save(student);
   }

   public void deleteStudent(Long studentId) {
      if (!studentRepository.existsById(studentId)) {
         throw new StudentNotFoundException("Student with ID " + studentId + "does not exist");
      }
      studentRepository.deleteById(studentId);
   }
}
