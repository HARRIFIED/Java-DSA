/**
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

    ** Connect: A cell is connected to adjacent cells horizontally or vertically.
    ** Region: To form a region connect every 'O' cell.
    ** Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
    ** To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
   
    Example 1:
    Input: board = [
        ["X","X","X","X"],
        ["X","O","O","X"],
        ["X","X","O","X"],
        ["X","O","X","X"]
    ]
    Output: [
        ["X","X","X","X"],
        ["X","X","X","X"],
        ["X","X","X","X"],
        ["X","O","X","X"]
    ]
    
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */

public class SurroundedRegion {
    public char[][] solution(char[][] board) {
        if (board == null || board[0].length == 0) return board;
        int row = board.length;
        int col = board[0].length;

        //explore both vertical edges
        for (int r = 0; r < row; r++) {
            explore(board, r, 0);
            explore(board, r, col - 1);
        }

        //explore both horizontal edges
        for (int c = 0; c < col; c++) {
            explore(board, 0, c);
            explore(board, row - 1, c);
        }

        // now explore all. return safe land (S) -> O and O -> X
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 'S') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
        return board;
    }

    private void explore(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') return;

        board[r][c] = 'S'; //mark land as safe

        //explore connected areas
        explore(board, r - 1, c);
        explore(board, r + 1, c);
        explore(board, r, c - 1);
        explore(board, r, c + 1);
    }
}
