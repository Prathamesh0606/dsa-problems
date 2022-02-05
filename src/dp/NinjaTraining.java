package dp;

import java.util.Arrays;

//Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running,
//        Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve
//        all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum
//        merit points Ninja can earn?
//        You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task
//        is to calculate the maximum number of merit points that Ninja can earn.
public class NinjaTraining {
    public static void main(String[] args) {
        int[][] points = {{10,40,70},
                {20,50,80},
                {30,60,90}};


        int n = points.length;
        System.out.println(ninjaTraining(n, points));
    }
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int[][] dp = new int[n][4];
        for(int[]  i:dp)
            Arrays.fill(i, -1);
        return train(n-1, 3, points, dp);
    }

    //memoized approach
    static int train(int day, int last, int[][] points, int[][] dp) {
        if (dp[day][last] != -1) return dp[day][last];
        if(day == 0) {
            int maxi = 0;
            for(int i=0; i<3; i++) {
                if(i!=last) {
                    maxi = Math.max(maxi, points[day][i]);

                }
            }

            return dp[day][last] = maxi;
        }

        //if(dp[day][last]!= -1) return dp[day][last];
        int maxi = 0;
        for(int i=0; i<3; i++) {
            if(i!=last) {
                int pt = points[day][i] + train(day-1, i, points, dp);
                maxi = Math.max(maxi, pt);
            }
        }

        return dp[day][last] = maxi;
    }

}
