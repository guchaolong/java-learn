package com.guchaolong.javalearn.jvm;

/**
 * Description:
 *
 * @author Ezekiel
 * @date 2023/4/21 05:04
 */
public class Code_02_ClassLoaderLevel {
    public static void main(String[] args) {
        //String是ClassLoader打印为null，是因为BootStrapClassLoader是用c++写的，使用原生代码来实现，并不继承于java.lang.ClassLoader，
        // 所以在返回该ClassLoader时就会返回null
        System.out.println(String.class.getClassLoader());

        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());

        System.out.println(Code_01_HeapTest.class.getClassLoader());

        //ExtClassLoader和AppClassLoader都是由BootStrapClassLoader加载的
        System.out.println(Code_01_HeapTest.class.getClassLoader().getClass().getClassLoader());
    }
}
