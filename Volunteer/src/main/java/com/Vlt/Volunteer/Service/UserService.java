package com.Vlt.Volunteer.Service;

import com.Vlt.Volunteer.Dao.UserDao;
import com.Vlt.Volunteer.Entity.Person;
import com.Vlt.Volunteer.Dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class UserService<T> {

    @Autowired
    UserDao userDao;


    public void addUser(Person person) throws Exception {

        userDao.addUser(person);

    }

    public List<Person> getUsers(String name) {

        List<Person> usersviaName = userDao.getUsersviaName(name);
        return usersviaName;

    }

    public List<Person> getUsersViaParams(String param,String type, Object value ) {

        List<Person> usersviaName = userDao.getUsersViaParam(param, type, value );

        return usersviaName;

    }
}
