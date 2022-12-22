package UI;

import java.util.Scanner;

public class InputUI {
    private static final Scanner sc = new Scanner(System.in);

    public static String getAnswerByUser(int length) {
        System.out.print("서로 다른 수로 이루어진 세자리 수를 입력해주세요 : ");
        String userInput = sc.next();
        while (userInput.length() != length || !isValidInput(userInput)) {
            System.out.print("\n올바르지 않은 입력입니다.\n" +
                    "서로 다른 수로 이루어진 세자리 수를 입력해주세요 : ");
            userInput = sc.next();
        }

        return userInput;
    }

    public static String getRestartFlag() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = sc.next();
        while (!userInput.equals("1") && !userInput.equals("2")) {
            System.out.println("올바르지 않은 입력입니다.\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userInput = sc.next();
        }
        return userInput;
    }

    private static boolean isValidInput(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            appendUniqueChar(sb, c);
        }

        return input.equals(sb.toString());
    }

    private static void appendUniqueChar(StringBuilder sb, char c) {
        if (!sb.toString().contains(String.valueOf(c)) && Character.isDigit(c)) {
            sb.append(c);
        }
    }
}
