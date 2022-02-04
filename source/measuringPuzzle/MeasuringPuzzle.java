package measuringPuzzle;

import java.util.ArrayList;
import java.util.Stack;

public class MeasuringPuzzle {

    static Stack<State> iterations = new Stack<>();
    static ArrayList<State> allStates = new ArrayList<>();
    static int[][] possibleTransfers = {{0,1},{0,2},{1,0},{1,2},{2,0},{2,1}};

    public static void printStack(Stack<State> s) {

        for (State state : s) {
            System.out.println(state);
        }

    }

    public static Stack<State> solution(State s,int toMeasure,State maxCapacity){

        iterations.push(s);
        allStates.add(s);
        return solution1(s,toMeasure,maxCapacity);
    }
    private static Stack<State> solution1(State s, int toMeasure, State maxCapacity){

        if(s.has(toMeasure)) {
            printStack(iterations);
            return iterations;
        }

        ArrayList<State> resultStates = new ArrayList<>();

        for (int[] possibleTransfer : possibleTransfers) {

            State newState = s.transfer(possibleTransfer[0], possibleTransfer[1], maxCapacity);
            if (newState == null) {
                continue;
            }
            if (!allStates.contains(newState)) {
                allStates.add(newState);
                if (newState.has(toMeasure)) {
                    iterations.push(newState);
                    printStack(iterations);
                    System.exit(0);
                }
                resultStates.add(newState);
            }
        }

        for (State t : resultStates) {
            iterations.push(t);
            solution1(t, toMeasure, maxCapacity);
            iterations.pop();
        }
        return null;
    }
}
