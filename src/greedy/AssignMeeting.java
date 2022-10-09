package greedy;

import java.util.*;

class AssignMeeting {
    static Meeting[] meetings = {
            new Meeting(1,4),
            new Meeting(3,5),
            new Meeting(0,6),
            new Meeting(5,7),
            new Meeting(3,8),
            new Meeting(5,9),
            new Meeting(6,10),
            new Meeting(8,11),
            new Meeting(8,12),
            new Meeting(2,13),
            new Meeting(12,14)
    };

    public static void main(String[] args) {
        System.out.println(assign());
    }
    static int assign(){
        List<Meeting> selectedMeetings = new ArrayList<>();
        Arrays.sort(meetings);
        int idx = 0;
        Meeting selected = meetings[idx++];
        selectedMeetings.add(selected);
        while(idx<meetings.length){
            boolean check = false;
            for (int i = idx+1; i < meetings.length; i++) {
                if(meetings[i].start >= selected.end){
                    idx = i;
                    selected = meetings[i];
                    selectedMeetings.add(meetings[i]);
                    check = true;
                    break;
                }
            }
            if(! check) break;
        }
        selectedMeetings.forEach(System.out::println);
        return selectedMeetings.size();
    }
}
class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public int compareTo(Meeting o) {
        return this.end - o.end;
    }
}