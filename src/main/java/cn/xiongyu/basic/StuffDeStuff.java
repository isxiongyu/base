package cn.xiongyu.basic;

/**
 * ClassName: StuffDeStuff
 * Package: cn.xiongyu.basic
 * Description:
 * Date: 20-1-28 上午11:28
 * Author: xiongyu
 */
public class StuffDeStuff {


    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }
}
