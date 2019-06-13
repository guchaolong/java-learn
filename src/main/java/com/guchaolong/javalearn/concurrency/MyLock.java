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
package com.guchaolong.javalearn.concurrency;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/6/7 17:21
 */
public class MyLock {

    /**
     * 静态内部类，继承自同步器
     */
    static class MyAQS extends AbstractQueuedSynchronizer{
       @Override
       /**
        * state为0时获取锁
        */
       protected boolean tryAcquire(int arg) {
          if(compareAndSetState(0,1)){
              setExclusiveOwnerThread(Thread.currentThread());
              return true;
          }
          return false;
       }

       @Override
       /**
        * 释放锁，状态设置为0
        */
       protected boolean tryRelease(int arg) {
           if (getState() == 0){
               throw new IllegalMonitorStateException();
           }
           setExclusiveOwnerThread(null);
           setState(0);
           return true;
       }

       @Override
       //独占式下，state是否被占用
       protected boolean isHeldExclusively() {
           return getState()==1;
       }

       Condition newCondition(){
           return new ConditionObject();
       }
   }

   private final MyAQS myAQS = new MyAQS();

    public void lock(){
        myAQS.tryAcquire(1);
    }

    public boolean tryLock(){
        return myAQS.tryAcquire(1);
    }

    public void unLock(){
        myAQS.release(1);
    }

    public Condition newCondition(){
        return myAQS.newCondition();
    }

    public boolean isLocked(){
        return myAQS.isHeldExclusively();
    }
}