import java.util.*;

public class Main {
    //n개의 랜선을 만들어야함
    //k개의 랜선은 가지고 있음 크기 제각각
    //n개의 최대 랜선길이 ?
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] kList = new int[k];
        long l = 1;
        long r = 0;
        long ml;
        for(int i = 0; i < k; i++){
            kList[i] = sc.nextInt();
            r = Math.max(r, kList[i]);
        }

        while(l <= r){
            ml = (r+l) / 2;
            long cnt = 0;
            for(int j = 0; j < k; j++){
                cnt += kList[j]/ml;
            }

            if(cnt>=n){
                l = ml + 1;
            }else{
                r = ml - 1;
            }
        }

        System.out.println(r);
    }
}