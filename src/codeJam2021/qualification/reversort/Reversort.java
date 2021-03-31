package codeJam2021.qualification.reversort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

//Test data
//3
//4
//4 2 1 3
//2
//1 2
//7
//7 6 5 4 3 2 1

public class Reversort {

    private static int cost = 0;

    private static void solve(int caseNumber, Scanner input){
        int n = input.nextInt();
//        System.out.println("N of case : " + n);
        List<Integer> inputArray = new ArrayList<>();
        for (int i = 0; i < n; i++){
            inputArray.add(input.nextInt());
        }
//        System.out.println("array of case : " + inputArray.toString());
        reversort(inputArray);
        System.out.println("Case #" + caseNumber + ": " + cost);
        cost = 0;

    }

    private static void reversort(List<Integer> inputArray){
        int j;
        int initSize = inputArray.size();
        for (int i = 1; i < initSize; i++){
            j = findMinIndex(i, inputArray);
//            System.out.println("i : " + i + ", j : " + j);
            reverse(i, j, inputArray);

            cost = cost + (j - i + 1);
//            System.out.println("cost is : " + cost);

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
//        for(int k =i; k <= j; k++){
//            list.set(k, reList.get(k-i) );
//        }
//        System.out.println("sorted is : " + list);
    }



    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner sc = new Scanner(new FileInputStream("D:/03_Temp/google-code-jam/src/codeJam2021/qualification/test_data.txt"));
        int testCase = sc.nextInt();
        for (int testCount = 1; testCount<=testCase;testCount++){
            solve(testCount, sc);
        }
    }
}
