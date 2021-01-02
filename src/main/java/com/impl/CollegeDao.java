package com.impl;

import com.entity.College;
import com.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeDao {

    @Autowired
    CollegeRepository collegeRepository;

    public College addCollege(College college) {
        return collegeRepository.save(college);
    }

    public List<College> collegeDetailsOfParticularStudent(int studentId) {
        return collegeRepository.findAllByIdParticularStudent(studentId);
    }
}
