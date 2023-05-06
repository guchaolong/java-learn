package com.guchaolong.javalearn.jvm;

/**
 * Description:
 *
 * @author Ezekiel
 * @date 2023/4/25 01:31
 */
public class Code_06_ClassLoadingProcedure {
    public static void main(String[] args) {
        System.out.println(T.count);
    }
}

class T {
    /*
    第一种情况：输出结果为3
    分析：
    加载：class文件落到内存
    验证
    准备：静态变量赋默认值，count=0， t = null
    解析
    初始化：静态成员变量赋初始值，count = 2,
            t = new T(), 调用了构造函数，count = 3
    ...
     */
//    public static int count = 2;//默认值为0，初始值为2
//    public static T t = new T();//默认值为null, 初始值为new T();


    /*
    第二种情况：改变一下顺序，输出结果为2
    分析：
    加载：class文件落到内存
    验证
    准备：静态变量赋默认值，t = null， count=0，
    解析
    初始化：静态成员变量赋初始值，t = new T()，调用了构造函数，count = 1;
           count = 2, ,
    ...
     */
    public static T t = new T();//默认值为null, 初始值为new T();
    public static int count = 2;//默认值为0，初始值为2




    private T() {
        count++;
    }
}
