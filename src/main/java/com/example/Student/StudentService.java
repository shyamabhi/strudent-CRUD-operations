package com.example.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Students students) {
        studentRepository.save(students);
    }

    public Students getstudent(int id) {
        return studentRepository.findById(id).get();
    }

    public void deletestudent(int id) {
        studentRepository.deleteById(id);
    }

    public Students updatestudent(int id, Students updatedStudent) {
        Students existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student not found with id: " + id));

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setMarks(updatedStudent.getMarks());

        return studentRepository.save(existingStudent);

    }

    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }
}
