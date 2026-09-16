// Surname: Mokhoantle
// Name: Mfundo
// Student no: 4549923
// Course: CSC212
// Year: 2026
// Assignment: Practical 1 Term 3
// File: Term3Prac1.java

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Term3Prac1 {

    // Algorithm 1
    public static void Algorithm1(int[] arr, PrintWriter output) {
        int pairs = 0;

        for (int i = 0; i < arr.length; i++) {

            int x = arr[i];

            if (x > 0) {
                boolean found = false;

                // Sequential search for -x
                for (int j = 0; j < arr.length; j++) {

                    if (arr[j] == -x) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    output.println(x + " and " + (-x) + " are in the array");
                    pairs++;
                }
            }
        }

        output.println();
        output.println("Number of pairs: " + pairs);
    }


    // Algorithm 2
    public static void Algorithm2(int[] arr, PrintWriter output) {
        int i = 0;
        int j = arr.length - 1;
        int pairs = 0;

        while (i < j) {

            int sum = arr[i] + arr[j];

            if (sum == 0) {
                output.println(arr[i] + " and " + arr[j] + " are in the array");
                pairs++;

                i++;
                j--;

            } else if (sum > 0) {
                j--;

            } else {
                i++;
            }
        }

        output.println();
        output.println("Number of pairs: " + pairs);
    }


    public static int[] generateRandomArray(int length, int min, int max) {
        return ThreadLocalRandom.current()
                .ints(length, min, max + 1)
                .toArray();
    }

    public static void runTimingExperiment() {

        int[] sizes = {400, 800, 1600, 3200, 6400, 12800, 25600, 51200};
        int trials = 15;
        PrintStream consoleOut = System.out;

        PrintStream nullStream = new PrintStream(new java.io.OutputStream() {
            public void write(int b) {
                // discard
            }
        });

        System.setOut(nullStream);

        for (int w = 0; w < 5; w++) {

            int[] warm = generateRandomArray(5000, -1000, 1000);
            Arrays.sort(warm);

            PrintWriter warmOutput = new PrintWriter(nullStream);

            Algorithm1(warm, warmOutput);
            Algorithm2(warm, warmOutput);

            warmOutput.flush();
        }

        System.setOut(consoleOut);

        consoleOut.println(
                "InputSize\tAlgorithm1_seconds\tAlgorithm2_seconds"
        );

        for (int n : sizes) {

            long min1 = Long.MAX_VALUE;
            long min2 = Long.MAX_VALUE;

            for (int t = 0; t < trials; t++) {

                int[] randomArray =
                        generateRandomArray(n, -1000, 1000);

                Arrays.sort(randomArray);

                System.setOut(nullStream);

                PrintWriter timingOutput =
                        new PrintWriter(nullStream);


                long start1 = System.nanoTime();

                Algorithm1(randomArray, timingOutput);

                long end1 = System.nanoTime();

                min1 = Math.min(min1, end1 - start1);


                long start2 = System.nanoTime();

                Algorithm2(randomArray, timingOutput);

                long end2 = System.nanoTime();

                min2 = Math.min(min2, end2 - start2);


                timingOutput.flush();

                System.setOut(consoleOut);
            }

            double time1 = min1 / 1e9;
            double time2 = min2 / 1e9;

            consoleOut.println(
                    n + "\t" + time1 + "\t" + time2
            );
        }

        nullStream.close();
    }

    public static void main(String[] args) {

        try {

            BufferedReader reader1 = new BufferedReader(
                    new FileReader(
                            "C:\\Users\\mokho\\OneDrive\\Desktop\\CSC 212 Practicals\\4549923_T3P1\\input1.txt"
                    )
            );

            String line1 = reader1.readLine();
            reader1.close();

            int[] arr1 = Arrays.stream(line1.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();


            PrintWriter output1 = new PrintWriter(
                    new FileWriter(
                            "C:\\Users\\mokho\\OneDrive\\Desktop\\CSC 212 Practicals\\4549923_T3P1\\output1.txt"
                    )
            );

            output1.println("ALGORITHM 1");
            output1.println("----------------");

            long startTime1 = System.nanoTime();

            Algorithm1(arr1, output1);

            long endTime1 = System.nanoTime();
            long elapsedTime1 = endTime1 - startTime1;

            output1.println();
            output1.println("ALGORITHM 2");
            output1.println("----------------");

            long startTime2 = System.nanoTime();

            Algorithm2(arr1, output1);

            long endTime2 = System.nanoTime();
            long elapsedTime2 = endTime2 - startTime2;

            output1.close();


            System.out.println("Input 1:");
            System.out.println("Algorithm 1 Runtime in nanoseconds: " + elapsedTime1);
            System.out.println("Algorithm 2 Runtime in nanoseconds: " + elapsedTime2);
            System.out.println("Algorithm 1 Runtime in seconds: " + (elapsedTime1 / 1e9));
            System.out.println("Algorithm 2 Runtime in seconds: " + (elapsedTime2 / 1e9));

            BufferedReader reader2 = new BufferedReader(
                    new FileReader(
                            "C:\\Users\\mokho\\OneDrive\\Desktop\\CSC 212 Practicals\\4549923_T3P1\\input2.txt"
                    )
            );

            String line2 = reader2.readLine();
            reader2.close();

            int[] arr2 = Arrays.stream(line2.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();


            PrintWriter output2 = new PrintWriter(
                    new FileWriter(
                            "C:\\Users\\mokho\\OneDrive\\Desktop\\CSC 212 Practicals\\4549923_T3P1\\output2.txt"
                    )
            );

            output2.println("ALGORITHM 1");
            output2.println("----------------");

            long startTime3 = System.nanoTime();

            Algorithm1(arr2, output2);

            long endTime3 = System.nanoTime();
            long elapsedTime3 = endTime3 - startTime3;

            output2.println();
            output2.println("ALGORITHM 2");
            output2.println("----------------");

            long startTime4 = System.nanoTime();

            Algorithm2(arr2, output2);

            long endTime4 = System.nanoTime();
            long elapsedTime4 = endTime4 - startTime4;

            output2.close();


            System.out.println();
            System.out.println("Input 2:");
            System.out.println("Algorithm 1 Runtime in nanoseconds: " + elapsedTime3);
            System.out.println("Algorithm 2 Runtime in nanoseconds: " + elapsedTime4);
            System.out.println("Algorithm 1 Runtime in seconds: " + (elapsedTime3 / 1e9));
            System.out.println("Algorithm 2 Runtime in seconds: " + (elapsedTime4 / 1e9));
            System.out.println();
            runTimingExperiment();

            int[] randomArray = generateRandomArray(2000, -1000, 1000);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}