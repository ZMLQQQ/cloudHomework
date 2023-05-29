package com.example.Controller;

import com.example.Feign.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feign")
public class feignService {
    @Autowired
    UserFeignService userFeignService;

    @GetMapping("/get")
    public String get() {
        String message = userFeignService.get();
        return "provider:" + message;
    }

    @PostMapping("/post")
    public String post(){
        String message = userFeignService.post();
        return "provider" + message;
    }

    @PutMapping("/put")
    public void put(){
        userFeignService.put();
    }

    @DeleteMapping("/delete")
    public void delete(){
        userFeignService.delete();
    }
}
