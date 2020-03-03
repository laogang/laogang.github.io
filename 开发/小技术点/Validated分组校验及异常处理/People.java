package com.sh.guog.model;


import com.sh.guog.util.ValidatedUtils;

import javax.validation.Valid;
import javax.validation.constraints.Min;

public class People {

    String name;

    @Min(value = 1, groups = {ValidatedUtils.add.class, ValidatedUtils.update.class})
    int age;

    String sex;

    @Valid
    private Boy boy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public Boy getBoy() {
        return boy;
    }

    public void setBoy(Boy boy) {
        this.boy = boy;
    }
}
