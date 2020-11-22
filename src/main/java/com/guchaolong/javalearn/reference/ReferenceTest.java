package com.guchaolong.javalearn.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/20 7:50
 */
public class ReferenceTest {
    public static void main(String[] args) {
        /**
         * 强引用
         * 内存不足也不会回收，OOM
         */
        String str = new String("HELLO");

        /**
         * 软引用
         * 内存不足 才回收
         * 1. 注意 这里的sf是强引用，指向SoftReference对象
         * 2. 这里的软引用指的是指向 new String("HELLO")的对象，也就是SoftReference中的T
         */
        SoftReference<String> sf = new SoftReference<>(new String("HELLO"));

        System.out.println(sf.get());

        /**
         * 弱引用
         * 遇到GC就会回收
         */
        WeakReference<String> wf = new WeakReference<>(new String("HELLO"));
        System.out.println(wf.get());

        /**
         * 虚引用
         * 虚引用的回收机制跟弱引用差不多，但是它被回收之前，会被放入ReferenceQueue 中。注意
         * 哦，其它引用是被JVM回收后才被传入ReferenceQueue 中的。由于这个机制，所以虚引用大多被
         * 用于引用销毁前的处理工作。还有就是，虚引用创建的时候，必须带有ReferenceQueue ，使用
         * 例子
         */
        PhantomReference<String> pf = new PhantomReference<>(new String("HELLO"), new ReferenceQueue<>());
        System.out.println(pf.get());

    }
}
