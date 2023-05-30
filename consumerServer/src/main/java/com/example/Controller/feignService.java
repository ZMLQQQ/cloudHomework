package com.example.Controller;

import com.example.Feign.UserFeignService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
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
    public String put(){
        return "provider:" + userFeignService.put();
    }

    @DeleteMapping("/delete")
    @RateLimiter(name = "A", fallbackMethod = "deleteFallback")
    public String delete(){
        return "provider:" + userFeignService.delete();
    }

    public String deleteFallback(Exception e) {
        System.out.println("deleteFallBack");
        return "业务繁忙!";
    }
}
