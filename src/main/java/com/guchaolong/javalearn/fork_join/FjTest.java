/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/6/13 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.fork_join;

import java.util.concurrent.*;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2019/6/13 23:37
 */

public class FjTest {

    static class CountTask extends RecursiveTask<Integer> {
        private int yuzhi = 2;
        private int start;
        private int end;

        public CountTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            boolean canCount = (end - start) <= yuzhi;
            int sum = 0;
            if (canCount) {
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
            } else {
                int mid = (start + end) / 2;
                CountTask leftTask = new CountTask(start, mid);
                CountTask rightTask = new CountTask(mid + 1, end);

                leftTask.fork();
                rightTask.fork();

                Integer leftResult = leftTask.join();
                Integer rightResult = leftTask.join();
                sum = leftResult + rightResult;
            }
            return sum;
        }
    }


    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        CountTask task = new CountTask(1, 3);
        Future<Integer> result = pool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}