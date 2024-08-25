package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.API.APIException;
import com.example.exercisejparelationi.Model.Course;
import com.example.exercisejparelationi.Model.Student;
import com.example.exercisejparelationi.Repository.CourseRepository;
import com.example.exercisejparelationi.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public List<Student> getAllStudents() {
        if (studentRepository.findAll().isEmpty()) {
            throw new APIException("No students found in the database");
        }else {
            return studentRepository.findAll();
        }
    }

    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }
    public void deleteStudent(Integer studentId) {
        if (studentRepository.findStudentById(studentId) == null) {
            throw new APIException("Student not found");
        }else {
            studentRepository.deleteById(studentId);
        }
    }

    public void updateStudent(Integer studentId, Student student) {
        if (studentRepository.findStudentById(studentId) == null) {
            throw new APIException("Student not found");
        }else {
            Student updateStudent = studentRepository.findStudentById(studentId);
            updateStudent.setName(student.getName());
            updateStudent.setAge(student.getAge());
            updateStudent.setMajor(student.getMajor());
            studentRepository.save(updateStudent);
        }
    }

    public void assignStudentToCourse(Integer studentId, Integer courseId) {
        Student student=studentRepository.findStudentById(studentId);
        Course course=courseRepository.findCourseById(courseId);
        if (student==null || course==null) {
            throw new APIException("can not assign student to course");
        }else {
            student.getCourses().add(course);
            course.getStudents().add(student);
            studentRepository.save(student);
            courseRepository.save(course);
        }
    }

    public void updateMajor(Integer studentId, String major) {
        Student student=studentRepository.findStudentById(studentId);
        Course course=courseRepository.findCourseById(studentId);
        if (student==null) {
            throw new APIException("Student not found");
        }else {
            student.setMajor(major);
            student.getCourses().clear();
            course.getStudents().clear();
            studentRepository.save(student);
            courseRepository.save(course);
        }
    }
}
