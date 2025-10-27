import java.util.*;

public class mergeIntervals {
    public static void main(String[] args) {

    }

    private class Solution {
        public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
            fill(intervals, newInterval);
            return intervals;
        }

        private void fill(ArrayList<Interval> intervals, Interval newInterval) {
            int start = newInterval.start;
            int end = newInterval.end;
            for (int i = 0; i < intervals.size(); i++) {
                Interval temp = intervals.get(i);
                int tempStart = temp.start;
                int tempEnd = temp.end;
                if (start >= tempEnd)
                    continue;
                // case-1 if the interval lies within tempinterval
                if (start >= tempStart && end <= tempEnd) {
                    return;
                } // case-2 if the interval's start lies within the tempInterval
                else if (start <= tempEnd) {
                    temp.end = end;
                    return;
                } // case - 3 if the interval's end lies in the interval
                else if (tempStart <= end) {
                    temp.start = start;
                }
            }
        }
    }

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

}
