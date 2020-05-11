package com.edoup.vm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/5/1 13:12
 */
public class vm {

    public static void main(String[] args) {
       List<String> lists = new ArrayList<>();
        while (true){
            lists.add("1");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
