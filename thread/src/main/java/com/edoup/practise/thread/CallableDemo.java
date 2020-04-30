package com.edoup.practise.thread;


import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class AThread implements Runnable{

    @Override
    public void run() {
        System.out.println("线程方式1");
    }
}

class BThread extends Thread{

    @Override
    public void run() {
        super.run();
    }
}

class CThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        System.out.println(Thread.currentThread().getName() +"com in");
        return "callable thread finish";
    }
}


public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
      //  FutureTask<Integer> aThreadFutureTask = new FutureTask<Integer>(new AThread(),1);
        FutureTask<String> futureTask = new FutureTask<>(new CThread());
        System.out.println(new Date());
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        System.out.println(new Date());
        System.out.println(futureTask.get());
        System.out.println(new Date());
        System.out.println(futureTask.get());
        System.out.println(new Date());
    }
}

