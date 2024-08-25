package com.example.exercisejparelationi.Controller;

import com.example.exercisejparelationi.Model.Course;
import com.example.exercisejparelationi.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cour")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAllCourses() {
        return ResponseEntity.status(200).body(courseService.findAllCourse());
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course) {
        courseService.addNewCourse(course);
        return ResponseEntity.status(200).body("course added successfully");
    }

    @DeleteMapping("/delete/{cId}")
    public ResponseEntity deleteCourse(@PathVariable Integer cId) {
        courseService.deleteCourse(cId);
        return ResponseEntity.status(200).body("course deleted successfully");
    }

    @PutMapping("/update/{cId}")
    public ResponseEntity updateCourse(@PathVariable Integer cId, @Valid @RequestBody Course course) {
        courseService.updateCourse(course,cId);
        return ResponseEntity.status(200).body("course updated successfully");
    }

    @GetMapping("/get/teacher/name/{cid}")
    public ResponseEntity teacherName(@PathVariable Integer cid) {
        return ResponseEntity.status(200).body(courseService.getTeacherNameFormClass(cid));
    }

    @PostMapping("/add/teacher/{tID}/{cID}")
    public ResponseEntity addTeacher(@PathVariable Integer tID, @PathVariable Integer cID) {
        courseService.assignTeacherToCourse(tID,cID);
        return ResponseEntity.status(200).body("teacher added successfully");
    }
}
