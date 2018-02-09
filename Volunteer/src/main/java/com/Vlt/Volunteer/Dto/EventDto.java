package com.Vlt.Volunteer.Dto;

import com.Vlt.Volunteer.Entity.Person;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.sql.Date;
import java.util.List;

@Data
@Component
public class EventDto {

    @Id
    private long id;
    private String title;
    private String summary;
    private Date startDate;
    private Date endDate;
    private boolean status;
    private List<Person> people;

}
