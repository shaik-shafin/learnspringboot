package com.shaik.acknowledge.filters;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("myfilter1")
    public String filter1(){

        String result = "Filter1 invoked successfully";
        System.out.println(result);
        return result;
    }

    @GetMapping("myfilter2")
    public String filter2(){

        String result = "Filter2 invoked successfully";
        System.out.println(result);

        return result;
    }
}
