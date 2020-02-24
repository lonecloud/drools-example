package cn.lonecloud.drools.chp6;

import lombok.extern.slf4j.Slf4j;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.Match;

import java.util.Collections;
import java.util.List;

/**
 * @author lonecloud
 * @version v1.0
 * @Package cn.lonecloud.drools.chp6
 * @Description: TODO
 * @date 2020/2/2411:07 PM
 */
@Slf4j
public class SelfAgendaFilter implements AgendaFilter {
    @Override
    public boolean accept(Match match) {
        List<String> declarationIds = match.getDeclarationIds();
        List<? extends FactHandle> factHandles = match.getFactHandles();
        Rule rule = match.getRule();
        log.info("declarationIds"+declarationIds+"rule"+rule.getName());
        return true;
    }
}
