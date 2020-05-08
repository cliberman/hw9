package edu.ti.caih313.hw9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UseHashMap {
    public static void main(String[] args) {
        Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();

        System.out.println("Enter numbers. Enter a negative number to stop: ");
        Scanner keyboard = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            Integer num = keyboard.nextInt();
            if (num < 0) {
                done = true;
            }
            else {
                if (numbers.containsKey(num)) {
                    Integer count = numbers.get(num);
                    numbers.put(num, ++ count);
                }
                else {
                    numbers.put(num, 1);
                }
            }
        }
        for (Integer i: numbers.keySet()) {
            System.out.println("The number " + i + " occurs " + numbers.get(i) + " times.");
        }
    }
}
