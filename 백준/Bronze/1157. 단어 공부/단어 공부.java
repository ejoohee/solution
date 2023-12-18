import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cnt = new int[26];

        String word = sc.next();
        word = word.toUpperCase();

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            cnt[ch-'A']++;
        }

        int max = 0;
        char result = '?';
        for(int i=0; i<cnt.length; i++){
            if(cnt[i]>max){
                max = cnt[i];
                result = (char)('A'+i);
            }else if (cnt[i]==max)
                result = '?';
        }

        System.out.println(result);
    }
}