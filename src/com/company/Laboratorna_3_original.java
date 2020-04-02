package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Laboratorna_3_original {

    public static void main(String[] args) throws FileNotFoundException {
        Hash_function<String, String>  slovnyk1 = Slovnyk();
        Scanner sc = new Scanner(System.in);
        while (sc != null){
            System.out.println("Введіть речення або слово для отриманння розшифровки: ");
            String[] splitted = new String[0];
            if (sc.hasNextLine()){
                String sentence = sc.nextLine();
                splitted = sentence.split(" ");}
            if(splitted.length==0){
                sc.close();
                return;
            }
            CipherWord(slovnyk1, splitted);
        }
    }
    public static Hash_function<String, String> Slovnyk () throws FileNotFoundException {
        File fVar = new File("dict_processed.txt");
        Scanner sc = new Scanner(fVar);
        Hash_function<String, String> slovnik = new Hash_function<>();
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            int i = s.indexOf(';');
            String keyWord = s.substring(0, i);
            String shifrWord = s.substring(i+1);
            slovnik.PutInfo(keyWord, shifrWord);
        }
        return slovnik;
    }

    public static void CipherWord (Hash_function<String, String>  dict,String[] splitted){
        for (String cipherWord : splitted) {
            System.out.print(cipherWord.toUpperCase() + " : ");
            System.out.println(dict.GetKey(cipherWord.toUpperCase()));
            System.out.println(" ");
        }
    }
}
