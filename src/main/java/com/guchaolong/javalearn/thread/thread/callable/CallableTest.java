/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/6/7 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.thread.thread.callable;

import java.util.concurrent.Callable;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/6/7 1:31
 */
public class CallableTest implements Callable {
    @Override
    public String call() throws Exception {
        return "hello";
    }
}