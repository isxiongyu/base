package cn.xiongyu.net;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.String;
import java.net.Socket;

/**
 * ClassName: Client
 * Package: cn.xiongyu.net
 * Description:
 * Date: 19-10-9 下午11:01
 * Author: xiongyu
 */
public class Client {
    public static void main(String[] args) throws IOException {
//        String host = "127.0.0.1";
        String host = "10.108.149.5";
        int port = 55533;
        Socket socket = new Socket(host, port);
        OutputStream os = socket.getOutputStream();
        String message = "class Solution {\n" +
                "    public List<Double> averageOfLevels(TreeNode root) {\n" +
                "        Map<Integer, double[]> map = new HashMap<>();\n" +
                "        List<Double> result = new ArrayList<>();\n" +
                "        dfs(root, map, 0);\n" +
                "        for (int key : map.keySet()) {\n" +
                "            double[] arr = map.get(key);\n" +
                "            result.add(arr[0] / arr[1]);\n" +
                "        }\n" +
                "        return result;\n" +
                "    }\n" +
                "    private void dfs(TreeNode root, Map<Integer, double[]> map, int depth) {\n" +
                "        if (root == null)\n" +
                "            return;\n" +
                "        double[] res = map.get(depth);\n" +
                "        if (res == null) {\n" +
                "            res = new double[2];\n" +
                "            res[0] = root.val;\n" +
                "            res[1] = 1;\n" +
                "        }  else {\n" +
                "            res[0] += root.val;\n" +
                "            res[1]++;\n" +
                "        }\n" +
                "        map.put(depth, res);\n" +
                "        dfs(root.left, map, depth + 1);\n" +
                "        dfs(root.right, map, depth + 1);\n" +
                "    }\n" +
                "}";
        os.write(message.getBytes("UTF-8"));
        os.close();
        socket.close();
    }
}
