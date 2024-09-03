import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        //자주 나오는 단어면 앞에 배치
        //길이가 길면 앞에 배치
        //알파벳 사전순으로 앞에 있는 단어일수록 앞에 배치
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 단어 개수
        int m = Integer.parseInt(st.nextToken()); // 이 길이 이상만 외움

        HashMap<String, Integer> wordList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() < m) continue;
            wordList.put(word, wordList.getOrDefault(word, 0) + 1); // wordList에 없으면 0 반환
        }

        PriorityQueue<String> pq = new PriorityQueue<>(getWordComparator(wordList));
        pq.addAll(wordList.keySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static Comparator<String> getWordComparator(HashMap<String, Integer> wordList) {
        return (a, b) -> {
            if (!wordList.get(a).equals(wordList.get(b)))
                return wordList.get(b) - wordList.get(a);

            if (a.length() != b.length())
                return b.length() - a.length();

            return a.compareTo(b);
        };
    }
}