package com.Vlt.Volunteer.Dto;


import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Component
public class UserDto {

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private char[] gender;
    private String type;
    private boolean status;



}
