import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        
        // 결과 계산
        int result = calculateMinimum(expression);
        System.out.println(result);
    }
    
    public static int calculateMinimum(String expression) {
        // '-' 기호를 기준으로 분리
        String[] splitByMinus = expression.split("-");
        
        // 첫 번째 항은 더하기만 포함된 항
        int result = sumParts(splitByMinus[0]);
        
        // 두 번째 항부터는 빼기
        for (int i = 1; i < splitByMinus.length; i++) {
            result -= sumParts(splitByMinus[i]);
        }
        
        return result;
    }
    
    // '+'로 구분된 부분의 합을 계산하는 함수
    private static int sumParts(String part) {
        int sum = 0;
        String[] numbers = part.split("\\+");
        
        for (String num : numbers) {
            if (!num.isEmpty()) {
                sum += Integer.parseInt(num);
            }
        }
        
        return sum;
    }
}