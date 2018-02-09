package com.Vlt.Volunteer.Controller;

import com.Vlt.Volunteer.Entity.Event;
import com.Vlt.Volunteer.Dto.EventDto;
import com.Vlt.Volunteer.Service.EventService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/v1/event")
public class EventController {


    private static Logger log = LoggerFactory.getLogger(EventController.class);

    private static final String GET_ALL= "/all";


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    EventService eventService;


    @RequestMapping(path = "", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<ResponseEntity> addAddressRequest(@RequestBody EventDto eventDto) {
        return (CompletableFuture.supplyAsync(() -> addEvent(eventDto)));
    }

    @Async
    protected ResponseEntity addEvent(EventDto eventDto) {


        try {
            Event event = new Event();
            modelMapper.map(eventDto,event);
            eventService.addEvent(event);


        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @RequestMapping(path = "", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<ResponseEntity> addAddressRequest(@RequestParam String eventTitle) {
        return (CompletableFuture.supplyAsync(() -> getEvent(eventTitle)));
    }

    @Async
    protected ResponseEntity getEvent(String eventTitle) {

        try {

            List<Event> events = eventService.findbyTitle(eventTitle);
            return new ResponseEntity(events, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
