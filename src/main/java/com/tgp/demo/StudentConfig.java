package com.tgp.demo;

import com.tgp.demo.model.Corridor;
import com.tgp.demo.repository.CorridorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
// Use to add corridors
@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(CorridorRepository repository) {
        return args ->  {
            Corridor swukphbt = new Corridor(
                    null,
                    "United Kingdom",
                    "Sterling Pound",
                    "Philippines",
                    "Philippine Peso",
                    "Bank Transfer",
                    "Sendwave",
                    true);
            Corridor wrusphcp = new Corridor(
                    null,
                    "United States",
                    "US Dollar",
                    "Philippines",
                    "Philippine Peso",
                    "Cash Pickup",
                    "WorldRemit",
                    true);
            Corridor wraukemo = new Corridor(
                    null,
                    "Australia",
                    "Australian Dollar",
                    "Kenya",
                    "Kenyan Shilling",
                    "Mobile Money",
                    "WorldRemit",
                    true);

            repository.saveAll(
                    List.of(swukphbt, wrusphcp, wraukemo)
            );


        };
    }
}
