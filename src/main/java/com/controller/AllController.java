package com.controller;

import com.entity.College;
import com.entity.Student;
import com.impl.CollegeDao;
import com.impl.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AllController {

    @Autowired
    private CollegeDao collegeDao;

    @Autowired
    private StudentDao studentDao;

    @PostMapping("/addCollege")
    public College addCollege(@RequestBody College college) {
       return collegeDao.addCollege(college);
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentDao.addStudent(student);
    }
    //2)Get list of students
    @GetMapping("/getListOfStudent")
    public List<Student> getListStudents() {
        return studentDao.getListStudents();
    }

    @GetMapping("/getStudentListByCollegeIdAndJoiningDate/{collegeId}/{joiningDate}")
    public List<Student> getStudentListByCollegeId(@PathVariable int collegeId, @PathVariable String joiningDate) {
        return studentDao.getStudentListByCollegeIdAndJoiningDate(collegeId,joiningDate);
    }


    @PutMapping("/updateCollegeForStudentId/{studentId}")
    public String updateCollegeForStudentId(@PathVariable int studentId, @RequestBody College college) throws Exception {
        studentDao.updateCollegeForStudentId(studentId, college);
        return "Updated Successfully";
    }




    @GetMapping("/collegeDetailsOfParticularStudent/{id}")
    public List<College> collegeDetailsOfParticularStudent(@PathVariable int id) {
        return collegeDao.collegeDetailsOfParticularStudent(id);
    }
}
