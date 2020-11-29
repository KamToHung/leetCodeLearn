package leetcode.learn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *
 * @author Terry
 * @since 2020/8/21 17:04
 */
public class QueenHuisu {

    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        // '.' 表⽰空，'Q' 表⽰皇后，初始化空棋盘。
        String[][] board = new String[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = ".";
            }
        }
        backtrack(res, board, 0);
        return res;
    }

    /**
     * @param res   需要返回的结果
     * @param board 路径
     * @param row   行数
     */
    private static void backtrack(List<List<String>> res, String[][] board, int row) {
        if (row == board.length) {
            res.add(format(board));
            return;
        }
        int n = board.length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = "Q";
            backtrack(res, board, row + 1);
            board[row][col] = ".";
        }
    }

    private static List<String> format(String[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                builder.append(board[i][j]);
            }
            res.add(builder.toString());
        }
        return res;
    }

    private static boolean isValid(String[][] board, int row, int col) {
        int n = board.length;
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col].equals("Q")) {
                return false;
            }
        }
        // 检查右上⽅是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        // 检查左上⽅是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 3;
        List<List<String>> result = solveNQueens(n);
        System.out.println(result);
        System.out.println(result.size());
    }
}
