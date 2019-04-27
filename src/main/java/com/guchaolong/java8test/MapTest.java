/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/1/3 1.0          guchaolong          Creation File
 */
package com.guchaolong.java8test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/1/3 1:34
 */
public class MapTest {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        String sdf = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().reduce("初始值", (a, b) -> a +","+ b);
        System.out.println(sdf);

        String collect = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted().collect(Collectors.joining("|"));
        System.out.println(collect);


    }
}