package example.controller;

import example.entity.CommonResult;
import example.entity.User;
import org.springframework.web.bind.annotation.*;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class ProviderController {
    Random random = new Random();

    @GetMapping("/get")
    public String get() throws InterruptedException{
        if (random.nextInt(10) >= 5) {
            throw new RuntimeException("系统繁忙");
        }
        TimeUnit.MILLISECONDS.sleep(500);
        return "11000这是一个get方法";
    }

    @PostMapping("/post")
    public String post() throws InterruptedException{
        if(random.nextInt(10)>=5){
            throw new RuntimeException("系统繁忙");
        }
        TimeUnit.MILLISECONDS.sleep(500);
        return "这是一个post方法";
    }

    @PutMapping("/put")
    public String put(){
        return "11000这是一个put方法";
    }

    @DeleteMapping("/delete")
    public String delete(){
        return "11000这是一个delete方法";
    }
}
