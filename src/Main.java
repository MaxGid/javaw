import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter action: ");
        String input = reader.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        int num1;
        int num2;
        int answer;
        int answer2;
        int tens;
        char op;
        boolean roman;
        String answerRom;
        String operand1;
        String operand2;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IIX", 8);
        map.put("IX", 9);
        map.put("X", 10);
        String[] operands = input.split(" ");
        if (operands.length==3)
        {
            operand1 = operands[0];
            try {
                num1 = Integer.parseInt(operand1);
                if (num1 < 0 || num1 > 10) {
                    throw new Exception();
                }
                op = operands[1].charAt(0);
                operand2 = operands[2];
                num2 = Integer.parseInt(operand2);
                if (num2 < 0 || num2 > 10) {
                    throw new Exception();
                }
                roman = false;
            } catch (NumberFormatException e) {
                if (map.get(operand1)==null) {throw new Exception();} else {
                num1 = map.get(operand1);
                op = operands[1].charAt(0);
                operand2 = operands[2];
                if (map.get(operand2)==null) {throw new Exception();} else {
                num2 = map.get(operand2);
                roman = true;}}
            }
            switch (op) {
                case '+':
                    answer = num1 + num2;
                    break;
                case '-':
                    answer = num1 - num2;
                    break;
                case '*':
                    answer = num1 * num2;
                    break;
                case '/':
                    answer = num1 / num2;
                    break;
                default:
                    throw new Exception();
            }
            if (roman) {
                HashMap<Integer, String> map2 = new HashMap<>();
                map2.put(1, "I");
                map2.put(2, "II");
                map2.put(3, "III");
                map2.put(4, "IV");
                map2.put(5, "V");
                map2.put(6, "VI");
                map2.put(7, "VII");
                map2.put(8, "VIII");
                map2.put(9, "IX");
                map2.put(10, "X");
                map2.put(20, "XX");
                map2.put(30, "XXX");
                map2.put(40, "XL");
                map2.put(50, "L");
                map2.put(60, "LX");
                map2.put(70, "LXX");
                map2.put(80, "XXC");
                map2.put(90, "XC");
                map2.put(100, "C");
                if (answer < 1) {throw new IOException();}
                if (answer < 11) {
                    answerRom = map2.get(answer);
                    return (answerRom);
                }
                if (answer < 100) {
                    if (answer > 10) {
                        tens = answer / 10;
                        answer2 = answer % 10;
                        if (answer2 == 0) {
                            answerRom = map2.get(answer);
                            return (answerRom);
                        } else {
                            operand1 = map2.get(tens * 10);
                            operand2 = map2.get(answer2);
                            return (operand1 + operand2);
                        }
                    }
                }
            }
                return (Integer.toString(answer));
        } else {
            throw new Exception();
        }
    }
}
