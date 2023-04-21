package com.guchaolong.javalearn.jvm;

import java.io.*;

/**
 * Description:
 *
 * @author Ezekiel
 * @date 2023/4/21 02:04
 */
public class Code_04_CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("/Users/ezekiel/Project/java-learn/build/classes/java/main", name.replace(".", "/").concat(".class"));

        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = fis.read()) != 0) {
                baos.write(b);
            }

            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();

            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);

    }

    public static void main(String[] args) throws Exception {
        ClassLoader l = new Code_04_CustomClassLoader();
        Class clazz = l.loadClass("com.guchaolong.javalearn.jvm.Code_05_ClassLoader");
        Code_05_ClassLoader c = (Code_05_ClassLoader)clazz.newInstance();
        c.sayHello();

        System.out.println(l.getClass().getClassLoader());
        System.out.println(l.getParent());


    }
}
