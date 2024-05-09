package com.guchaolong.javalearn2.chapter01_base;

/**
 * Description:变量、数据类型
 *
 * @author Ezekiel
 * @date 2024/5/9 01:50
 */
public class Code001_Variable_DataType {
    public static void main(String[] args) {
        byte x = 127;//byte类型可以存储-128到127之间的整数
        short y = 32767;//short类型可以存储-32768到32767之间的整数
        int a = 2147483647;//int类型可以存储-2147483648到2147483647之间的整数
        int b = 2_000_000;//加下划线更容易识别
        long c = 1000L;//long类型可以存储-9223372036854775808到9223372036854775807之间的整数

        float d = 3.14f;//float类型可以存储小数
        double dd = 3.14159265358979323846;//double类型可以存储小数

        char e = 'A';// char类型可以存储单个字符
        boolean f = true;//true表示1，false表示0

        String g = "Hello World";//String类型可以存储字符串

        System.out.println(x + " " + y + " " + a + " " + b + " " + c + " " + d + " " + dd + " " + e + " " + f + " " + g);

        int i_10 = 15;//15的10进制表示
        int i_16 = 0xf;//15的16进制表示
        int i_2 = 0b1111;//15的2进制表示
        System.out.println(i_10 + " " + i_16 + " " + i_2);//15 15 15

        final double PI = 3.14159265358979323846;//常量
//        PI = 3.24159265358979323846;//编译错误，常量不能修改

        //整数溢出
        int x1 = 2147483640;
        int y1 = 15;
        int sum = x1 + y1;
        System.out.println(sum);//-2147483641
        //解决方法：使用long类型
        long x2 = 2147483640L;
        long y2 = 15L;
        long sum2 = x2 + y2;
        System.out.println(sum2);//2147483655

        int n = 10;
        n += 5;//等价于n = n + 5 = 15
        n -= 3;//等价于n = n - 3   = 12
        n *= 2;//等价于n = n * 2   = 24
        n /= 4;//等价于n = n / 4   = 6
        n %= 3;//等价于n = n % 3   = 0

        n &= 1;//等价于n = n & 1   = 0
        n |= 1;//等价于n = n | 1   = 1
        n ^= 1;//等价于n = n ^ 1   = 0
        n <<= 1;//等价于n = n << 1  = 12
        n >>= 1;//等价于n = n >> 1  = 6
        n >>>= 1;//等价于n = n >>> 1 = 6

        //++写在前面和后面计算结果是不同的，++n表示先加1再引用n，n++表示先引用n再加1
        int i,i_;
        i = 100;
        i_ = i++;
        System.out.printf("i = 100, i_ = i++后：i = %d , i_ = %d\n", i, i_);

        i = 100;
        i_ = i--;
        System.out.printf("i = 100, i_ = i--后：i = %d , i_ = %d\n", i, i_);

        i = 100;
        i_ = ++i;
        System.out.printf("i = 100, i_ = ++i后：i = %d , i_ = %d\n", i, i_);

        i = 100;
        i_ = --i;
        System.out.printf("i = 100, i_ = --i后：i = %d , i_ = %d\n", i, i_);
    }
}
