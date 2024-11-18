package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int number1;
    String operator;
    int number2;

    boolean isInputValid = false;
    while (!isInputValid) {
      try {
        System.out.print("1番目の数字を入力してください: ");
        number1 = scanner.nextInt();

        System.out.print("演算子を入力してください (+, -, *, /): ");
        operator = scanner.next();

        System.out.print("2番目の数字を入力してください: ");
        number2 = scanner.nextInt();

//        正常な入力の場合はループを抜ける
        isInputValid = true;

        int result = 0;
        boolean isCalculated = true; // 正常に計算されるかをチェック

        switch (operator) {
          case "+" -> result = number1 + number2;
          case "-" -> result = number1 - number2;
          case "*" -> result = number1 * number2;
          case "/" -> {
            if (number2 != 0) {
              result = number1 / number2;
            } else {
              System.out.println("0で割ることはできません");
              isCalculated = false;
            }
          }
          default -> isCalculated = false;
        }

        if (isCalculated) {
          System.out.println(" 計算結果: " + number1 + operator + number2 + "=" + result);
        } else {
          System.out.println("もう一度やり直してください");
          isInputValid = false;
        }

      } catch (InputMismatchException e) {
        System.out.println("不正な入力です");
        scanner.next();
      }
    }
  }
}