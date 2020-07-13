package org.ybd.api;

import com.ybd.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/test",method = RequestMethod.GET)
public class RedisCacheController {

    private int count = 0;

    @Autowired
    private RedisCacheService redisCacheService;
    
    @GetMapping
    public String cacheControl() throws InterruptedException {
        if (count == 5){
            redisCacheService.clearCache();
            count = 0;
        }
        count++;
        return redisCacheService.longRunnigMethod();
    }
    
  
}
