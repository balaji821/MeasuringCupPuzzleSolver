package measuringPuzzle;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the capacity of measuring cup 1 : ");
        int c1 = sc.nextInt();
        System.out.print("Enter the capacity of measuring cup 2 : ");
        int c2 = sc.nextInt();
        System.out.print("Enter the capacity of measuring cup 3 : ");
        int c3 = sc.nextInt();

        State maxCapacity = new State(c1, c2, c3);

        System.out.print("Enter the quantity to measure : ");
        int toMeasure = sc.nextInt();

        System.out.println("Enter the initial quantity in measuring cup 1 : ");
        int q1 = sc.nextInt();
        System.out.println("Enter the initial quantity in measuring cup 2 : ");
        int q2 = sc.nextInt();
        System.out.println("Enter the initial quantity in measuring cup 3 : ");
        int q3 = sc.nextInt();

        State state = new State(q1, q2, q3);

        if(state.totalVolume < toMeasure) {
            System.out.println("Volume to measure is greater than given volume");
            System.exit(0);
        }

        Stack<State> steps = MeasuringPuzzle.solution(state, toMeasure, maxCapacity);
    }

}
