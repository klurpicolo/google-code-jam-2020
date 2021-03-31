package codeJam2021.qualification.reversort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static int cost = 0;

    private static void solve(int caseNumber, Scanner input){
        int n = input.nextInt();
        List<Integer> inputArray = new ArrayList<>();
        for (int i = 0; i < n; i++){
            inputArray.add(input.nextInt());
        }
        reversort(inputArray);
        System.out.println("Case #" + caseNumber + ": " + cost);
        cost = 0;

    }

    private static void reversort(List<Integer> inputArray){
        int j;
        int initSize = inputArray.size();
        for (int i = 1; i < initSize; i++){
            j = findMinIndex(i, inputArray);
            reverse(i, j, inputArray);
            cost = cost + (j - i + 1);
        }
    }

    private static int findMinIndex(int start, List<Integer> list){
        int minPos = 0;
        int minVal = Integer.MAX_VALUE;
        for (int i = start-1; i < list.size(); i++) {
            int val = list.get(i);
            if (val < minVal) {
                minPos = i;
                minVal = val;
            }
        }
        return minPos+1;
    }

    private static void reverse(int i, int j, List<Integer> list){
        List<Integer> reList = list.subList(i-1, j);
        Collections.reverse(reList);
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCase = sc.nextInt();
        for (int testCount = 1; testCount<=testCase;testCount++){
            solve(testCount, sc);
        }
    }
}
