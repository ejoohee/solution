import java.util.*;

public class Main {
    //랭킹전 기능
    //플레이어 입장 -> 매칭 x -> 새로운 방 생성 및 입장
    //-> 방장 기준으로 -10 +10까지 입장 가능
    //입장 가능하다면 입장 시킨 후 방의 정원이 모두 찰 때까지 대기
    //입장 가능한 것 중에 먼저 생성된 방에 입장
    //플레이어 수 p 닉네임 n 레벨 l 정원 m
    static ArrayList<ArrayList<String[]>> players;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        players = new ArrayList<>();
        int p = sc.nextInt();
        int m = sc.nextInt();

        for (int i=0; i<p; i++){
            int l = sc.nextInt(); //레벨
            String n = sc.next(); //닉네임
            boolean flag = false;

            for (int j=0; j<players.size(); j++){
                String[] host = players.get(j).get(0);
                int max = Integer.parseInt(host[0])+10;
                int min = Integer.parseInt(host[0])-10;
                if(l>=min&&l<=max){
                    //정원 안 차있으면 입장 가능
                    if(players.get(j).size()<m){
                        players.get(j).add(new String[]{""+l,n});
                        //방 입장했음
                        flag = true;
                        break;
                    }
                }
            }
            //갈 곳이 없으면 방장으로 추가
            if (!flag) {
                ArrayList<String[]> newRoom = new ArrayList<>();
                newRoom.add(new String[]{""+l,n});
                players.add(newRoom);
            }
        }


        // 결과 출력
        for (ArrayList<String[]> room : players) {
            if (room.size() == m) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            Collections.sort(room, new Comparator<String[]>(){
                @Override
                public int compare(String[] p1, String[] p2) {
                    return p1[1].compareTo(p2[1]);
                }
            });

            for (String[] player : room) {
                System.out.println(player[0] + " " + player[1]);
            }
        }
    }
}