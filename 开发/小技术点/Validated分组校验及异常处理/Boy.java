package com.sh.guog.model;

import com.sh.guog.util.ValidatedUtils;

import javax.validation.constraints.Pattern;

public class Boy {

    @Pattern(regexp = ".{1,5}", message = "兴趣爱好长度必须为1~5位", groups = {ValidatedUtils.add.class, ValidatedUtils.update.class})
    String hobby;

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
