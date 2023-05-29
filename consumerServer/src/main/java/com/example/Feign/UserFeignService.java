package com.example.Feign;

import example.Entity.CommonResult;
import example.Entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient("provider-server")
public interface UserFeignService {

    @GetMapping("/user/get")
    public String get();

    @PostMapping("/user/post")
    public String post();

    @PutMapping("/user/put")
    public String put();

    @DeleteMapping("/user/delete")
    public String delete();
}
