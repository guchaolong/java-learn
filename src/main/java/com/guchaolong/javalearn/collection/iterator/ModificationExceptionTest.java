package com.guchaolong.javalearn.collection.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Description:
 *
 * @author Ezekiel
 * @date 2023/4/19 17:00
 */
public class ModificationExceptionTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("test");
        list.add("test1");
        list.add("test2");

//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            if(iterator.next().equals("test")) {
//                //使用list的操作方法会抛出ConcurrentModificationException
////                list.remove("test");
//            }
//            System.out.println(iterator.next());
//        }

        ListIterator<String> stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()) {
            if(stringListIterator.next().equals("test")) {
                stringListIterator.remove();
            }
            System.out.println(stringListIterator.next());
        }
    }
}
