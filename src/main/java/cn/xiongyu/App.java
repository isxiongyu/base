package cn.xiongyu;

import cn.xiongyu.designPattern.proxy.Service;
import cn.xiongyu.designPattern.proxy.ServiceImpl;
import com.mysql.jdbc.Driver;
import org.junit.Test;
import scala.Int;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        App app = new App();
        Object o = new Object();
        System.out.println(o.getClass().getClassLoader());
        System.out.println(app.getClass().getClassLoader());
        app.test01();
    }
    @Test
    public void test() {
        Student s1 = new Student("1", "11", "111");
        Student s2 = new Student("1", "11", "111");
        HashMap<Student, Integer> map = new HashMap<>();
        map.put(s1, 1);
        map.put(s2, 1);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(()-> System.out.println("sdfsd"));
        System.out.println(map.size());
    }
    public void test01() throws IOException {
        System.out.println(this.getClass().getResource("").getPath());
        InputStream in = this.getClass().getResourceAsStream("App.java");
        byte[] bytes = new byte[1024];
        in.read(bytes);
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }
    public int calc(int a) {
        int result = 0, i = 0, j = 0;
        for (int k = a; k > 0; k--) {
            if (j > 0) {
                j = k * 10 + j;
            } else {
                j = k;
            }
            while (j >= 10) {
                int t = j % 100;
                j = j / 100;
                result = ((i++ % 2 == 0) ? result - t : result + t);
            }
        }
        if (j > 0) {
            result = ((i++ % 2 == 0) ? result - j : result + j);
        }
        return result;
    }
    @Test
    public void test02() throws IOException {
//        System.out.println(calc(101));
        Service service = new ServiceImpl();
        System.out.println(service instanceof ServiceImpl);
    }
}

