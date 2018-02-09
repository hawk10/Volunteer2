package com.Vlt.Volunteer.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name="person")
public class Person implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
//    @SequenceGenerator(name = "sequenceGenerator")
    private long id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private Date date_of_birth;
    @Column
    private char[] gender;
    @Column
    private String type;
    @Column
    private boolean status;

    @ManyToMany(mappedBy = "people")
    private List<Event> event;




}
