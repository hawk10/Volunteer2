package com.Vlt.Volunteer.Dao;


import com.Vlt.Volunteer.Entity.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EventDao extends CrudRepository<Event, Long> {

    List<Event> findAllByTitle(String title);

}
