package com.shaik.testing.conditionalonproperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainClass {

    @Autowired(required = false)
    private ConditionalOnProperty_1 conditionalOnProperty_1;


    public MainClass() {
        //System.out.println("*************************** MainClass constructor created ***************************");
    }
}
