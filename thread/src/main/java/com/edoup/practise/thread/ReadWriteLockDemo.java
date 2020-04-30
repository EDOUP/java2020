package com.edoup.practise.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

 //    ReadWriteLock lock = new ReentrantReadWriteLock();
    static ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        ReadWriteLockDemo readWriteLockDemo1 = new ReadWriteLockDemo();
         new Thread(()->readWriteLockDemo.read1()).start();
         new Thread(()->readWriteLockDemo1.read2()).start();
         new Thread(()->readWriteLockDemo.write1()).start();
         new Thread(()->readWriteLockDemo1.write2()).start();
     //    new Thread(()->readWriteLockDemo.read1()).start();
    //     new Thread(()->readWriteLockDemo.write1()).start();
    //     new Thread(()->readWriteLockDemo.read2()).start();
    }


    public void write1(){
        lock.writeLock().lock();
        try {
            System.out.println("开始写入1");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("写入1完成");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }

    public void write2(){
        lock.writeLock().lock();
        try {
            System.out.println("开始写入2");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("写入2完成");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }

    public void read1(){
        lock.readLock().lock();
        try {
            System.out.println("开始读取1");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("读取1完成");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }

    public void read2(){
        lock.readLock().lock();
        try {
            System.out.println("开始读取2");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("读取2完成");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }

}
