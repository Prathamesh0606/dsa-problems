package greedy;


import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    static class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    static class Com implements Comparator<Item> {
        @Override
        public int compare(Item a, Item b) {
            double r1 = (double) a.value / (double) a.weight;
            double r2 = (double) b.value / (double) b.weight;

            if(r2 > r1) return 1;
            else if(r1 > r2) return -1;

            return 0;
        }
    }

    double fractionalKnapsack(int W, Item arr[], int n)
    {
        // Your code here
        Com c = new Com();
        Arrays.sort(arr, c);
        double profit = 0.0;

        for(int i=0; i<n; i++) {
            if(arr[i].weight <= W) {
                W-=arr[i].weight;
                profit+=arr[i].value;
            }
            else {
                double frac = (double) arr[i].value / (double) arr[i].weight;
                profit+=frac * W;
                W = 0;

            }
        }

        return profit;
    }
}
