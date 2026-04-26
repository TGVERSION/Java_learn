package Timus;

import java.util.*;

public class Task_1002 {

    static Map<Character, Character> charToDigit = new HashMap<>();

    static {
        String[] mapping = {"oqz", "ij", "abc", "def", "gh", "kl", "mn", "prs", "tuv", "wxy"};
        for (int d = 0; d < 10; d++) {
            for (char c : mapping[d].toCharArray()) {
                charToDigit.put(c, (char) ('0' + d));
            }
        }
    }

    static String wordToDigits(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(charToDigit.get(c));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String phone = scanner.nextLine().trim();
            if (phone.equals("-1")) break;

            int n = Integer.parseInt(scanner.nextLine().trim());

            // Храним одно слово на каждую уникальную цифровую последовательность
            Map<String, String> digitToWord = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String word = scanner.nextLine().trim();
                String digits = wordToDigits(word);
                digitToWord.putIfAbsent(digits, word);
            }

            int len = phone.length();

            // dp[i] = минимальное кол-во слов для покрытия phone[0..i-1]
            int[] dp = new int[len + 1];
            int[] prev = new int[len + 1];
            String[] wordUsed = new String[len + 1];

            Arrays.fill(dp, Integer.MAX_VALUE);
            Arrays.fill(prev, -1);
            dp[0] = 0;

            for (int i = 0; i < len; i++) {
                if (dp[i] == Integer.MAX_VALUE) continue;

                for (Map.Entry<String, String> entry : digitToWord.entrySet()) {
                    String digits = entry.getKey();
                    int end = i + digits.length();

                    if (end <= len && phone.startsWith(digits, i)) {
                        if (dp[i] + 1 < dp[end]) {
                            dp[end] = dp[i] + 1;
                            prev[end] = i;
                            wordUsed[end] = entry.getValue();
                        }
                    }
                }
            }

            if (dp[len] == Integer.MAX_VALUE) {
                System.out.println("No solution.");
            } else {
                List<String> result = new ArrayList<>();
                int pos = len;
                while (pos > 0) {
                    result.add(wordUsed[pos]);
                    pos = prev[pos];
                }
                Collections.reverse(result);
                System.out.println(String.join(" ", result));
            }
        }
    }
}
