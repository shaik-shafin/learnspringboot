package com.shaik.acknowledge.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class Controller {

    @Autowired
    private AopService aopService;

    @Autowired
    private IEmployee permenentEmployee;

    @GetMapping("message")
    public String showMessage(){
        aopService.printMessage();
        return "Method executed successfully";
    }

    @GetMapping("message1")
    public Integer showMessage1(String name, Integer id){
        return 143;
    }

    @GetMapping("message2/{msg}")
    public String showMessage2(@PathVariable String msg){
        return "Method executed successfully : " + msg;
    }

    @GetMapping("message3")
    public String showMessage3(AopHelperClass aopHelperClass){
        aopService.printMessage();
        permenentEmployee.doWork();
        return "Method executed successfully";
    }
}
