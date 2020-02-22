package cn.lonecloud.drools.chp4;

import cn.lonecloud.drools.bean.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author lonecloud
 * @version v1.0
 * @Package cn.lonecloud.drools.chp4
 * @Description: TODO
 * @date 2020/2/2211:14 AM
 */
public class GlobalMain {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession globalSession = kieClasspathContainer.newKieSession("global");
        globalSession.setGlobal("count",10);
        globalSession.setGlobal("person",new Person());
        int i = globalSession.fireAllRules();
        System.out.println("一共运行了"+i+"条规则");
        globalSession.dispose();
    }
}
