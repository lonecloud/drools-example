package cn.lonecloud.drools.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lonecloud
 * @version v1.0
 * @Package cn.lonecloud.drools.spring
 * @Description: TODO
 * @date 2020/3/15:00 PM
 */
@RestController
@Slf4j
public class DemoController{


    @Autowired
    private KieSession kieSession;

    @GetMapping("/test")
    public void test() {
        int i = kieSession.fireAllRules();
        log.info("运行了{}条规则",i);
    }

}
