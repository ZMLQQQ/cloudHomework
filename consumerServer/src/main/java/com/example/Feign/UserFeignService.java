package com.example.Feign;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient("provider-server")
public interface UserFeignService {

    @GetMapping("/user/get")
    @CircuitBreaker(name = "A", fallbackMethod = "getFallback")
    public String get();

    @PostMapping("/user/post")
    @CircuitBreaker(name = "B", fallbackMethod = "postFallback")
    public String post();

    @PutMapping("/user/put")
    @Bulkhead(name = "A", fallbackMethod = "putFallback")
    public String put();

    @DeleteMapping("/user/delete")
    public String delete();

    default String getFallback(Exception e) {
        System.out.println("getFallBack");
        return "业务繁忙!";
    }

    default String postFallback(Exception e) {
        System.out.println("postFallBack");
        return "业务繁忙!";
    }

    default String putFallback(Exception e) {
        System.out.println("putFallback");
        return "业务繁忙!";
    }
}
