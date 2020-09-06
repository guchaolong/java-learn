package com.guchaolong.javalearn.fail_fast_safe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 *
 * @author AA
 * @date 2020/9/6 8:30
 */
public class Test {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap();

        map.put("str1", "aaa");
        map.put("str2", "bbb");
        map.put("str3", "ccc");


        /**
         * 原因是迭代器在遍历时直接访问集合中的内容，并且在遍历过程中使用一个 modCount 变量。
         * 集合在被遍历期间如果内容发生变化，就会改变 modCount 的值。
         *
         * 每当迭代器使用 hashNext()/next() 遍历下一个元素之前，都会检测 modCount 变量是否为 expectedModCount 值，
         * 是的话就返回遍历；否则抛出异常，终止遍历。
         */
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getKey());
//            map.put("str4", "ddd");//会快速失败
        }

        Map<String, String> map2 = new ConcurrentHashMap<>();
        map2.put("str1", "aaa");
        map2.put("str2", "bbb");
        map2.put("str3", "ccc");
        Set<Map.Entry<String, String>> entries1 = map2.entrySet();
        Iterator<Map.Entry<String, String>> iterator1 = entries1.iterator();
        while (iterator1.hasNext()){
            String key = iterator1.next().getKey();
            System.out.println(key);
            if(key.equals("str2")){
                System.out.println("ok");
            }
        }
    }
}
