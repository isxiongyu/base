package cn.xiongyu.leetcode;

/**
 * ClassName: SumLeftLeaves
 * Package: cn.xiongyu.leetcode
 * Description:
 * Date: 19-10-28 下午8:42
 * Author: xiongyu
 */
public class SumLeftLeaves {

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {return 0;}
        if(root.right == null && root.left == null) {return 0;}
        dfs(root);
        return sum;
    }
    public int dfs(TreeNode root) {
        if(root == null) {return 0;}
        if(root.left == null && root.right == null) {
            return root.val;
        }
//         int left = dfs(root.left);
//         sum += left;
        sum = sum + dfs(root.left);
//        System.out.println(sum);
        dfs(root.right);
        return 0;
    }
}
