package com.guchaolong.javalearn.jvm;

/**
 * Description:
 * 类加载器的范围
 * 查看源码Launcher类源码，可以看到使用了：
 * System.getProperty("sun.boot.class.path");
 * System.getProperty("java.ext.dirs");
 * System.getProperty("java.class.path");
 * 获取指定路径
 *
 * @author Ezekiel
 * @date 2023/4/21 08:13
 */
public class Code_03_ClassLoaderScope {
    public static void main(String[] args) {
        String bootPath = System.getProperty("sun.boot.class.path");
        System.out.println(bootPath.replaceAll(":",System.lineSeparator()));
        System.out.println("--------------------------------");

        String extPath = System.getProperty("java.ext.dirs");
        System.out.println(extPath.replaceAll(":",System.lineSeparator()));
        System.out.println("--------------------------------");

        String classPath = System.getProperty("java.class.path");
        System.out.println(classPath.replaceAll(":",System.lineSeparator()));
    }

}
