package com.example.sharedata.controllers;


import static com.example.sharedata.contants.Constants.CONTROLLER_DATA;
import static com.example.sharedata.contants.Constants.CONTROLLER_KEY;
import static com.example.sharedata.contants.Constants.SERVICE_KEY;

import com.example.sharedata.services.ExampleService;
import com.example.sharedata.singleton.DataHolder;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ExampleController {

    private final ExampleService exampleService;


    @Autowired
    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/thread-context")
    public ResponseEntity<String> threadContext() {
        System.out.println(ThreadContext.get(CONTROLLER_KEY));

        ThreadContext.put(CONTROLLER_KEY, CONTROLLER_DATA);
        System.out.println(ThreadContext.get(SERVICE_KEY));

        String result = exampleService.threadContext();

        System.out.println(ThreadContext.get(SERVICE_KEY));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/singleton/data-holder")
    public ResponseEntity<String> singletonDataHolder() {
        System.out.println(DataHolder.getInstance().get(CONTROLLER_KEY));
        DataHolder.getInstance().put(CONTROLLER_KEY, CONTROLLER_DATA);

        String result = exampleService.SingletonDataHolder();
        System.out.println(DataHolder.getInstance().get(SERVICE_KEY));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/example")
    public ResponseEntity<String> example() {

        String result = exampleService.example();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
