package com.Vlt.Volunteer.Dao;

import com.Vlt.Volunteer.Entity.Person;

import java.util.List;

public interface UserDao<T>  {

        void addUser(Person person);

        List<Person> getUsersviaName(String name);

        List<Person> getUsersViaParam(String param,String type, T value );

}
