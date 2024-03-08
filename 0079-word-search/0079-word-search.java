class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existHelper(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean existHelper(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        int m = board.length;
        int n = board[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';  

        boolean result =
            existHelper(board, i + 1, j, word, index + 1) ||
            existHelper(board, i - 1, j, word, index + 1) ||
            existHelper(board, i, j + 1, word, index + 1) ||
            existHelper(board, i, j - 1, word, index + 1);

        board[i][j] = temp;  

        return result;
    }
}
