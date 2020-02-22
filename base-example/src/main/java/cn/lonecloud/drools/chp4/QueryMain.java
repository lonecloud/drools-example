package cn.lonecloud.drools.chp4;

import cn.lonecloud.drools.bean.Person;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import java.util.Iterator;

/**
 * @author lonecloud
 * @version v1.0
 * @Package cn.lonecloud.drools.chp4
 * @Description: TODO
 * @date 2020/2/2211:14 AM
 */
public class QueryMain {
    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession querySession = kieClasspathContainer.newKieSession("query1");
        querySession.insert(new Person("小米",20));
        querySession.insert(new Person("小哈30",30));
        querySession.insert(new Person("小米40",40));
        querySession.insert(new Person("小米50",50));
        System.out.println("person = 30");
        QueryResults queryResults = querySession.getQueryResults("person is 30");
        for (QueryResultsRow queryResult : queryResults) {
            Object p = queryResult.get("p");
            System.out.println(p);
        }
        System.out.println("person > 30");
        QueryResults queryResults2 = querySession.getQueryResults("person gt",new Integer[]{20});
        for (QueryResultsRow queryResult : queryResults2) {
            Object p = queryResult.get("person2");
            System.out.println(p);
        }        int i = querySession.fireAllRules();
        System.out.println("一共运行了"+i+"条规则");
        querySession.dispose();
    }
}
