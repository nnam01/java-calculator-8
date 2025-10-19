package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.StringTokenizer;

public class Application {

    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        try {
            int result = addNumberInString(input);
            System.out.println("결과 : " + result);
        } catch (Throwable e) {
            throw new IllegalArgumentException("Error : " + e.getMessage());
        }
    }


    public static int addNumberInString(String input) {
        if (input.startsWith("//")) {
            int newLineIndex = input.indexOf("\\n");
            String customDelim = input.substring(2, newLineIndex);
            input = input.substring(newLineIndex + 2).replace(customDelim, ",");
        }

        if (input.trim().isEmpty()) {
            return 0;
        }

        if (input.contains("-")) {
            throw new Error("Not allowed negative number.");
        }

        StringTokenizer tokenizer = new StringTokenizer(input, ",:", false);
        int sum = 0;
        while (tokenizer.hasMoreTokens()) {
            sum += Integer.parseInt(tokenizer.nextToken());
        }
        return sum;
    }
}

