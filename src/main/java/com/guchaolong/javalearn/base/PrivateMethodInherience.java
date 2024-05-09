package com.guchaolong.javalearn.base;

/**
 * Description:
 *
 * @author AA
 * @date 2020/9/16 9:10
 */
class FartherClass{
    private String name;
    private String address;

    void setName(String name){
        this.name = name;
    };

    public String getName(){
        return name;
    }

}

class SunClass extends FartherClass{

    public void f1(){
        setName("fs");
    }

    @Override
    void setName(String name) {
        super.setName(name);
    }
}
public class PrivateMethodInherience {
    public static void main(String[] args) {
        SunClass s = new SunClass();
        s.f1();
        System.out.println(s.getName());

    }
}
