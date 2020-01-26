package cn.xiongyu.leetcode;

import java.lang.String;
import java.util.*;

/**
 * ClassName: HandofStraights
 * Package: cn.xiongyu.leetcode
 * Description:
 * Date: 19-10-9 下午9:45
 * Author: xiongyu
 */
public class HandofStraights {

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length == 0)
            return false;
        if (hand.length % W != 0)
            return false;
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int ha : hand) {
            map.put(ha, map.getOrDefault(ha, 0) + 1);
        }
        int i = 0;
        while(i < hand.length) {
            int offset = 0;
            while(offset < W) {
                Integer count = map.get(hand[i] + offset);
                if (count == null || count == 0) {
                    return false;
                }
                map.put(hand[i] + offset, count - 1);
                offset++;
            }
            while (i < hand.length && map.get(hand[i]) == 0)
                i++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = new int[]{1,2,3,6,2,3,4,7,8};
        int W = 3;
        HandofStraights hos = new HandofStraights();
        hos.isNStraightHand(hand, W);
    }
}
