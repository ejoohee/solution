import java.util.Arrays;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.end == o.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetings[i] = new Meeting(start, end);
        }

        Arrays.sort(meetings); 
        int count = 0;
        int prevEndTime = 0;

        for (Meeting meeting : meetings) {
            if (meeting.start >= prevEndTime) {
                prevEndTime = meeting.end;
                count++;
            }
        }

        System.out.println(count); 
        sc.close(); 
    }
}