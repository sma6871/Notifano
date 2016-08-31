package com.aka.adnot.utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by S.Masoud on 2016/08/27.
 */
public class NotificationID {
    private final static AtomicInteger c = new AtomicInteger(0);
    public static int getID() {
        return c.incrementAndGet();
    }
}
