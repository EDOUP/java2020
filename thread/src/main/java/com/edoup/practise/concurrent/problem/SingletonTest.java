package com.edoup.practise.concurrent.problem;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.infra.results.L_Result;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * volatile禁止禁止指令重排，synchronized不会禁止
 * -- 实际没有压测出该问题，或许是因为很难复现吧，网上相关理论资料确实不少
 * </p>
 *
 * @author edoup
 * @date 2020/4/13 22:38
 */
/*@JCStressTest
@Outcome(id = {"Date"}, expect = ACCEPTABLE_INTERESTING, desc = "exception")
@Outcome(id = {"null"}, expect = ACCEPTABLE_INTERESTING, desc = "exception")
@State*/
public class SingletonTest implements Serializable {

    private static final long serialVersionUID = 5325385603115969037L;

    private static SingletonTest singleton;
    private Date d = new Date();

    public Date getD() {
        return d;
    }

    @Actor
    public static void method1(L_Result l) {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new SingletonTest();
                }
            }
        }
        l.r1 = singleton.getD();
    }

}
