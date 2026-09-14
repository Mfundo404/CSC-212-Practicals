// Surname: Mokhoantle
// Name: Mfundo
// Student no: 4549923
// Course: CSC212
// Year: 2026
// Assignment: Practical 1 Term 3
// File: Term3Prac1.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Term3Prac1 {

    //Algorithm 1
    public static void Algorithm1(int[] arr) {
        boolean found = false;
        int pair = 0;

        for(int i = 0; i<arr.length; i++){
            for (int j = i; j < arr.length; j++){
                int x = arr[i];
                int x2 = arr[j];
                if(x == -x2){
                    System.out.println( x + " and " + x2 + " are in the array");
                    pair ++;
                    found = true;
                    break;
                }
            }

        }
        System.out.println();
        System.out.println("Number of pairs: " + pair);
    }

    public static void Algorithm2(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        int pairs = 0;

        while (i!=j){
            if(arr[i] + arr[j] == 0){
                System.out.println( arr[i] + " and " + arr[j] + " are in the array.");
                pairs ++;
                break;
            }else {
                if (arr[i] + arr[j] > 0){
                    j -= 1;
                    i += 1;
                }
            }
        }


    }


    public static void main(String [] args){
        int[] array = {1,2,3,-2,4,-4};

        Algorithm1(array);
        Algorithm2(array);
    }
}

