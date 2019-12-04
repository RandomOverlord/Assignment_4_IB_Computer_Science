package sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Methods {
    public static String[][] populate() {
        String csvFilePath = "C:\\Users\\Abhay\\IdeaProjects\\JavaFX\\src\\sample\\Dictionary.csv";
        BufferedReader br = null;
        String line;
        String split = ",";
        String[] buffer = new String[2];
        String[][] dictionary = new String[2][50];
        int count = 0;
        try {
            br = new BufferedReader(new FileReader(csvFilePath));
            while((line = br.readLine())!= null) {
                if(count != 50) {
                    buffer = line.split(split);
                    dictionary[0][count] = buffer[0];
                    dictionary[1][count] = buffer[1];
                    count++;
                } else {
                    return dictionary;
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e);
        } catch(IOException e) {
            System.out.println("IOException: " + e);
        }
        return dictionary;
    }

    public static String[][] Sort(String[][] input) {
        String temp;
        String[][] output = new String[2][50];
        output[0] = input[0].clone();
        output[1] = input[1].clone();
        for(int i = 0; i < 49; i++) {
            for(int j = i+1; j < 50; j++) {
                if((output[0][i].compareTo(output[0][j])) > 0) {
                    temp = output[0][i];
                    output[0][i] = output[0][j];
                    output[0][j] = temp;
                    temp = output[1][i];
                    output[1][i] = output[1][j];
                    output[1][j] = temp;
                }
            }
        }
        return output;
    }

    public static int SeqSearch(String[][] input, String a) {
        int ans = 0;
        for(int i = 0; i < input[0].length; i++) {
            if(a.equals(input[0][i])) {
                ans = i;
            }
        }
        return ans;
    }

    public static int[] BinSearch(String[][] input, String a) {
        int l = 0;
        int r = input[0].length - 1;
        int count = 0;
        int m = 0;
        while (l <= r) {
            count++;
            m = (l + r) / 2;
            int res = input[0][m].compareTo(a);
            if (res > 0){
                r = m - 1;
            }
            if (res < 0){
                l = m + 1;
            }
            if (input[0][m].equals(a)) {
                int[] send = {m, count};
                return send;
            }
        }
        int[] send = {m, count};
        return send;
    }
}