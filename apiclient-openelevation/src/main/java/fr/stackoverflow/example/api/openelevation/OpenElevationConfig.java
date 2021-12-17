package fr.stackoverflow.example.api.openelevation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//This class is only used by appTest and is not needed to run the application
@Configuration // in https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#spring-core, I see @ComponentScan ONLY in combination with @Configuration ...it is "valid java" without, but i am not sure what it is doing here (if at all)
@ComponentScan
@ImportAutoConfiguration(RestTemplateAutoConfiguration.class)

public class OpenElevationConfig {
    @Bean
    protected static RestTemplate createRestTemplateClient(@Autowired RestTemplateBuilder restBuilder ) {
        return restBuilder.build();
    }
}
