package com.Vlt.Volunteer.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name="event")
public class Event implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
//    @SequenceGenerator(name = "sequenceGeneratorEvent")
    private long id;
    @Column
    private String title;
    @Column
    private String summary;
    @Column
    private Date start_date;
    @Column
    private Date end_date;
    @Column
    private boolean status;

    @ManyToMany
    @JoinTable(name ="event_user",
            joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<Person> people;



}
