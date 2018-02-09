package com.Vlt.Volunteer;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.ParameterExpression;
import java.sql.Date;

@Configuration
public class Utilities {

    public static String ConvertStringCameltoUnder(String value) {

        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";
        return value.replaceAll(regex, replacement)
                .toLowerCase();
    }

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        org.modelmapper.config.Configuration configuration = modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNameTokenizer(NameTokenizers.CAMEL_CASE)
                .setDestinationNameTokenizer(NameTokenizers.UNDERSCORE);

        return modelMapper;
    }

    public static ParameterExpression generateParameterExpression(CriteriaBuilder builder, String type) {

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
//
//    @Bean(name="under")
//    public ModelMapper modelMapperUnder(){
//        ModelMapper modelMapper = new ModelMapper();
//
//        org.modelmapper.config.Configuration configuration = modelMapper.getConfiguration()
//                .setFieldMatchingEnabled(true)
//                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
//                .setSourceNameTokenizer(NameTokenizers.UNDERSCORE)
//                .setDestinationNameTokenizer(NameTokenizers.CAMEL_CASE);
//
//        return modelMapper;
//    }
}
