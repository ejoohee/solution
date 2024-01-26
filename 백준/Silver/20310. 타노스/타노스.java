import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<Character> list = new ArrayList<>();

        for (char c : str.toCharArray()){
            list.add(c);
        }

        int cnt0 = Collections.frequency(list,'0')/2;
        int cnt1 = Collections.frequency(list,'1')/2;

        for (int i=0; i<cnt1; i++){
            list.remove(list.indexOf('1'));
        }

        for (int i = list.size() - 1; i >= 0 && cnt0 > 0; i--) {
            if (list.get(i) == '0') {
                list.remove(i);
                cnt0--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : list){
            sb.append(c);
        }

        System.out.println(sb);
    }
}