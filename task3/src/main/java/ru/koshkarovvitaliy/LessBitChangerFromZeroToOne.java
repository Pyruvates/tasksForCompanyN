package ru.koshkarovvitaliy;
/*
 * Created by Koshkarov Vitaliy on 27.01.2020
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LessBitChangerFromZeroToOne {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите целое число");

            int number = Integer.parseInt(reader.readLine());
            System.out.println("Число перед заменой младшего бита: " + number);

            int result = changeLessBitFromZeroToOne(number);
            System.out.println(result);

            System.out.println("------------------------------------");
            new LessBitChangerFromZeroToOne().printBinary(number, 32);
            new LessBitChangerFromZeroToOne().printBinary(result, 32);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Некорректный ввод. Введите целое число");
        }
    }

    public static int changeLessBitFromZeroToOne(int number) {
        int localNumber = number;
        String changeableNumber = Integer.toBinaryString(localNumber);

        if (changeableNumber.charAt(changeableNumber.length() - 1) == '0') {
            number = number ^ 1;
            System.out.println("Число после замены младшего бита: " + number);

            String result = Integer.toString(number, 10);
            return Integer.parseInt(result);
        }

        return localNumber;
    }

    private void printBinary(long value, int size) {
        System.out.print("Число " + value + " в двоичном формате имеет вид: ");
        for (int i = size - 1; i >= 0; i--) {
            long mask = 1L << i;
            long result = (mask & value) >> i;
            System.out.print(result);
        }
        System.out.println();
    }
}
