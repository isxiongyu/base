package cn.xiongyu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: WordSearch
 * Package: cn.xiongyu.leetcode
 * Description:
 * Date: 19-10-16 下午5:15
 * Author: xiongyu
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String curr = "";
                boolean[][] visited = new boolean[board.length][board[0].length];
                visited[i][j] = true;
                backing(board, i, j, curr, word, 0, list, visited);
                if (list.size() != 0)
                    return true;
            }
        }
        return false;
    }
    private void backing(char[][] board, int x, int y, String curr, String word, int index, List<String> list, boolean[][] visited) {

        if (list.size() != 0)
            return;
        if (index > word.length())
            return;
        char c = word.charAt(index);
        if (c != board[x][y]) {
            return;
        } else {
            curr += c;
        }
        if (curr.length() == word.length()) {
            list.add(curr);
            return;
        }
        if ((x - 1) >= 0  && !visited[x - 1][y]) {
            visited[x - 1][y] = true;
            backing(board, x - 1, y, curr, word, index + 1, list, visited);
            visited[x - 1][y] = false;
        }
        if ((x + 1) < board.length && !visited[x + 1][y]) {
            visited[x + 1][y] = true;
            backing(board, x + 1, y, curr, word, index + 1, list, visited);
            visited[x + 1][y] = false;
        }
        if ((y - 1) >= 0 && !visited[x][y - 1]) {
            visited[x][y - 1] = true;
            backing(board, x, y - 1, curr, word, index + 1, list, visited);
            visited[x][y - 1] = false;
        }
        if ((y + 1) < board[0].length && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            backing(board, x, y + 1, curr, word, index + 1, list, visited);
            visited[x][y + 1] = false;
        }

        return;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
//        char[][] board = new char[][]{
//                                      {'A','B','C','E'},
//                                      {'S','F','C','S'},
//                                      {'A','D','E','E'}
//                                     };
        char[][] board = new char[][]{{'a', 'a'}};
        String word = "aaa";
        System.out.println(ws.exist(board, word));
    }
}
