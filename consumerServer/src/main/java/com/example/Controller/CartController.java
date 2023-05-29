package com.example.Controller;
import example.Entity.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get")
    public String get(){
        String message = restTemplate.getForObject("http://localhost:11000/user/get",String.class);
        return "provider:" + message;
    }

    @DeleteMapping("/delete")
    public void delete(){
        restTemplate.delete("http://localhost:11000/user/delete",String.class);
    }

    @PutMapping("/put")
    public void put(){
        restTemplate.put("http://localhost:11000/user/put",null,String.class);
    }

    @PostMapping("/post")
    public String post(){
        String message = restTemplate.postForObject("http://localhost:11000/user/post",null,String.class);
        return "provider:" + message;
    }

}
