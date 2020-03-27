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
            if (scanner.hasNextLine()){
                String sentence = scanner.nextLine();
                words = sentence.split(" ");}
            if(words.length==0){
                scanner.close();
                return;
            }
            shifr_word(slovnyk1,words);
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
    public static void shifr_word (Hash_function<String, String>  dictionary,String[] words){
        for (String cipherWord : words) {
            System.out.print(word.toUpperCase() + " : ");
            System.out.println(dictionary.GetKey(word.toUpperCase()));
            System.out.println(" ");
        }
    }
}
