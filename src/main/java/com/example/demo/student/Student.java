package com.example.demo.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence",
                       sequenceName = "student_sequence",
                       allocationSize = 1)
    @GeneratedValue(
       generator = "student_sequence",
       strategy = GenerationType.SEQUENCE)

    private Long id;
    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Student(final String name, final String email, final Gender gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
