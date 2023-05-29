package example.controller;

import example.entity.CommonResult;
import example.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ProviderController {

    @GetMapping("/get")
    public String get(){
        return "11000这是一个get方法";
    }

    @PostMapping("/post")
    public String post(){
        return "这是一个post方法";
    }

    @PutMapping("/put")
    public void put(){
        System.out.println("这是一个put方法");
    }

    @DeleteMapping("/delete")
    public void delete(){
        System.out.println("这是一个delete方法");
    }
}
