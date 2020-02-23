package cn.lonecloud.drools.chp4;

import cn.lonecloud.drools.bean.Clazz;
import cn.lonecloud.drools.bean.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lonecloud
 * @version v1.0
 * @Package cn.lonecloud.drools.chp4
 * @Description: TODO
 * @date 2020/2/225:05 PM
 */
public class FormMain {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession session = kieClasspathContainer.newKieSession("when_from");

        Clazz clazz=new Clazz("初中","2班");
        session.insert(new Person("小华",10,clazz));
        session.insert(new Person("小A",20,clazz));
        session.insert(new Person("小B",30,clazz));
        session.insert(new Person("小C",40));
        session.insert(clazz);
        List<String> list=new ArrayList<>();
        list.add("小华");
        session.insert(list);
        int i = session.fireAllRules();
        System.out.println("一共运行了"+i+"条规则");
        session.dispose();
    }
}
