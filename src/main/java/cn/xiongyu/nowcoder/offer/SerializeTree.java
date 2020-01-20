package cn.xiongyu.nowcoder.offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: SerializeTree
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 20-1-16 下午12:26
 * Author: xiongyu
 */
public class SerializeTree {
    Queue<TreeNode> queue = new LinkedList<>();
    String Serialize(TreeNode root) {
        return bfs(root).toString();
    }
    private String bfs(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        StringBuffer s = new StringBuffer(root.val + "!");
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            s.append(bfs(queue.poll()));
        }
        return s.toString();
    }
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] strs = str.split("!");
        int val = Integer.parseInt(strs[0]);
        TreeNode root = new TreeNode(val);
        construct(Arrays.copyOfRange(strs, 1, strs.length), root);
        return root;
    }
    int st = 0;
    Queue<TreeNode> queueCon = new LinkedList<>();
    private void construct(String[] strs, TreeNode root) {
//        System.out.println(Arrays.toString(strs));
        if (strs == null || strs.length == 0 || root == null) {
            return;
        }
        String strLeft = strs[st];
        String strRight = strs[st + 1];
        TreeNode left = null;
        TreeNode right = null;
        if (!strLeft.equals("#")) {
            left = new TreeNode(Integer.parseInt(strLeft));
        }
        if (!strRight.equals("#")) {
            right = new TreeNode(Integer.parseInt(strRight));
        }
        root.left = left;
        root.right = right;
        st += 2;
        queueCon.add(left);
        queueCon.add(right);
        while (!queueCon.isEmpty()) {
            construct(strs, queueCon.poll());
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left =new TreeNode(6);
        root.right =new TreeNode(10);
        root.left.left =new TreeNode(5);
        root.left.right =new TreeNode(7);
        root.right.left =new TreeNode(9);
        root.right.right =new TreeNode(11);
        SerializeTree st = new SerializeTree();
        String s = st.Serialize(root);
        int i;
        for (i = s.length() - 1; i >=0; i--) {
            if (s.charAt(i) != '#') {
                break;
            }
        }
        s = s.substring(0, i + 1);
        System.out.println(s);
        TreeNode treeNode = st.Deserialize(s);
        System.out.println(treeNode.val);
        System.out.println(treeNode.left.val);
        System.out.println(treeNode.right.val);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val) {
        this.val = val;
    }
}
