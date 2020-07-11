package cn.xiongyu.concurrent;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * ClassName: Piped
 * Description:
 * Create by xiongyu
 * Date: 2020/5/10 8:32 下午
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedReader in = new PipedReader();
        PipedWriter out = new PipedWriter();
        out.connect(in);
        Thread thread = new Thread(new PrintThread(in), "printThread");
        thread.start();
        int receive = 0;
        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }
    static class PrintThread implements Runnable {

        private PipedReader in;

        public PrintThread(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
