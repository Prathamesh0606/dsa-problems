package recursion;

public class Pattern1 {
    public static void main(String[] args) {
        pattern2(5,0);
    }

    //print
//    * * * * *
//    * * * *
//    * * *
//    * *
//    *
    static void pattern1(int r, int currCol) {
        if(r==0)  return;
        if(currCol == r) {
            System.out.println();
            pattern1(r-1, 0);

        } else {
            System.out.print("* ");
            pattern1(r, currCol+1);
        }
    }


//            *
//            * *
//            * * *
//            * * * *
//            * * * * *

    static void pattern2(int r, int currCol) {
        if(r==0)  return;
        if(currCol == r) {
            pattern2(r-1, 0);
            System.out.println();
        } else {
            pattern2(r, currCol+1);
            System.out.print("* ");
        }
    }
}
