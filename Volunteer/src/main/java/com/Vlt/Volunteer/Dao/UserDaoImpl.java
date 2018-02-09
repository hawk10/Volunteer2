package com.Vlt.Volunteer.Dao;

import com.Vlt.Volunteer.Entity.Person;
import com.Vlt.Volunteer.Utilities;
import org.hibernate.sql.CaseFragment;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.sql.Date;
import java.text.Format;
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
        ParameterExpression paramDB = Utilities.generateParameterExpression(builder, type);

        Predicate predicate = builder.equal(from.get(param), paramDB);



//        criteriaQuery.where(builder.equal(from.get(param),paramDB));
        criteriaQuery.where(predicate);
        if(type.equals("Date")) {
            value = (T) Date.valueOf(value.toString());
        }
        TypedQuery<Person> query = entityManager.createQuery(criteriaQuery);

        query.setParameter(paramDB,value);
        List<Person> resultList = query.getResultList();

        return resultList;
    }


}
