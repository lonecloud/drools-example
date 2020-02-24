package cn.lonecloud.drools.chp6;

import cn.lonecloud.drools.bean.Person;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lonecloud
 * @version v1.0
 * @Package cn.lonecloud.drools.chp6
 * @Description: TODO
 * @date 2020/2/2410:59 PM
 */
public class CaseMain {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession session = kieClasspathContainer.newKieSession("chp6_case");
        session.insert(new Person("小华",10));
        session.insert(new Person("小A",20));
        session.insert(new Person("小B",30));
        session.insert(new Person("小C",40));
        List<String> list=new ArrayList<>();
        list.add("小华");
        session.insert(list);
//        int i = session.fireAllRules(new RuleNameEqualsAgendaFilter("rule1"));
        int i = session.fireAllRules(new SelfAgendaFilter());
//        int i = session.fireAllRules();
        System.out.println("一共运行了"+i+"条规则");
        session.dispose();
    }
}
