package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.API.APIException;
import com.example.exercisejparelationi.Model.Course;
import com.example.exercisejparelationi.Model.Student;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repository.CourseRepository;
import com.example.exercisejparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    public List<Course> findAllCourse() {
        if (courseRepository.findAll().isEmpty()) {
            throw new APIException("No courses found in the database");
        }else {
            return courseRepository.findAll();
        }
    }

    public void addNewCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course,Integer id) {
        if (courseRepository.findCourseById(id)==null){
            throw new APIException("Course not found");
        }else {
            Course updateCourse = courseRepository.findCourseById(id);
            updateCourse.setName(course.getName());
            courseRepository.save(updateCourse);
        }
    }
    public void deleteCourse(Integer id) {
        if (courseRepository.findCourseById(id)==null){
            throw new APIException("Course not found");
        }else {
            courseRepository.deleteById(id);
        }
    }

    public String getTeacherNameFormClass(Integer id) {
        if (courseRepository.findCourseById(id)==null){
            throw new APIException("no Teacher found in this course");
        }else {
            Course course = courseRepository.findCourseById(id);
            Teacher teacher = teacherRepository.findTeacherById(course.getTeacher().getId());
            return teacher.getName();
        }
    }

    public void assignTeacherToCourse(Integer teacherId, Integer courseId) {
        Course course = courseRepository.findCourseById(courseId);
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if (course==null||teacher==null){
            throw new APIException("can not assign teacher to course");
        }else {
            course.setTeacher(teacher);
            courseRepository.save(course);
        }
    }

    public Set<Student> getAllStudentById(Integer id) {
        if (courseRepository.findCourseById(id)==null){
            throw new APIException("no Student found in this course");
        }else {
            Course course = courseRepository.findCourseById(id);
            return course.getStudents();
        }
    }


}
