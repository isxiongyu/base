package cn.xiongyu.nowcoder.leetcode;


import org.junit.Test;

/**
 * ClassName: MinDepth
 * Package: cn.xiongyu.nowcoder.leetcode
 * Description:
 * Date: 20-1-19 下午9:53
 * Author: xiongyu
 */
public class MinDepth {
    int ans = Integer.MAX_VALUE;
    public int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return ans;
    }
    private void dfs(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            ans = Math.min(ans, depth);
        }
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(run(root));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
