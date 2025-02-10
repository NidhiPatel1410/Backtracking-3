class WordSearch {
    int m, n;
    int[][] dirs;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (recurse(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean recurse(char[][] board, int row, int col, int index, String word) {
        // base
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row == m || col < 0 || col == n || board[row][col] == '#') {
            return false;
        }

        // logic
        if (board[row][col] == word.charAt(index)) {
            board[row][col] = '#';
            for (int[] dir : dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if (recurse(board, nr, nc, index + 1, word)) {
                    return true;
                }
            }
            board[row][col] = word.charAt(index);
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] { { 'A', 'B', 'R', 'O' }, { 'S', 'F', 'C', 'S' }, { 'L', 'O', 'R', 'E' } };
        String word = "SFCRESOR";
        WordSearch sv = new WordSearch();
        System.out.println(sv.exist(board, word));
    }
}