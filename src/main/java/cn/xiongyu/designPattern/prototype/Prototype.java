package cn.xiongyu.designPattern.prototype;

import java.io.*;
import java.lang.String;

/**
 * ClassName: Prototype
 * Package: cn.xiongyu.designPattern.prototype
 * Description:
 * Date: 19-10-5 下午9:32
 * Author: xiongyu
 */
public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;
    String name = "xiongyu";
    int age = 13;

    @Override
    public String toString() {
        return "Prototype{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }

    public Prototype deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object o = ois.readObject();
        return (Prototype) o;
    }

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Prototype prototype1 = new Prototype();
        Prototype prototype2 = prototype1.deepClone();
        System.out.println(prototype2);
    }
}
