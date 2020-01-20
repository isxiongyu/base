package cn.xiongyu.nowcoder.offer;

/**
 * ClassName: TreePostorder
 * Package: cn.xiongyu.nowcoder
 * Description:
 * Date: 19-12-12 下午3:23
 * Author: xiongyu
 */
import java.util.*;
public class TreePostorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] tree = new int[n][2];
        for (int i = 0; i < n; i++) {
            tree[i][0] = sc.nextInt();
            tree[i][1] = sc.nextInt();
        }
        TreeNode root = TreeNode.getTree(tree);
        postorder(root);
    }
    private static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        Map<TreeNode, Boolean> status = new HashMap<>();
        status.put(root, false);
        boolean state = false;
        while (root != null) {
            while (root.left != null && !state) {
                root = root.left;
                status.put(root, false);
            }
            if (root.right != null) {
                if (status.get(root)) {
                    System.out.print(root.val + " ");
                    root = root.parent;
                } else {
                    status.put(root, true);
                    state = true;
                    root = root.right;
                    status.put(root, false);
                }
            } else {
                System.out.print(root.val + " ");
                status.put(root, true);
                state = true;
                root = root.parent;
            }
        }
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode(int val) {
            this.val = val;
        }
        public static TreeNode getTree(int[][] tree) {
            TreeNode root = new TreeNode(1);
            TreeNode head = root;
            Map<Integer, TreeNode> map = new HashMap<>();
            for (int i = 0; i < tree.length; i++) {
                if (map.containsKey(i))
                    root = map.get(i);
                if (tree[i][0] != 0) {
                    TreeNode left = new TreeNode(tree[i][0]);
                    left.parent = root;
                    root.left = left;
                    map.put(tree[i][0] - 1, left);
                }
                if (tree[i][1] != 0) {
                    TreeNode right = new TreeNode(tree[i][1]);
                    right.parent = root;
                    root.right = right;
                    map.put(tree[i][1] - 1, right);
                }
            }
            return head;
        }
    }
}
