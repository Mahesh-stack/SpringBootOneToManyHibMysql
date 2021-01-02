package com.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@JsonIgnoreProperties(value = "college")
public class Student {
    @Id
    private int studentId;
    private String studentName;
    private String joiningDate;
    private String studentAddress;
    private double studentNumber;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COLLEGE_PK",nullable = false, updatable = true)//(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private College college;
}
