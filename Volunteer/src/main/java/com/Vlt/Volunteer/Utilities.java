package com.Vlt.Volunteer;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Utilities {


//    @Bean(name="camel")
    @Bean
    public ModelMapper modelMapperCamel(){
        ModelMapper modelMapper = new ModelMapper();

        org.modelmapper.config.Configuration configuration = modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNameTokenizer(NameTokenizers.CAMEL_CASE)
                .setDestinationNameTokenizer(NameTokenizers.UNDERSCORE);

        return modelMapper;
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
