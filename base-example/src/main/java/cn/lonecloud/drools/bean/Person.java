package cn.lonecloud.drools.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author lonecloud
 * @version v1.0
 * @Package cn.lonecloud.drools.bean
 * @Description: 定义实体
 * @date 2019/12/309:29 PM
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private int age;

}
