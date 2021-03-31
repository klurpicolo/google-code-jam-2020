package codeJam2021.qualification.moon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//4
//2 3 CJ?CC?
//4 2 CJCJ
//1 3 C?J
//2 5 ??J???

public class Moons {

    private static void calCost(int testTase, Scanner sc){

        int x = sc.nextInt();
        int y = sc.nextInt();
        String mural = sc.nextLine().trim();

        int cost = 0;
        int lastCharPos = 0;

        for(int cur = 0; cur<mural.length()-1;cur++){
            char curChar = mural.charAt(cur);
            char nextChar = mural.charAt(cur+1);

            if(nextChar=='?'){
                continue;
            } else {
//                if(curChar!=nextChar && mural.charAt(lastCharPos)!='?'){
                    if(mural.charAt(lastCharPos)!=nextChar && mural.charAt(lastCharPos)!='?'){
                    cost = cost + (mural.charAt(lastCharPos)=='C'?x:y);
                }

                lastCharPos = cur+1;

            }
        }

        System.out.println("Case #" + testTase + ": " + cost);

    }


    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner sc = new Scanner(new FileInputStream("D:/03_Temp/google-code-jam/src/codeJam2021/qualification/moon/test_data.txt"));
        int testCase = sc.nextInt();
        sc.nextLine();
        for (int testCount = 1; testCount<=testCase; testCount++){
            calCost(testCount, sc);
        }
    }

}
