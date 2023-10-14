import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] map, visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        map = new int[r][c];
        visited = new int[r][c];
        Queue<Node> jq = new LinkedList<>();
        Queue<Node> fq = new LinkedList<>();
        for(int i=0; i<r; i++){
            String t = sc.next();
            for(int j=0; j<c; j++){
                char temp = t.charAt(j);
                if(temp=='#'){
                    map[i][j] = -1;
                }
                else if (temp=='J'){
                    map[i][j] = 1;
                    jq.add(new Node(i,j));
                }
                else if(temp == 'F'){
                    map[i][j] = -2;
                    fq.add(new Node(i, j));
                }
                else{
                    map[i][j] = 0;
                }
            }
        }
        int answer = 0;
        while(true){
            answer++;
            int fs  = fq.size();
            while(fs>0){
                fs--;
                Node node = fq.poll();
                int y = node.y;
                int x = node.x;
                for(int i=0; i<4; i++){
                    if (x+dx[i] >= 0 && x+dx[i] < c && y+dy[i]> 0 && y+dy[i] < r){
                        if(map[y+dy[i]][x+dx[i]] >=0){
                            fq.add(new Node(y+dy[i], x+dx[i]));
                            map[y+dy[i]][x+dx[i]] = -2;
                        }
                    }
                }
            }
            int js = jq.size();
            while(js>0){
                js--;
                Node node = jq.poll();
                int y = node.y;
                int x = node.x;
                for(int i=0; i<4; i++){
                    if (x+dx[i] < 0 || x+dx[i] >= c || y+dy[i]< 0 || y+dy[i] >= r){
                        System.out.println(answer);
                        return;
                    }
                    if(map[y+dy[i]][x+dx[i]] ==0){
                        jq.add(new Node(y+dy[i], x+dx[i]));
                        map[y+dy[i]][x+dx[i]] = 1;
                    }
                }
            }
            if(jq.isEmpty()){
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }
}

class Node{
    int x,y;

    public Node(int y, int x ){
        this.x = x;
        this.y = y;
    }
}