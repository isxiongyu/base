package cn.xiongyu.leetcode;

/**
 * ClassName: LongestUnivaluePath
 * Package: cn.xiongyu.leetcode
 * Description:
 * Date: 19-10-30 下午10:10
 * Author: xiongyu
 */
public class LongestUnivaluePath {
    private int len = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null){
            return 0;
        }
        traversal(root, root.val);
        return len;
    }
    public int traversal(TreeNode root, int pre) {
        if (root == null) {
            return 0;
        }
        int left = traversal(root.left, root.val);
        int right = traversal(root.right, root.val);
        len = len > (left + right) ? len : (left + right);
        if (root.val == pre) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
