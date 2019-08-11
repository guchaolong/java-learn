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
public abstract class AbstractHandler {
    public static AbstractHandler startHandler = new Handler1();
    private AbstractHandler nextHandler;

    static {
        startHandler.setNextHandler(new Handler2())
                .setNextHandler(new Handler3());
    }

    private AbstractHandler setNextHandler(AbstractHandler handler){
        this.nextHandler = handler;
        return this.nextHandler;
    }

    protected void commonLog(){
        System.out.println(this.getClass().getName());
    }

    protected void handle(){
        if(this.nextHandler != null){
            this.nextHandler.handle();
        }
    }
}