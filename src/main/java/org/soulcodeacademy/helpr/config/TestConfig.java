package org.soulcodeacademy.helpr.config;

import org.soulcodeacademy.helpr.services.PopulateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private PopulateService populateService;

     @PostConstruct
    public void init() {
       this.populateService.populate();
     }
}
