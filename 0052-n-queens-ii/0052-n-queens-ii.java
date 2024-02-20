class Solution {
    public int totalNQueens(int n) {
        int[] result = {0};
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        totalNQueensHelper(board, 0, result);
        return result[0];
    }

    private void totalNQueensHelper(char[][] board, int row, int[] result) {
        if (row == board.length) {
            result[0]++;
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isValidMove(board, row, col)) {
                board[row][col] = 'Q';
                totalNQueensHelper(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValidMove(char[][] board, int row, int col) {
        // Check if there is a queen in the same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check if there is a queen in the upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check if there is a queen in the upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
