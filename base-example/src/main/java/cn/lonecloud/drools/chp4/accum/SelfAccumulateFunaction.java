package cn.lonecloud.drools.chp4.accum;

import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.rule.AccumulateFunction;

import java.io.*;

/**
 * @author lonecloud
 * @version v1.0
 * @Package cn.lonecloud.drools.chp4.accum
 * @Description: TODO
 * @date 2020/2/239:58 PM
 */
@Slf4j
public class SelfAccumulateFunaction implements AccumulateFunction {
    @Override
    public Serializable createContext() {
        return new Factorial();
    }

    @Override
    public void init(Serializable serializable) throws Exception {
        Factorial factorial=(Factorial) serializable;
        factorial.total=1;
        log.info("init");
    }

    /**
     * 计算过程
     * @param serializable 中间值
     * @param o 对象
     */
    @Override
    public void accumulate(Serializable serializable, Object o) {
        Factorial factorial=(Factorial) serializable;
        factorial.total*=((Number)o).doubleValue();
        log.info("accumulate");
    }

    /**
     * 返回时候
     * @param serializable
     * @param o
     * @throws Exception
     */
    @Override
    public void reverse(Serializable serializable, Object o) throws Exception {
        Factorial factorial=(Factorial) serializable;
        factorial.total/=((Number)o).doubleValue();
        log.info("reverse");
    }

    @Override
    public Object getResult(Serializable serializable) throws Exception {
        Factorial factorial=(Factorial) serializable;

        return factorial.total;
    }

    @Override
    public boolean supportsReverse() {
        //
        return true;
    }

    @Override
    public Class<?> getResultType() {
        return Number.class;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
    public static class Factorial implements Externalizable{

        public double total=1;

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(total);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
           total= in.readDouble();
        }
    }
}
