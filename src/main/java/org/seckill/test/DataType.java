package org.seckill.test;

/**
 * @author 12084
 * @create 2018-06-20 14:42
 */

public class DataType {


    public static void main(String[] args) {

        t3();

    }

    public static void t3() {
        int a = 60; /* 60 = 0011 1100 */
        int b = 13; /* 13 = 0000 1101 */
        int c = 0;
        c = a & b;       /* 12 = 0000 1100 */
        System.out.println("a & b = " + c);

        c = a | b;       /* 61 = 0011 1101 */
        System.out.println("a | b = " + c);

        c = a ^ b;       /* 49 = 0011 0001 */
        System.out.println("a ^ b = " + c);

        c = ~a;          /*-61 = 1100 0011 */
        System.out.println("~a = " + c);

        c = a << 2;     /* 240 = 1111 0000 */
        System.out.println("a << 2 = " + c);

        c = a >> 2;     /* 15 = 1111 */
        System.out.println("a >> 2  = " + c);

        c = a >>> 2;     /* 15 = 0000 1111 */
        System.out.println("a >>> 2 = " + c);
    }

    public static void t2() {
        System.out.println(Math.E);//比任何其他值都更接近 e（即自然对数的底数）的 double 值。
        System.out.println(Math.PI);//比任何其他值都更接近 pi（即圆的周长与直径之比）的 double 值。
        /*
         * 1.abs绝对值函数
         * 对各种数据类型求绝对值
         */
        System.out.println(Math.abs(-10));//输出10

        /*
         * 2.三角函数与反三角函数
         * cos求余弦
         * sin求正弦
         * tan求正切
         * acos求反余弦
         * asin求反正弦
         * atan求反正切
         * atan2(y,x)求向量(x,y)与x轴夹角
         */
        System.out.println(Math.acos(-1.0));//输出圆周率3.14...
        System.out.println(Math.atan2(1.0, 1.0));//输出 π/4 的小数值

        /*
         * 3.开根号
         * cbrt(x)开立方
         * sqrt(x)开平方
         * hypot(x,y)求sqrt(x*x+y*y)在求两点间距离时有用sqrt((x1-x2)^2+(y1-y2)^2)
         */
        System.out.println(Math.sqrt(4.0));//输出2.0
        System.out.println(Math.cbrt(8.0));//输出2.0
        System.out.println(Math.hypot(3.0, 4.0));//输出5.0

        /*
         * 4.最值
         * max(a,b)求最大值
         * min(a,b)求最小值
         */
        System.out.println(Math.max(1, 2));//输出2
        System.out.println(Math.min(1.9, -0.2));//输出-0.2
        /*
         * 5.对数
         * log(a) a的自然对数(底数是e)
         * log10(a) a 的底数为10的对数
         * log1p(a) a+1的自然对数
         * 值得注意的是，前面其他函数都有重载，对数运算的函数只能传double型数据并返回double型数据
         */
        System.out.println(Math.log(Math.E));//输出1.0
        System.out.println(Math.log10(10));//输出1.0
        System.out.println(Math.log1p(Math.E - 1.0));//输出1.0
        /*
         * 6.幂
         * exp(x) 返回e^x的值
         * expm1(x) 返回e^x - 1的值
         * pow(x,y) 返回x^y的值
         * 这里可用的数据类型也只有double型
         */
        System.out.println(Math.exp(2));//输出E^2的值
        System.out.println(Math.pow(2.0, 3.0));//输出8.0

        /*
         * 7.随机数
         * random()返回[0.0,1.0)之间的double值
         * 这个产生的随机数其实可以通过*x控制
         * 比如(int)(random*100)后可以得到[0,100)之间的整数
         */
        System.out.println((int) (Math.random() * 100));//输出[0,100)间的随机数


        //ceil(a) 返回大于a的第一个整数所对应的浮点数(值是整的，类型是浮点型)
        //可以通过强制转换将类型换成整型
        System.out.println(Math.ceil(1.3443));//输出2.0
        System.out.println((int) Math.ceil(1.3443));//输出2

        //floor(a) 返回小于a的第一个整数所对应的浮点数(值是整的，类型是浮点型)
        System.out.println(Math.floor(1.3443));//输出1.0

        //rint(a) 返回最接近a的整数的double值
        System.out.println(Math.rint(1.2));//输出1.0
        System.out.println(Math.rint(1.8));//输出2.0
    }

    public static void t1() {
        byte bmax, bmin;
        short shmax, shmin;
        char cmax, cmin;
        int imax, imin;
        long lmax, lmin;
        float fmax, fmin;
        double dmax, dmin;
        fmax = Float.MAX_VALUE;
        fmin = Float.MIN_VALUE;
        dmax = Double.MAX_VALUE;
        dmin = Double.MIN_VALUE;
        bmax = Byte.MAX_VALUE;
        bmin = Byte.MIN_VALUE;
        cmax = Character.MAX_VALUE;
        cmin = Character.MIN_VALUE;
        shmax = Short.MAX_VALUE;
        shmin = Short.MIN_VALUE;
        imax = Integer.MAX_VALUE;
        imin = Integer.MIN_VALUE;
        lmax = Long.MAX_VALUE;
        lmin = Long.MIN_VALUE;
        System.out.println("float max=" + fmax);
        System.out.println("float min=" + fmin);
        System.out.println("double max=" + dmax);
        System.out.println("double max=" + dmin);
        System.out.println("byte max=" + bmax);
        System.out.println("byte min=" + bmin);
        System.out.println("char max=" + cmax);
        System.out.println("char min=" + cmin);
        System.out.println("short max=" + shmax);
        System.out.println("short min=" + shmin);
        System.out.println("int max=" + imax);
        System.out.println("int min=" + imin);
        System.out.println("long max=" + lmax);
        System.out.println("long min=" + lmin);
        long l = 0x7fffffffffffffffL;
        if (lmax == l) {
            System.out.println("ok");
        } else {
            System.out.println("no");
        }

    }
}
