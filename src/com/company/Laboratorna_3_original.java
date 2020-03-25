package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Laboratorna_3_original {

    public static void main(String[] args) throws FileNotFoundException {
        HashFunc<String, String>  dict1 = Dictionary();
        Scanner sc = new Scanner(System.in);
        while (sc != null){
            System.out.println("Введіть речення або слово для отриманння розшифровки: ");
            String[] splitted = new String[0];
            if (sc.hasNextLine()){
                String clause = sc.nextLine();
                splitted = clause.split(" ");}
            if(splitted.length == 0){
                sc.close();
                return;
            }
            CipherWord(dict1,splitted);
        }
    }
    public static HashFunc<String, String> Dictionary () throws FileNotFoundException {
        File fVar = new File("dict_processed.txt");
        Scanner sc = new Scanner(fVar);
        HashFunc<String, String> dict = new HashFunc<>();
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            int i = s.indexOf(';');
            String keyword = s.substring(0, i);
            String cipher = s.substring(i+1);
            dict.put(keyword, cipher);
        }
        return dict;
    }
}