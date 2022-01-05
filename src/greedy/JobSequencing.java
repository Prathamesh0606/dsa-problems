package greedy;

import java.util.Arrays;

import static java.util.Arrays.*;

public class JobSequencing {

    static class Job {
        int profit;
        int deadline;
        int id;

        public Job(int profit, int deadline, int id) {
            this.profit = profit;
            this.deadline = deadline;
            this.id = id;
        }
    }

    public static void main(String[] args) {
       // int N = 4;
        //Job[] Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)};
    }
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        sort(arr, (a, b)->(b.profit - a.profit));
        int maxi = 0;
        int sum = 0;

        for(int i=0; i<n; i++) {
            if(arr[i].deadline > maxi) maxi = arr[i].deadline;
        }

        int[] ans = new int[maxi+1];
        int cnt = 0;

        for(int i=1; i<=maxi; i++) {
            ans[i] = -1;
        }

        for(int i=0; i<n; i++) {
            for(int j = arr[i].deadline; j>0; j--) {

                if(ans[j] == -1) {
                    cnt++;
                    sum+=arr[i].profit;
                    ans[j] = i;
                    break;

                }
            }
        }

        int[] ar = new int[2];
        ar[0] = cnt;
        ar[1] = sum;

        return ar;
    }
}
