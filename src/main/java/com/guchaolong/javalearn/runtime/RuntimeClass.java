package com.guchaolong.javalearn.runtime;

import java.io.IOException;

/**
 * Description:
 *
 * @author GUCHAOLONG
 * @date 2021/3/25 7:06
 */
public class RuntimeClass {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime r = Runtime.getRuntime();
        Process exec = r.exec("notepad.exe SystemDemo.java");
        Thread.sleep(3000);
        exec.destroy();
    }
}
