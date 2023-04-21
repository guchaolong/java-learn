package com.guchaolong.javalearn.innerclass;

import java.util.*;

/**
 * Description:
 *
 * @author Ezekiel
 * @date 2023/4/19 01:22
 */
public class OuterClass {
    private String name;
    private int age;

    ArrayList<String> values;
    SortedSet s = Collections.synchronizedSortedSet(new TreeSet());
    Map<String, Object> synchronizedHashMap = Collections.synchronizedMap(new HashMap<String, Object>());

    public class InnerClass{
        public InnerClass(String name){
            name = "hello " + name;
        }
    }
}
