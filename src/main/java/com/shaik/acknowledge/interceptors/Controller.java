package com.shaik.acknowledge.interceptors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interceptor")
public class Controller {

    @GetMapping("method1")
    public String invokeInterceptor(){

        return "Method1 invoked successfully";
    }

    @GetMapping("method2")
    public String method2(){

        return "Method2 invoked successfully";
    }

    @GetMapping("method3")
    public String method3(){

        return "Method3 invoked successfully";
    }
}
