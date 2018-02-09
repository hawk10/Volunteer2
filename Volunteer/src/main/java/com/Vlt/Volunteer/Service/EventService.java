package com.Vlt.Volunteer.Service;

import com.Vlt.Volunteer.Entity.Event;
import com.Vlt.Volunteer.Dao.EventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class EventService {


    @Autowired
    EventDao eventDao;

    public void addEvent(Event event) throws Exception{
        eventDao.save(event);
    }

    public void findAll() throws Exception{
        eventDao.findAll();

    }

    public List<Event> findbyTitle(String eventTitle) throws Exception{
        return eventDao.findAllByTitle(eventTitle);


    }

}
