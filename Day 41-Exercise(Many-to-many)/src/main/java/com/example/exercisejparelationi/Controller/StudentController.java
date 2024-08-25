package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.Model.Student;
import com.example.exercisejparelationi.Service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudent(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        studentService.addNewStudent(student);
        return ResponseEntity.status(200).body("student added successfully");
    }

    @DeleteMapping("/delete/{sId}")
    public ResponseEntity deleteStudent(@PathVariable Integer sId){
        studentService.deleteStudent(sId);
        return ResponseEntity.status(200).body("student deleted successfully");
    }

    @PutMapping("/update/{sId}")
    public ResponseEntity updateStudent(@PathVariable Integer sId, @Valid @RequestBody Student student){
        studentService.updateStudent(sId, student);
        return ResponseEntity.status(200).body("student updated successfully");
    }

    @PostMapping("/assign/{studentId}/{courseId}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer studentId, @PathVariable Integer courseId){
        studentService.assignStudentToCourse(studentId, courseId);
        return ResponseEntity.status(200).body("student assigned successfully");
    }

    @PutMapping("/change/major/{sId}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer sId, @PathVariable String major){
        studentService.updateMajor(sId, major);
        return ResponseEntity.status(200).body("student major updated successfully");
    }
}
