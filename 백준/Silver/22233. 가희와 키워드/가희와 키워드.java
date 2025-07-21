import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); //가희가 메모장에 적은 키워드 개수
        int m = Integer.parseInt(st.nextToken()); //가희가 블로그에 쓴 글의 개수

        Set<String> keyword = new HashSet<>();

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            keyword.add(st.nextToken());
        }

        for (int i=0; i<m; i++){
            String[] blog = br.readLine().split(",");
            for (int j=0; j<blog.length; j++){
                keyword.remove(blog[j]);
            }
            sb.append(keyword.size());
            if (i!=m-1) sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
