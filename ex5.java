import java.util.Arrays;

public class ex5 {
    public static int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
       for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int result = 0;
        int lastEndedIndex = 0;
        for (int i = 0; i < ends.length; i++) {
            if(starts[i] < ends[lastEndedIndex]) result++;
            else lastEndedIndex++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0,30},{5,10}, {15,20}};
        System.out.println(minMeetingRooms(intervals));
    }
}