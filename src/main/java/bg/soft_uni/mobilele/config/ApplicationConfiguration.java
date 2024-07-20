package bg.soft_uni.mobilele.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.Random;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public Random random(){
        return new Random();
    }
    @Bean("offersRestClient")
    public RestClient offersRestClient() {
        return RestClient
                .builder()
                .baseUrl("http://localhost:8081")
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
