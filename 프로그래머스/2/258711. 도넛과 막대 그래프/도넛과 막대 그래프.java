import java.util.*;

class Solution {
    
    //1개 이상의 정점과 정점들을 연결하는 단방향 간선
    //생성 정점 in 0 out > 1
    //도넛(모두)은 in >= 1 out = 1
    //막대(마지막)는 in >=1 out 0
    //8자(중간 정점) in >=2 out 2
    //출력 -> 정점 번호, 도넛, 막대, 8자 수
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, Integer> out = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        
        for(int[] edge : edges){
            out.put(edge[0], out.getOrDefault(edge[0],0)+1);
            in.put(edge[1], in.getOrDefault(edge[1],0)+1);
        }
        
        for(int node : out.keySet()){
            //나가는 건 두 개 이상이고
            if(out.get(node)>1){
                //들어오는게 없다면 정점
                if(!in.containsKey(node)){
                    answer[0] = node;
                }//아니면 8자
                else{
                    answer[3]++;
                }
            }
        }
        
        for(int node : in.keySet()){
            if(!out.containsKey(node)){
                answer[2]++;
            }
        }
        
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];
        return answer;
    }
}