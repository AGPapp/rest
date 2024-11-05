package TestRest.testrest.config;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SpringDocConfig {
    @Bean
   public GroupedOpenApi apV1(){
        return GroupedOpenApi.builder()
                .group("v1")
                .pathsToMatch("/v1/**")
                .packagesToScan("TestRest.testrest.rest.v1")
                .build();


    }
    @Bean
    public GroupedOpenApi apV2(){
        return GroupedOpenApi.builder()
                .group("v2")
                .pathsToMatch("/v2/**")
                .packagesToScan("TestRest.testrest.rest.v2")
                .build();


    }
}
