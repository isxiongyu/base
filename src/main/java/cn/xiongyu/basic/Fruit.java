package cn.xiongyu.basic;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Fruit
 * Package: cn.xiongyu.basic
 * Description:
 * Date: 19-11-27 上午9:38
 * Author: xiongyu
 */
public class Fruit {
}
class Apple extends Fruit {

}
class Vegetable {}
class Test {
    public static void main(String[] args) {
        Apple a = new Apple();
        Vegetable v = new Vegetable();
//        List<? extends Fruit> list = new ArrayList<Fruit>(Arrays.asList(new Fruit()));
//        list.add(new Fruit());
//        System.out.println(list.get(0));
        List<? super Apple> list = new ArrayList<Fruit>();
        list.add(new Apple());
//        Apple apple = list.get(0);
    }
}
