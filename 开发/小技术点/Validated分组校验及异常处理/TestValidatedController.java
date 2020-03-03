package com.sh.guog.controller;

import com.sh.guog.model.People;
import com.sh.guog.util.ValidatedUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestValidatedController {

    @PostMapping("people")
    public String addPeople(@RequestBody @Validated(value = ValidatedUtils.add.class) People people) {
        System.out.println("people = [" + people + "]");
        return "ok";
    }
}
