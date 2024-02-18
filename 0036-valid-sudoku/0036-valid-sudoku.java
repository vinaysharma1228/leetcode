class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check each row
        for (int i = 0; i < 9; i++) {
            if (!isValid(board[i])) {
                return false;
            }
        }

        // Check each column
        for (int j = 0; j < 9; j++) {
            char[] column = new char[9];
            for (int i = 0; i < 9; i++) {
                column[i] = board[i][j];
            }
            if (!isValid(column)) {
                return false;
            }
        }

        // Check each 3x3 sub-box
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                char[] subBox = new char[9];
                int index = 0;
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        subBox[index++] = board[x][y];
                    }
                }
                if (!isValid(subBox)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[] values) {
        Set<Character> set = new HashSet<>();
        for (char value : values) {
            if (value != '.') {
                if (!set.add(value)) {

                    return false; // Duplicate found
                }
            }
        }
        return true;
    }
}
