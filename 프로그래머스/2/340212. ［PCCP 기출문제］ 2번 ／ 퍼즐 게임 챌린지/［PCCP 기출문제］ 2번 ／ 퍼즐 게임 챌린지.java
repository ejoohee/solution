class Solution {
    //n개의 퍼즐 제한 시간 내에 플어야함
    //난이도 소요시간 정해져 있음
    //내 숙련도에 따라 틀리는 횟수 바쓈
    //현재 퍼즐 난이도 diff, 현재 퍼즐 소요 시간 time_cur, 이전 퍼즐의 소요 시간 time_prev
    //숙련도 level
    
    public int solution(int[] diffs, int[] times, long limit) {
        
        int low = Integer.MAX_VALUE;
        int high = 0;
        
        for(int diff : diffs){
            high = Math.max(high, diff);
            low = Math.min(low, diff);
        }
        
        int level = high;
        
        
        //이진탐색 시작
        while(low <= high){
            int mid = (low+high)/2; //현재 탐색 중인 level
            long time = 0;
            int time_prev = 0; 
            
        for(int i=0; i<diffs.length; i++){
            int time_cur = times[i];
            if(diffs[i]<=mid){
                time += time_cur;
            }else {
                time+=(diffs[i]-mid)*(time_cur+time_prev)+time_cur;
            }
            time_prev = time_cur; //갱신
                
            //시간초과 체크
            if(time>limit) break;
        }
            
            //시간내에 풀 수 있다면 level 낮추기
            if(time<=limit){
                level = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
            
        
        return level;
    }
}