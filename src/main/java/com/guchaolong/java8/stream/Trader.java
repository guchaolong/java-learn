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
package com.guchaolong.java8.stream;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/1/3 1:56
 */
public class Trader {
    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}