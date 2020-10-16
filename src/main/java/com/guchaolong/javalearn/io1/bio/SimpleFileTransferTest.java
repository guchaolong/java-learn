package com.guchaolong.javalearn.io1.bio;

import java.io.*;

/**
 * Description:
 *
 * @author AA
 * @date 2020/9/9 2:11
 */
public class SimpleFileTransferTest {

    public static void main(String[] args) throws Exception{
        File source = new File("E:\\新版发布版.zip");
        File des = new File("E:\\qqq.zip");
        System.out.println("传统io耗时：" + transferFile(source, des));

    }

    private static long transferFile(File source, File des) throws Exception{

        long start = System.currentTimeMillis();

        if(!des.exists()){
            des.createNewFile();
        }

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

        byte[] buff = new byte[1024 * 1024];
        int len;
        while ((len = bis.read(buff)) != -1){
            bos.write(buff);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long transferFileWithNIO(File source, File des) throws Exception{

        long start = System.currentTimeMillis();

        if(!des.exists()){
            des.createNewFile();
        }

        long end = System.currentTimeMillis();
        return end - start;
    }


}
