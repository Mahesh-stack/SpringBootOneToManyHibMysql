package com.repository;

import com.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findAllByJoiningDate(String joiningDate);

    @Query(value = "SELECT s from Student s where s.college.collegeId = ?1")
    List<Student> findAllByCollegePk(int collegeId);

    @Query(value = "SELECT s from Student s where s.college.collegeId = ?1 and s.joiningDate = ?2")
    List<Student> findAllByCollegeIdAndJoiningDate(int collegeId, String joiningDate);
}
