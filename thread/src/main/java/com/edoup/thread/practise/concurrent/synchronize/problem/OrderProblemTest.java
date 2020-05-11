package com.edoup.thread.practise.concurrent.synchronize.problem;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.infra.results.I_Result;

import static org.openjdk.jcstress.annotations.Expect.ACCEPTABLE_INTERESTING;

/**
 * <p>
 * synchronized通过互斥性保证有序性--并发压测
 * </p>
 *
 * @author edoup
 * @date 2020/4/8 10:33
 */
@JCStressTest
@Outcome(id = {"1", "4"}, expect = ACCEPTABLE_INTERESTING, desc = "ok")
@Outcome(id = {"0"}, expect = ACCEPTABLE_INTERESTING, desc = "exception")
@State
public class OrderProblemTest {

    int num = 0;
    boolean flag = false;
    Object obj = new Object();

    @Actor
    public void method1(I_Result i) {
        synchronized (obj) {
            if (flag) {
                i.r1 = num + num;
            } else {
                i.r1 = 1;
            }
        }
    }

    @Actor
    public void method2(I_Result i) {
        synchronized (obj) {
            num = 2;
            flag = true;
        }
    }
}
