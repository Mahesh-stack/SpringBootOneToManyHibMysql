package com.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class College {
    @Id
    private int collegeId;
    private String collegeName;
    private int collegeCode;
    private String collegeAddress;
    private String collegeMailId;
    @OneToMany(mappedBy = "college", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students;
}
