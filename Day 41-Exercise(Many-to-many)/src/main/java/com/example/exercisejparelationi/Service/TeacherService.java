package com.example.exercisejparelationi.Service;

import com.example.exercisejparelationi.API.APIException;
import com.example.exercisejparelationi.Model.Teacher;
import com.example.exercisejparelationi.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        if (teacherRepository.findAll().isEmpty()) {
            throw new APIException("no data found for Teacher");
        }
        return teacherRepository.findAll();
    }

    public void addNewTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer id){
        if (teacherRepository.findTeacherById(id)==null){
            throw new APIException("teacher not found by this id");
        }else {
            teacherRepository.deleteById(id);
        }
    }

    public void updateTeacher(Teacher teacher,Integer id){
        Teacher updatedTeacher = teacherRepository.findTeacherById(id);
        if (updatedTeacher!=null){
            updatedTeacher.setName(teacher.getName());
            updatedTeacher.setEmail(teacher.getEmail());
            updatedTeacher.setAge(teacher.getAge());
            updatedTeacher.setSalary(teacher.getSalary());
            teacherRepository.save(updatedTeacher);
        }else {
            throw new APIException("teacher not found by this id");
        }
    }

    public Teacher getTeacherById(Integer id) {
        if (teacherRepository.findTeacherById(id)==null){
            throw new APIException("teacher not found by this id");
        }
        return teacherRepository.findTeacherById(id);
    }
}
