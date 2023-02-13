import java.io.IOException;
import java.net.SocketOption;
import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        int num1;
        int num2;
        int answer;
        int answer2;
        int tens;
        char op;
        String operand1;
        String operand2;
        String answerRom;
        String wrong;
        boolean roman;
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
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter action: ");
        operand1 = reader.next();
        try {
            num1 = Integer.parseInt(operand1);
            if (num1<0||num1>10) {throw new IOException();}
            op = reader.next().charAt(0);
            operand2 = reader.next();
            num2 = Integer.parseInt(operand2);
            if (num2<0||num2>10) {throw new IOException();}
            roman = false;
         } catch (NumberFormatException e) {
            num1 = map.get(operand1);
            op = reader.next().charAt(0);
            operand2 = reader.next();
            num2 = map.get(operand2);
            roman = true;
        }
        wrong = reader.nextLine();
        if (wrong=="") {
        reader.close();
        switch(op) {
            case '+': answer = num1 + num2;
                break;
            case '-': answer = num1 - num2;
                break;
            case '*': answer = num1 * num2;
                break;
            case '/': answer = num1 / num2;
                break;
            default:  throw new IOException();
        }
        if (roman==true) {
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
            map2.put(80, "LXXX");
            map2.put(90, "XC");
            map2.put(100, "C");
            if (answer<1) {throw new IOException();}
            if (answer<11) {
                answerRom = map2.get(answer);
            System.out.println(answerRom);}
            if (answer<100) {
                if (answer > 10) {
                    tens = answer / 10;
                    answer2 = answer % 10;
                    if (answer2 == 0) {
                        answerRom = map2.get(answer);
                        System.out.print(answerRom);
                    } else {
                        operand1 = map2.get(tens * 10);
                        operand2 = map2.get(answer2);
                        System.out.println(operand1 + operand2);
                    }
                }
            }} else {System.out.print(answer);}
    }else {
           throw new IOException();
        }}
}