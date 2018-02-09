package com.Vlt.Volunteer.Dao;

import com.Vlt.Volunteer.Entity.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.List;

@Repository
@Component
@Configuration
public class UserDaoImpl<T> implements UserDao<T>  {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addUser(Person person) {
        try {
            entityManager.persist(person);

        }
        catch (Exception e){
            throw e;
        }
        }

    @Override
    public List<Person> getUsersviaName(String name) {


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
        Root<Person> from = criteriaQuery.from(Person.class);

        criteriaQuery.select(from);
        ParameterExpression<String> firstName = builder.parameter(String.class);
        criteriaQuery.where(builder.equal(from.get("first_name"),firstName));
        TypedQuery<Person> query = entityManager.createQuery(criteriaQuery);

        query.setParameter(firstName,name);
        List<Person> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public List<Person> getUsersViaParam(String param, String type, T value) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
        Root<Person> from = criteriaQuery.from(Person.class);
        criteriaQuery.select(from);
//        ParameterExpression<String> paramDB = builder.parameter(String.class);
        ParameterExpression paramDB = generateParameterExpression(builder, type);
        System.out.println(value.getClass());
        criteriaQuery.where(builder.equal(from.get(param),paramDB));
        if(type.equals("Date")) {
            value = (T) Date.valueOf(value.toString());
        }
        TypedQuery<Person> query = entityManager.createQuery(criteriaQuery);

        query.setParameter(paramDB,value);
        List<Person> resultList = query.getResultList();

        return resultList;
    }

    public ParameterExpression generateParameterExpression( CriteriaBuilder builder, String type) {

            if(type.equals("String")) {
                ParameterExpression<String> paramDB = builder.parameter(String.class);
                return paramDB;
            }
        else if(type.equals("Integer")) {
            ParameterExpression<Integer> paramDB = builder.parameter(Integer.class);
            return paramDB;
        }
            else if(type.equals("Date")) {
            ParameterExpression<Date> paramDB = builder.parameter(Date.class);
            return paramDB;
        }

        else {
                return null;
            }
    }
}
