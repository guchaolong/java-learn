/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/8/11 1.0          guchaolong          Creation File
 */
package com.guchaolong.coderebuild.handle;

/**
 *
 */
public class Handler2 extends AbstractHandler {
    @Override
    protected void handle() {
        if(true){
            System.out.println("handle2");
            super.commonLog();
        }
        super.handle();
    }
}