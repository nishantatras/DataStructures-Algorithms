public class NKNIGHTS {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        NKnights(board, 0,0,8);
    }

static void NKnights(boolean[][] board, int r,int c, int knights) {
    if (knights== 0) {
        display(board);
        System.out.println();
    }

    if(r==board.length-1 && c==board.length){
       return ;
    }
    if(c == board.length) {
        NKnights(board, r+1, 0, knights);
        return;
    }

    if(isSafe(board, r, c)){
         board[r][c]=true;
        NKnights(board, r, c+1, knights-1);
        board[r][c]=false;
    }
     
    NKnights(board, r, c+1, knights);
}

private static boolean isSafe(boolean[][] board, int r, int c) {
    if(isValid(board,r-2,c-1)){
    if(board[r-2][c-1]){
    return false;
    }
    }

     if(isValid(board,r-1,c-2)){
    if(board[r-1][c-2]){
    return false;
    }
    }

     if(isValid(board,r-2,c+1)){
    if(board[r-2][c+1]){
    return false;
    }
    }

    if(isValid(board,r-1,c+2)){
    if(board[r-1][c+2]){
    return false;
    }
    }
    return true;
}

static boolean isValid(boolean[][] board,int r,int c){
if(r>=0 && r<board.length &&c>=0 && c<board.length
){
   return true; 
}
   return false;
}

private static void display(boolean[][] board) {
    for (boolean[] r : board) {
        for (boolean elm : r) {
            if (elm) {
                System.out.print("O ");
            } else {
                System.out.print("X ");
            }
        }
        System.out.println();
    }
}
}
