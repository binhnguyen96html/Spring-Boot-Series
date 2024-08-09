package com.lu2code.springcoredemo.rest;

import com.lu2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;
//    private Coach otherCoach;

    @Autowired
    public DemoController(@Qualifier("aquatic") Coach theCoach
//                          @Qualifier("cricketCoach") Coach theOtherCoach
    ){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
//        otherCoach = theOtherCoach;
    }

    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }

//    @GetMapping("/check")
//    public String check() {
//        return "Comparing beans: myCoach == otherCoach: " + (myCoach == otherCoach);
//    }

}
