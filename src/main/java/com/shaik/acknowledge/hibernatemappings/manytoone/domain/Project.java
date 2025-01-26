package com.shaik.acknowledge.hibernatemappings.manytoone.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.Cache;

import java.util.List;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;

//inverse side because it doesn't hold the foreign key
@Entity
@Table(name = "project")
@Cache(usage = NONSTRICT_READ_WRITE)
//This is annotation is for JsonIdentity in order to avoid infinite parsing by json
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> student;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
