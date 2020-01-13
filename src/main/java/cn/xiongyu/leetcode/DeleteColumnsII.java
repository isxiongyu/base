package cn.xiongyu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: DeleteColumnsII
 * Package: cn.xiongyu.leetcode
 * Description:
 * Date: 19-10-15 下午8:38
 * Author: xiongyu
 */
public class DeleteColumnsII {
    public int minDeletionSize(String[] A) {
        List<Integer> del = new ArrayList<>();
        for (int i = 0; i < A[0].length(); i++) {
            boolean flag = true;
            if (del.contains(i))
                continue;
            for (int j = 1; j < A.length; j++) {
                if (A[j].charAt(i) < A[j - 1].charAt(i)) {
                    del.add(i);
                    flag = false;
                    break;
                } else if (A[j].charAt(i) == A[j - 1].charAt(i)) {
                    flag = false;
                    for (int m = i + 1; m < A[0].length(); m++) {
                        if (del.contains(m))
                            continue;
                        if ((A[j].charAt(m) < A[j - 1].charAt(m))) {
                            del.add(m);
                            continue;
                        } else if (A[j].charAt(m) > A[j - 1].charAt(m)) {
                            break;
                        }
                    }
                }
            }
            if (flag)
                break;
        }
        return del.size();
    }

    public static void main(String[] args) {
        String[] A = new String[]{"frgnwbkytowptsvhaitzfzvtalxfyb","hvolcbgkqfvkuxjhczmysoeeyugbiy","xhrizbzrivpgoevcfbkqcppgortnms","hdozesyrhbqnukoflsomoktkyfgljc","jxfquczkshgrxoauocyqeolfgkihss","ztcqmzdlavyonfbpruidydyctyotuc","ybnsycwuxjfnfqdrwnrvfzfvweqevc","imcpystcxmqfpdvwxtdqnamefulhsd","kkkkrcjsdqgtldiaycmiodgiqxpqsz","ocihmxnbfulgpdgzyzxxkqkhddgdhg"};
        DeleteColumnsII deleteColumnsII = new DeleteColumnsII();
        int a = deleteColumnsII.minDeletionSize(A);
        System.out.println(a);
    }
}
