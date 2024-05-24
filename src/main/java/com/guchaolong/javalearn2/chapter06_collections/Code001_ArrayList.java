package com.guchaolong.javalearn2.chapter06_collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Ezekiel
 * @date 2024/5/11 14:13
 */
public class Code001_ArrayList {
    public static void main(String[] args) {
        // 创建ArrayList对象
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banner");
        list.add("orange");
        list.add("pear");

        // 遍历ArrayList
        for (String fruit : list) {
            System.out.println(fruit);
        }

        System.out.println("================");

        System.out.println(list.get(1));
        System.out.println(list.get(3));
        System.out.println(list.size());
        list.remove(1);
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.size());

    }
}
