
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Backtracking {
   
    static int countpaths(int r,int c){
    if(r==1||c==1){
    return 1;
    }
    int left=countpaths(r-1, c);
    int right=countpaths(r, c-1);
    return left+right;
}

static void printpaths(int r, int c,String p) {
    if (r == 1 && c == 1) {
    System.out.println(p);
    return;
    }
    if(r>1){
    printpaths(r - 1, c,p+"D");
    }
    if(c>1){
    printpaths(r, c - 1,p+"R");
    }
}

static List<String> Retpaths(int r, int c, String p) {
    if (r == 1 && c == 1) {
    List<String> list=new ArrayList<String>();
    list.add(p);
    return list;
    }

    List<String> res=new ArrayList<String>();

    if (r > 1) {
    res.addAll(Retpaths(r - 1, c, p + "D"));
    }
    if (c > 1) {
    res.addAll(Retpaths(r, c - 1, p + "R"));
    }
    return res;
}

static List<String> RetDiagpaths(int r, int c, String p) {
    if (r == 1 && c == 1) {
        List<String> list = new ArrayList<String>();
        list.add(p);
        return list;
    }

    List<String> res = new ArrayList<String>();

    if (r > 1) {
        res.addAll(RetDiagpaths(r - 1, c, p + "D"));
    }
    if (c > 1) {
        res.addAll(RetDiagpaths(r, c - 1, p + "R"));
    }
    if(c>1&&r>1){
        res.addAll(RetDiagpaths(r-1, c - 1, p + "T"));
    }
    return res;
}

//paths without obstacles in a maze
static List<String> easyPaths(int r, int c, String p,boolean[][] mat) {
    if (r == mat.length-1 && c == mat[0].length-1) {
        List<String> list = new ArrayList<String>();
        list.add(p);
        return list;
    }

    List<String> res = new ArrayList<String>();
   
    if(mat[r][c]==false){ 
    return res;
    }
    if (r <mat.length-1) {
        res.addAll(easyPaths(r + 1, c, p + "D",mat));
    }
    if (c < mat[0].length-1) {
        res.addAll(easyPaths(r, c + 1, p + "R",mat));
    }
    return res;
}

static List<String> AllPaths(int r, int c, String p, boolean[][] mat) {
    if (r == mat.length - 1 && c == mat[0].length - 1) {
        List<String> list = new ArrayList<String>();
        list.add(p);
        return list;
    }

    List<String> res = new ArrayList<String>();

    if (mat[r][c] == false) {
        return res;
    }

    mat[r][c]=false;

    if (r < mat.length - 1) {
        res.addAll(AllPaths(r + 1, c, p + "D", mat));
    }
    if (c < mat[0].length - 1) {
        res.addAll(AllPaths(r, c + 1, p + "R", mat));
    }
    if (r >0) {
        res.addAll(AllPaths(r - 1, c, p + "U", mat));
    }
    if (c >0) {
        res.addAll(AllPaths(r, c - 1, p + "L", mat));
    }
    
    mat[r][c]=true;

    return res;
}

static void PrintAllPaths(int r, int c, String p, boolean[][] mat,int[][] path,int step) {
    if (r == mat.length - 1 && c == mat[0].length - 1) {
    path[r][c]=step;
     for(int[] arr:path){
    System.out.println(Arrays.toString(arr));
    }
    System.out.println(p);
    System.out.println();
     return;
    }

    if (mat[r][c] == false) {
        return;
    }

    mat[r][c] = false;
    path[r][c]=step;
    if (r < mat.length - 1) {
        PrintAllPaths(r + 1, c, p + "D", mat,path,step+1);
    }
    if (c < mat[0].length - 1) {
        PrintAllPaths(r, c + 1, p + "R", mat,path,step+1);
    }
    if (r > 0) {
        PrintAllPaths(r - 1, c, p + "U", mat,path,step+1);
    }
    if (c > 0) {
        PrintAllPaths(r, c - 1, p + "L", mat,path,step+1);
    }

    mat[r][c] = true;
    path[r][c]=0;
}

    public static void main(String[] args) {
    // System.out.println(countpaths(3, 5));
    // printpaths(3, 3, "");
    
    // System.out.println(Retpaths(3, 3, ""));
    
    // System.out.println(RetDiagpaths(3, 3, ""));

    // boolean[][] mat={{true,true,true},{true,true,true},{true,true,true}};
 
    // int path[][]=new int[mat.length][mat[0].length];
    // // // System.out.println(easyPaths(0, 0,"",mat));

    // // System.out.println(AllPaths(0, 0, "", mat));

    // PrintAllPaths(0, 0, " ",mat, path, 1);
    }
}
 