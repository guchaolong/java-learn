/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2018/12/12 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.chapter05Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/12 2:14
 */
public class List1 {
    public  static void main(String [] args){
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");

        System.out.println(list1.contains("a"));

        List<Person> list2 = new ArrayList<>();
        list2.add(new Person(23, "MM"));
        list2.add(new Person(34, "gh"));
        Person p1 = new Person(1, "D");
        p1.equals(new Person(1, "D"));
        System.out.println(list2.contains(new Person(23,"MM")));



    }
}