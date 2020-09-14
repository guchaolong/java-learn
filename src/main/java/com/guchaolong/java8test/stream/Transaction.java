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
package com.guchaolong.java8test.stream;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/1/3 1:58
 */
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
    public String toString(){
        return "{" + this.trader + ", " +
                "year: "+this.year+", " +
                "value:" + this.value +"}";
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    public Transaction(Trader trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
}