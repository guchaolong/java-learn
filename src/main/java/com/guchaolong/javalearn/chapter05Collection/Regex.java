/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2018/12/21 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.chapter05Collection;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/12/21 1:17
 */
public class Regex {
    public static void main(String[] args) {
        String str = "sd\\d{3,5}";
        System.out.println(str);
        String input = "3d";
        boolean matches = input.matches(str);
        System.out.println(matches);
    }
}
