package cn.lonecloud.drools.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lonecloud
 * @version v1.0
 * @Package cn.lonecloud.drools.spring
 * @Description: TODO
 * @date 2020/3/14:56 PM
 */
@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        log.info("启动完成");
    }
}
