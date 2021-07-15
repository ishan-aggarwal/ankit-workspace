package com.example.gatling;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("test")
public class Controller {

    @GetMapping
    public ResponseOutput getAll() {
        System.out.println("Get request");
        LocalDateTime dateTime = LocalDateTime.now();

        ResponseOutput output = new ResponseOutput();
        //serieralizer

       // LocalTime localTime = dateTime.toLocalTime().format(DateTimeFormatter.ISO_LOCAL_TIME);
        output.setCreatedDate(dateTime.toLocalDate());
        int a=2;
        int b=3;
        int x[] = new int[a+b];
        //ZonedDateTime todayWithDefaultTimeZone=ZonedDateTime.now();
        LocalTime localTime = dateTime.toLocalTime();
        output.setCreatedTime(localTime);
        output.setMessage("Hi");

        return output;
    }

    @PostMapping
    public Input postCall(@RequestBody Input input) {
        System.out.println("Post request..");
        return input;
    }

}
