package com.sukri.users.management.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperCongif {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
