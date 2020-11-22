package com.guchaolong.javalearn.obj_copy;

/**
 * Description:
 *
 * @author AA
 * @date 2020/11/20 9:35
 */
public class Address {
    private String provices;
    private String city;
    public void setAddress(String provices,String city){
        this.provices = provices;
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Address [provices=" + provices + ", city=" + city + "]";
    }
}
