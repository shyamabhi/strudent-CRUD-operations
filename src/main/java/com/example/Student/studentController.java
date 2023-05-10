package com.example.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class studentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/add")
    public String addStudent(@RequestBody Students students){
        studentService.addStudent(students);
        return " Success";
    }

    @GetMapping("/get-student-by-id/{id}")
    public Students getstudent(@PathVariable int id){
        return studentService.getstudent(id);
    }
    @GetMapping("all")
    public List<Students> getAllStudents() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/delete/{id}")
    public String deletestudent(@PathVariable int id){
        studentService.deletestudent(id);
        return "deleted";
    }

    @PutMapping("/update/{id}")
    public Students updateStudent(@PathVariable("id") int id, @RequestBody Students updatedStudent) {
        return studentService.updatestudent(id,updatedStudent);
    }

}
