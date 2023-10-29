package ch15.sec06.exam01;

import ch08.sec10.exam1.C;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Coin> coins = new Stack<>();

        coins.push(new Coin(100));
        coins.push(new Coin(50));
        coins.push(new Coin(500));
        coins.push(new Coin(10));

        while (!coins.isEmpty()) {
            Coin pop = coins.pop();
            System.out.println("꺼낸 동전: " + pop.getValue() + "원");
        }
    }
}
