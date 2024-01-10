import java.util.*;

public class Main {
    //상근이가 필요한 나무가 m 미터
    // 땅부터 h 미터 위로 잘리니까 나무 키 - h 가 가져가는 길이
    //딱 필요한 만큼만 가져가고 싶은 m하고 같거나 큰 길이
    static int n, m, h, max;
    static int[] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt(); //필요한 나무 길이
        tree = new int[n];

        for (int i=0; i<n; i++){
            tree[i] = sc.nextInt();
            max = Math.max(tree[i], max);
        }

        int left =0;
        int right = max;

        while (left<=right){
            int mid = (left+right)/2;
            long total=0;

            for (int t : tree){
                if(t <= mid) continue;
                total+=(t - mid);
            }
            if(total>=m){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(left-1);
    }
}