package com.guchaolong.javalearn.data_structure.no2_map;

import java.util.*;

/**
 * Description:
 *
 * @author AA
 * @date 2020/9/24 18:41
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "wq");
        map.put("ssa", "wq");
        map.put("sdg", "wq");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
        }

    }
}
