package cn.lonecloud.drools.chp1;

import cn.lonecloud.drools.bean.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author lonecloud
 * @version v1.0
 * @Package cn.lonecloud.drools.chp1
 * @Description: TODO
 * @date 2019/12/309:03 PM
 */
public class Chp1Main {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession helloWorld = kieClasspathContainer.newKieSession("helloWorld");
        helloWorld.insert(new Person("小米",20));
        int i = helloWorld.fireAllRules();
        System.out.println("一共运行了"+i+"条规则");
        helloWorld.dispose();
    }
}
