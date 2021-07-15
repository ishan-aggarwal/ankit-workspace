package com.microsoft.microsoftgraphapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ms-api")
public class MicrosoftGraphQueryController {

    @Autowired
    private MicrosoftGraphQueryService service;

    @PostMapping
    public ResponseEntity getData(@RequestBody List<Input> inputList) {
        String data = service.getData(inputList);
        return new ResponseEntity(data, HttpStatus.OK);
    }

}
