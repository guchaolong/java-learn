package com.guchaolong.javalearn.concurrency.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Description:
 *
 * @author Ezekiel
 * @date 2023/4/25 18:53
 */
public class T001_TestUnsafe {
    int i = 0;
    private static T001_TestUnsafe  t = new T001_TestUnsafe();

    public static void main(String[] args) throws Exception {
//        Unsafe unsafe = Unsafe.getUnsafe();

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        Field f = T001_TestUnsafe.class.getDeclaredField("i");
        long offset = unsafe.objectFieldOffset(f);
        System.out.println(offset);

        boolean success = unsafe.compareAndSwapInt(t, offset, 0, 1);
        System.out.println(success);
        System.out.println(t.i);
        //unsafe.compareAndSwapInt()


    }
}
