class Solution {
    /* Time Complexity: O(n*m) --> loop through each element in board*/
    public void solve(char[][] board) {
        if (board == null || board.length <= 2) {
            return;
        }
        
        int n = board.length;
        int m = board[0].length;
        
        boolean[][] visited = new boolean[n][m];
        /* DFS the bounders and mark as visited */
        // the first and last rows
        for (int row = 0; row < n; row += n-1) {
            for (int col = 0; col < m; col++) {
                if (board[row][col] == 'O') {
                    DFS(board, row, col, visited);
                } 
            }
        }
        // the first and last cols
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col += m-1) {
                if (board[row][col] == 'O') {
                    DFS(board, row, col, visited);
                } 
            }
        }
        
        /* Loop through the inner region and flip '0' */
        for (int row = 1; row < n-1; row++) {
            for (int col = 1; col < m-1; col++) {
                if (board[row][col] == 'O' && !visited[row][col]) {
                    board[row][col] = 'X';
                } 
            }
        }
    }
    
    private void DFS(char[][] board, int row, int col, boolean[][] visited) {
        /* Boundary check */
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board.length == 0) {
            return;
        }
        
        if (!visited[row][col] && board[row][col] == 'O') {
            visited[row][col] = true;

            DFS(board, row+1, col, visited);
            DFS(board, row-1, col, visited);
            DFS(board, row, col+1, visited);
            DFS(board, row, col-1, visited);
        }
    }
}