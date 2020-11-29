package leetcode.learn;

import java.util.HashMap;
import java.util.Map;

/**
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * @author Terry
 * @since 2020/8/28 16:44
 */
public class DanciHuisu {

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        char ch = word.charAt(0);
        boolean[][] visitor = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] != ch) {
                    continue;
                }
                if (backtrack(board, visitor, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(char[][] board, boolean[][] visitor, int x, int y, String word, int i) {
        if (i == word.length()) {
            return true;
        }
        if ((x < 0 || x >= board.length) || (y < 0 || y >= board[0].length) || visitor[x][y] ||
                word.charAt(i) != board[x][y]) {
            return false;
        }
        visitor[x][y] = true;
        if (backtrack(board, visitor, x + 1, y, word, i + 1)) {
            return true;
        }
        if (backtrack(board, visitor, x - 1, y, word, i + 1)) {
            return true;
        }
        if (backtrack(board, visitor, x, y + 1, word, i + 1)) {
            return true;
        }
        if (backtrack(board, visitor, x, y - 1, word, i + 1)) {
            return true;
        }
        visitor[x][y] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[3][4];
//        board[0][0] = 'A';
        board[0][0] = 'A';
        board[0][1] = 'B';
        board[0][2] = 'C';
        board[0][3] = 'E';
        board[1][0] = 'S';
        board[1][1] = 'F';
        board[1][2] = 'C';
        board[1][3] = 'S';
        board[2][0] = 'A';
        board[2][1] = 'D';
        board[2][2] = 'E';
        board[2][3] = 'E';
        DanciHuisu danciHuisu = new DanciHuisu();
        System.out.println(danciHuisu.exist(board, "SEE"));
        String[] a = {"1","2"};
//        Map<Character, Integer> maps = new HashMap<>(26);
//        maps.put('q', 1);
//        maps.put('w', 1);
//        maps.put('e', 1);
//        maps.put('r', 1);
//        maps.put('t', 1);
//        maps.put('y', 1);
//        maps.put('u', 1);
//        maps.put('i', 1);
//        maps.put('o', 1);
//        maps.put('p', 1);
//        maps.put('a', 2);
//        maps.put('s', 2);
//        maps.put('d', 2);
//        maps.put('f', 2);
//        maps.put('g', 2);
//        maps.put('h', 2);
//        maps.put('j', 2);
//        maps.put('k', 2);
//        maps.put('l', 2);
//        maps.put('z', 3);
//        maps.put('x', 3);
//        maps.put('c', 3);
//        maps.put('v', 3);
//        maps.put('b', 3);
//        maps.put('n', 3);
//        maps.put('m', 3);
    }
}
