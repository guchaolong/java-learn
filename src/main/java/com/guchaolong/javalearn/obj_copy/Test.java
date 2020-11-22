package com.guchaolong.javalearn.obj_copy;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/20 9:15
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {

        /**
         * 1. 浅拷贝
         创建一个新对象，然后将当前对象的非静态字段复制到该新对象，
         如果字段是值类型的，那么对该字段执行复制；
         如果该字段是引用类型的话，则复制引用但不复制引用的对象。因此，原始对象及其副本引用同一个对象
         */
        Person p1 = new Person("张三", 21);
        p1.setAddress("云南", "昆明");

        System.out.println("浅拷贝================================");
        Person p2 = (Person)p1.clone();
        System.out.println("p1:"+p1);
        System.out.println("p1.getPname:"+p1.getPname().hashCode());

        System.out.println("p2:"+p2);
        System.out.println("p2.getPname:"+p2.getPname().hashCode());

        p1.display("p1");
        p2.display("p2");
        p2.setAddress("湖北省", "荆州市");
        System.out.println("将复制之后的对象地址修改：");
        p1.display("p1");
        p2.display("p2");


        System.out.println("深拷贝================================");


    }
}
