package com.ltp.gradesubmission.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="grade", uniqueConstraints={
    @UniqueConstraint(columnNames={"student_id","course_id"})
})
public class Grade {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="score", nullable = false)
    private String score;

    @ManyToOne(optional=false)
    @JoinColumn(name="student_id",referencedColumnName="id")
    private Student student;


    @ManyToOne(optional=false)
    @JoinColumn(name="course_id",referencedColumnName="id")
    private Course course;


    // public Long getId() {
    //     return this.id;
    // }

    // public void setId(Long id) {
    //     this.id = id;
    // }

    // public String getScore() {
    //     return this.score;
    // }

    // public void setScore(String score) {
    //     this.score = score;
    // }

}
