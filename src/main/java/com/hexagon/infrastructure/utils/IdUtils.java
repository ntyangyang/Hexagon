package com.hexagon.infrastructure.utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Eason
 * @createTime 2019-02-18 下午 10:39
 * @description
 */
public class IdUtils {
    private static AtomicInteger atomicInt = new AtomicInteger(0);

    public static int getPrimaryKey() {
        return atomicInt.incrementAndGet();
    }
}
