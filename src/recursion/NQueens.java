package recursion;

public class NQueens {
    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board, 0));
    }

    static int queens(boolean[][] board, int row) {
        if(row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int cnt = 0;
        //place queen and check for every row and column
        for(int col = 0; col<board[0].length; col++) {
            //place queen if valid
            if(isValid(board, row, col)) {
                board[row][col] = true;
                cnt += queens(board, row+1);
                board[row][col] = false;
            }
        }

        return cnt;
    }

    private static boolean isValid(boolean[][] board, int row, int col) {
        //check vertical row
        for (int i = 0; i < row; i++) {
            if(board[i][col]) {
                return false;
            }
        }
        //diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <=maxLeft ; i++) {
            if(board[row-i][col-i]) {
                return false;
            }
        }
        //diagonal left
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <=maxRight ; i++) {
            if(board[row-i][col+i]) {
                return false;
            }
        }

        return  true;
    }

    private static void display(boolean[][] board) {
        for(boolean[] row : board) {
            for(boolean ele:row) {
                if(ele) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
