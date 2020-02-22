package cn.lonecloud.drools.chp1;

import cn.lonecloud.drools.bean.Person;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.TimedRuleExecutionOption;

/**
 * @author lonecloud
 * @version v1.0
 * @Package cn.lonecloud.drools.chp1
 * @Description: TODO
 * @date 2020/1/139:01 PM
 */
public class Chp3Main {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession helloWorld = kieClasspathContainer.newKieSession("chp3");
        helloWorld.insert(new Person("小米",20));
        int i = helloWorld.fireAllRules();
        System.out.println("一共运行了"+i+"条规则");

        KieSession salience = kieClasspathContainer.newKieSession("salience");
        salience.getAgenda().getAgendaGroup("demo1").setFocus();
        int salienceCount = salience.fireAllRules();
        System.out.println("一共运行了"+salienceCount+"条规则");
        //定时任务
        KieSessionConfiguration kieBaseConfiguration = kieServices.newKieSessionConfiguration();
        kieBaseConfiguration.setOption(TimedRuleExecutionOption.YES);
        KieSession kieSession = kieClasspathContainer.newKieBase("chp3",KieServices.Factory.get().newKieBaseConfiguration()).newKieSession(
                kieBaseConfiguration, null
        );
        int i1 = kieSession.fireAllRules();



    }
}
