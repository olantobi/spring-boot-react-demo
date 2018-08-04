/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.liferon.demo.component;

import com.liferon.demo.model.Event;
import com.liferon.demo.model.Group;
import com.liferon.demo.repository.GroupRepository;
import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author olanrewaju.ebenezer
 */
@Component
public class Initializer implements CommandLineRunner {

    private final GroupRepository groupRepository;
    
    public Initializer(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }
    
    @Override
    public void run(String... args) throws Exception {
        Stream.of("Denver JUG", "Utah JUG", "Seattle JUG",
                "Richmond JUG").forEach(name ->
                groupRepository.save(new Group(name))
        );
 
        Group djug = groupRepository.findByName("Denver JUG");
        
        Event e = Event.builder().title("Full Stack Reactive")
                .description("Reactive with Spring Boot + React")
                .date(Instant.parse("2018-12-12T18:00:00.000Z"))
                .build();
        
        djug.setEvents(Collections.singleton(e));
        groupRepository.save(djug);
 
        groupRepository.findAll().forEach(System.out::println);
    }
    
}
