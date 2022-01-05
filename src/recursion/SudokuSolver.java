package recursion;

public class SudokuSolver {
    public static void main(String[] args) {
//         int[][] board = {
//                {9,0,0,1,0,0,0,0,5},
//                {0,0,5,0,9,0,2,0,1},
//                {8,0,0,0,4,0,0,0,0},
//                {0,0,0,0,8,0,0,0,0},
//                {0,0,0,7,0,0,0,0,0},
//                {0,0,0,0,2,6,0,0,9},
//                {2,0,0,3,0,0,0,0,6},
//                {0,0,0,2,0,0,9,0,0},
//                {0,0,1,9,0,4,5,7,0},
//        };

        int[][] board = {{5,3,0,0,7,0,0,0,0}
,{6,0,0,1,9,5,0,0,0}
,{0,9,8,0,0,0,0,6,0}
,{8,0,0,0,6,0,0,0,3}
,{4,0,0,8,0,3,0,0,1}
,{7,0,0,0,2,0,0,0,6}
,{0,6,0,0,0,0,2,8,0}
,{0,0,0,4,1,9,0,0,5}
,{0,0,0,0,8,0,0,7,9}};


        if(solve(board)) display(board);
    }

    static boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 0) {
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }

            //if we found empty element in row, break
            if (!emptyLeft) {
                break;
            }




        }
        if(emptyLeft) return true;

        //backtrack
        for(int num = 1; num<=9; num++) {
            if(isSafe(board, row, col, num)) {
                board[row][col] = num;

                if(solve(board)) {
                    //display(board);
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;

    }

    private static void display(int[][] board) {
        for (int[] row:board) {
            for (int col:row) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board, int row, int col, int num) {
        //row check
        for (int i=0; i< board.length; i++) {
            if (board[row][i]== num) return false;

        }

        for (int[] nums :board) {
            if(nums[col] == num) return false;

        }

        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row%sqrt;
        int colStart = col - col% sqrt;

        for (int i = rowStart; i < rowStart+sqrt; i++) {
            for (int j = colStart; j <colStart+sqrt ; j++) {
                if(board[i][j] == num) return false;
            }
        }

        return true;
    }
}
