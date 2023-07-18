public class Sudoku {
    public static void main(String[] args) {
    int[][] board=new int[][]{
{3 ,0, 6, 5, 0, 8, 4, 0, 0},
{5, 2, 0, 0, 0, 0, 0, 0, 0},
{0 ,8 ,7 ,0 ,0 ,0 ,0 ,3, 1},
{0 ,0 ,3 ,0 ,1 ,0 ,0 ,8 ,0},
{9 ,0 ,0 ,8 ,6 ,3 ,0 ,0 ,5},
{0 ,5 ,0 ,0 ,9 ,0 ,6, 0 ,0},
{1 ,3 ,0 ,0 ,0 ,0 ,2 ,5, 0},
{0 ,0 ,0 ,0 ,0 ,0 ,0 ,7, 4},
{0 ,0 ,5 ,2 ,0 ,6 ,3, 0, 0}
    };
    if(SudokuSolve(board)){
    display(board);
    }
    else{
    System.out.println("Can't Solve");
    }
    }
    
    static boolean SudokuSolve(int[][] board) {
        int n=board.length;
        int r=-1;
        int c=-1;
    
    boolean emptyleft=true;
    for(int i=0; i<n; i++){
    for(int j=0; j<n; j++){
    if(board[i][j]==0){
    r=i;
    c=j;
    emptyleft=false;
    break;
    }
    }
    if(emptyleft==false){
    break;
    }
    }
    if(emptyleft==true){
    return true;
    }

    for(int num=1; num<=9; num++){
    if(isSafe(board,r,c,num)){
       board[r][c]=num;
       if(SudokuSolve(board)){

       return true;
       }
       else{
       board[r][c]=0;
       }
    }
    }
    return false;
    }

    private static boolean isSafe(int[][] board, int r, int c,int n) {
        for (int i = 0; i < board.length; i++) {
            if (board[r][i]== n) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][c]==n) {
                return false;
            }
        }

        int sqrt=(int)(Math.sqrt(board.length));
        int rs=r-r%sqrt;
        int cs=c-c%sqrt;

        for(int row=rs; row<rs+sqrt; row++){
           for(int col=cs; col<cs+sqrt; col++){
            if(board[row][col]==n){
            return false;
            }
           }
        }
        return true;
    }

    private static void display(int[][] board) {
        for (int[] r : board) {
            for (int num : r) {
            System.out.print(num+" ");
            }
            System.out.println();
        }
    }

}
