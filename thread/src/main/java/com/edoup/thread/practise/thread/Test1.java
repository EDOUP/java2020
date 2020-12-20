package com.edoup.thread.practise.thread;

import java.nio.ByteBuffer;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/12 22:23
 */
public class Test1 {

    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocateDirect(1024);
        allocate.clear();
    }
}
