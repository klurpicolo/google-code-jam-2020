package codeJam2021.qualification.moon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static void calCost(int testTase, Scanner sc){

        int x = sc.nextInt();
        int y = sc.nextInt();
        String mural = sc.nextLine().trim();

        int cost = 0;
        int lastCharPos = 0;

        for(int cur = 0; cur<mural.length()-1;cur++){
            char curChar = mural.charAt(cur);
            char nextChar = mural.charAt(cur+1);

            if(curChar=='?'){
                continue;
            } else {
                if(nextChar!='?'){
                    cost = cost + (mural.charAt(lastCharPos)=='C'?x:y);
                    lastCharPos = cur+1;
                }

            }
        }

        System.out.println("Case #" + testTase + ": " + cost);

    }


    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(new FileInputStream("D:/03_Temp/google-code-jam/src/codeJam2021/qualification/moon/test_data.txt"));
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
         int testCase = sc.nextInt();
        sc.nextLine();
        for (int testCount = 1; testCount<=testCase; testCount++){
            calCost(testCount, sc);
        }
    }

}
