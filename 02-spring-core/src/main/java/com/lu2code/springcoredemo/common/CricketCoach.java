package com.lu2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    //define out init method
//    @PostConstruct
//    public void doStartupStuff() {
//        System.out.println("In doStartupStuff: " + getClass().getSimpleName());
//    }

    //define our destroy method
//    @PreDestroy
//    public void doShutdownStuff() {
//        System.out.println("In doShutdownStuff: " + getClass().getSimpleName());
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes ...";
    }
}
