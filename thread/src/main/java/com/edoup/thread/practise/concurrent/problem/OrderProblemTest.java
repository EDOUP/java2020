package com.edoup.thread.practise.concurrent.problem;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.infra.results.I_Result;

/**
 * <p>
 *     有序性问题--并发压测
 * </p>
 *
 * @author edoup
 * @date 2020/4/8 10:33
 */
/*@JCStressTest
@Outcome(id = {"1", "4"}, expect = ACCEPTABLE, desc = "ok")
@Outcome(id = {"0"}, expect = ACCEPTABLE_INTERESTING, desc = "exception")
@State*/
public class OrderProblemTest {

    int num = 0;
    boolean flag = false;

    @Actor
    public void method1(I_Result i) {
        if (flag) {
            i.r1 = num + num;
        } else {
            i.r1 = 1;
        }
    }


    @Actor
    public void method2(I_Result i) {
        num = 2;
        flag = true;
    }
}
