public class NQUEEN {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(Nqueens(board, 0));  
    }


static int Nqueens(boolean[][] board, int r) {
    if (r == board.length) {
        display(board);
        System.out.println();
        return 1;
    }
    int count = 0;
    for (int c = 0; c < board.length; c++) {
        if (isSafe(board, r, c)) {
            board[r][c] = true;
            count += Nqueens(board, r + 1);
            board[r][c] = false;
        }
    }
    return count;
}

private static boolean isSafe(boolean[][] board, int r, int c) {
    for (int i = 0; i < r; i++) {
        if (board[i][c]) {
            return false;
        }
    }

    int maxl = Math.min(r, c);
    for (int i = 1; i <= maxl; i++) {
        if (board[r - i][c - i]) {
            return false;
        }
    }

    int maxr = Math.min(r, board.length - c - 1);
    for (int i = 1; i <= maxr; i++) {
        if (board[r - i][c + i]) {
            return false;
        }
    }
    return true;
}

private static void display(boolean[][] board) {
    for (boolean[] r : board) {
        for (boolean elm : r) {
            if (elm) {
                System.out.print("Q ");
            } else {
                System.out.print("X ");
            }
        }
        System.out.println();
    }
}
}
