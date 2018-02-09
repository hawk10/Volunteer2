package com.Vlt.Volunteer.Controller;

import com.Vlt.Volunteer.Entity.Person;
import com.Vlt.Volunteer.Service.UserService;
import com.Vlt.Volunteer.Dto.UserDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@CrossOrigin("*")
@RestController
@Controller
@RequestMapping("api/v1/user")
public class PersonController {


    private static Logger log = LoggerFactory.getLogger(PersonController.class);

    private static final String GET_ALL= "/all";
    private static final String GET_VIA_NAME= "/name";
    private static final String GET_VIA_PARAM= "/param";


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;


    @RequestMapping(path = GET_VIA_PARAM, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<ResponseEntity> getUserviaParam(@RequestParam String name, @RequestParam String type, @RequestParam Object value  ) {
        return (CompletableFuture.supplyAsync(() -> getUserviaParams(name, type, value)));
    }

    protected ResponseEntity getUserviaParams(String name,String type, Object value) {

        try {



            List<Person> users = userService.getUsersViaParams(name,type,value);
            ResponseEntity responseEntity = new ResponseEntity(users, HttpStatus.OK);
            return responseEntity;

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<ResponseEntity> addAddressRequest(@RequestBody UserDto userDto) {
        return (CompletableFuture.supplyAsync(() -> addUser(userDto)));
    }

    protected ResponseEntity addUser(UserDto userDto) {


        try {
            Person person = new Person();
            modelMapper.map(userDto,person);
            userService.addUser(person);


        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @RequestMapping(path = "", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<ResponseEntity> addAddressRequest(@RequestParam long id) {
        return (CompletableFuture.supplyAsync(() -> getUser(id)));
    }

    protected ResponseEntity getUser(long id) {

        try {

            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = GET_VIA_NAME, method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<ResponseEntity> getUserviaName(@RequestParam String name) {
        return (CompletableFuture.supplyAsync(() -> getUserviaNames(name)));
    }

    protected ResponseEntity getUserviaNames(String name) {

        try {

            List<Person> users = userService.getUsers(name);
            return new ResponseEntity(users, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
