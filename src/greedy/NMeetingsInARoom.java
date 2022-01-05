package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NMeetingsInARoom {

    public static void main(String[] args) {
        int N = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] =  {2,4,6,7,9,9};

        System.out.println(maxMeetings(start, end, N));
    }

    static class Meeting {
        public int start;
        public int end;
        public int pos;

        public Meeting(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.pos = p;
        }
    }

    static class Comp implements Comparator<Meeting> {
        @Override
        public int compare(Meeting o1, Meeting o2) {
            if(o1.end < o2.end) return -1;
            else if(o1.end > o2.end) return 1;
            else if(o1.pos < o2.pos) return -1;

            return 1;
        }
    }
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<Meeting> meet = new ArrayList<>();

        for(int i=0; i<start.length; i++) {
            Meeting m = new Meeting(start[i], end[i], i+1);
            meet.add(m);
        }

        Comp c = new Comp();

        Collections.sort(meet, c);

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(meet.get(0).pos);
        int limit = meet.get(0).end;

        for(int i=1; i<start.length; i++) {
            if(meet.get(i).start > limit) {
                limit = meet.get(i).end;

                ans.add(meet.get(i).pos);
            }
        }
        return ans.size();


    }
}
