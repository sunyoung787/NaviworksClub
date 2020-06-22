package com.sw300.acme.clazz;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sw300.acme.course.Course;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ClazzStatus status;
    private double evaluationRate;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private Course course;

    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL)
    private List<ClassDay> classDayList;

    public Clazz() {
    }

    public Clazz(ClazzStatus status, double evaluationRate) {
        this.status = status;
        this.evaluationRate = evaluationRate;
    }
}
