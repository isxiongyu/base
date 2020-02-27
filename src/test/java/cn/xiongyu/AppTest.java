package cn.xiongyu;

import static org.junit.Assert.assertTrue;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.String;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    private static final int _1MB = 1024 * 1024;

    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println(2^5);
        assertTrue( true );
    }

    @Test
    public void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    @Test
    public void test01() {
        char[] c = new char[5];
        String s = new String(c);
        System.out.println(s.length());
    }

    @Test
    public void test02() {
        String[] a = new String[5];
        ArrayList<String> list = new ArrayList<>(a.length);
        Collections.addAll(list, a);
    }

    @Test
    public void test03() {
        int a = -3;
        System.out.println(a % 2);
    }

    @Test
    public void test04() {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list2.add(1);
        System.out.println(list1.equals(list2));
    }

    @Test
    public void test05() {
        long a = 12;
        System.out.println(a % 2);
        System.out.println(Math.sqrt(45));
    }
    int a = 0;
    private int get() {
        a = 5;
        return 0;
    }
    @Test
    public void test06() {
        a = a + get();
        System.out.println(a);
    }
    @Test
    public void test07() {
        Integer[] a = { 9, 8, 7, 2, 3, 4, 1, 0, 6, 5 };
        // 定义一个自定义类MyComparator的对象
        Comparator cmp = new MyComparator();
        Arrays.sort(a, cmp);
        System.out.print(Arrays.toString(a));
    }
    @Test
    public void test08() {
        String s = "\uD834\uDF06高小叶是垃圾";
        char[] c = s.toCharArray();
//        System.out.println("\uD834");
        System.out.println(s.substring(8, 8));
    }
    @Test
    public void test09() {
        String s = "abababeebbe";
        String[] strs = s.split("e");
        System.out.println(strs.length);
        System.out.println(Arrays.toString(strs));
    }
    @Test
    public void test10() {
        try {
            FileInputStream fis = new FileInputStream("/home/xiongyu/Desktop/urls.txt");
            byte[] b = new byte[10];
            while (fis.read(b) != -1) {
                System.out.println(new String(b));
            }
//            int num = fis.read(b);
//            System.out.println("总字节：" + num);
//            System.out.println(Arrays.toString(b));
//            System.out.println(new String(b));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test11() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("sgf", "afsdkf");
        map.get("sgf");
        map.size();
        System.out.println(map.get("sgf"));
    }
}

class MyComparator implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        // 如果o1小于o2，我们就返回正值，如果n1大于n2我们就返回负值，
        if (o1 < o2) {
            return 1;
        } else if (o1 > o2) {
            return -1;
        } else {
            return 0;
        }
    }
}
