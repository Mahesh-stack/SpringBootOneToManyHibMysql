package com.repository;

import com.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CollegeRepository extends JpaRepository<College,Integer> {

    @Query(value = "select c from College c left join c.students s on s.studentId = ?1")
    List<College> findAllByIdParticularStudent(int student_id);
}
