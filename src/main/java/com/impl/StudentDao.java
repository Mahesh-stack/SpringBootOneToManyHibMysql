package com.impl;
import com.entity.College;
import com.entity.Student;
import com.repository.CollegeRepository;
import com.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDao {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CollegeRepository collegeRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
    public List<Student> getListStudents() {
        return studentRepository.findAll();
    }

   /* public List<Student> getListOfStudentWithSpecificCollegeId(College college) {
        int id = college.getCollegeId();
        studentRepository.findById(id);
    }*/

    public List<Student> getListOfStudentBasedOnJoiningDate(String joiningDate) {
        return studentRepository.findAllByJoiningDate(joiningDate);
    }

    public List<Student> getStudentListByCollegeId(int collegeId) {
        return studentRepository.findAllByCollegePk(collegeId);
    }

    public List<Student> getStudentListByCollegeIdAndJoiningDate(int collegeId, String joiningDate) {
        return studentRepository.findAllByCollegeIdAndJoiningDate(collegeId, joiningDate);
    }

    public void updateCollegeForStudentId(int studentId, College college) throws Exception {
        Student existingStudent = studentRepository.findById(studentId).orElse(null);
        if (existingStudent == null){
            throw new Exception("Student does not exist");
        }

        existingStudent.setCollege(college);
        //existingStudent.setCollege(college);
        studentRepository.save(existingStudent);
    }
}
