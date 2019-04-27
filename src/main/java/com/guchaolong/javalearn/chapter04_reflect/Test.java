/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2018/12/9 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.chapter04_reflect;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/9 14:48
 */
public class Test {
    static void f1(Generic<Number> n){
        System.out.println(n.getClass());
    }
    public static void main(String [] args)throws Exception{
        Generic<Number> n1 = new Generic<>(1);
        f1(n1);
        Generic<Integer> n2 = new Generic<>(2);
//        f1(n2);//会报错


//        Generic g0 = new Generic("DS");//如果不指定，就起不到类型检查的作用，会按Object处理
//        Generic<String> g1 = new Generic<>("df");
//        System.out.println(g1.getKey());
//        Generic<Integer> g2 = new Generic<>(12);


//        List<String> stringArrayList = new ArrayList<String>();
//        List<Integer> integerArrayList = new ArrayList<Integer>();
//
//        Class classStringArrayList = stringArrayList.getClass();
//        Class classIntegerArrayList = integerArrayList.getClass();
//
//        if(classStringArrayList.equals(classIntegerArrayList)){
//            System.out.println("泛型测试类型相同");
//        }

//        List<String> l1 = new ArrayList<String>();
//        List<Integer> l2 = new ArrayList<Integer>();
//        System.out.println(l1.getClass().equals(l2.getClass()));



//        List list = new ArrayList();
//        list.add("sdf");
//        list.add(12);
//        for (Object o : list){
//            String a = (String)o;
//        }




        //
//        Class c1 = Student.class;
//
//        Student student = new Student();
//        Class c2 = student.getClass();
//
//        Class c3 = Class.forName("com.guchaolong.javalearn.chapter04_reflect.Student");
//
//        System.out.println(c1 == c3);
//        System.out.println(c3.getPackage());
//        System.out.println(c3.getName());
//        System.out.println(c3.getSimpleName());
//        System.out.println(c3.isAnnotation());
//        Student o = (Student)c3.newInstance();
//        o.pring();
    }
}