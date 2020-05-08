package edu.ti.caih313.hw9;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ReadToArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList> sentencesList = new ArrayList<ArrayList>();

        String homeFolder = System.getenv("HOMEPATH");
        String fileName = homeFolder + "/Documents/out.txt";
        //ArrayList<String> words = new ArrayList<String>();
        Scanner inputStream = null;
        try {
            //the File class knows how to negotiate the file system to access data
            File file = new File(fileName);
            inputStream = new Scanner(file);
            while (inputStream.hasNextLine()) {
                ArrayList<String> words = new ArrayList<String>();
                String line = inputStream.nextLine();
                String stringArray[] = line.split(" ");
                for(int i = 0; i <stringArray.length; i++) {
                    String s = stringArray[i];
                    words.add(s);
                    sentencesList.add(words);
                }
            }
        } catch (FileNotFoundException e) {
            //we'll only get here if there was an error opening the file
            System.out.println("Error opening the file " + fileName + ": " + e.getMessage());
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        //get sentence and word number from user, check for validity
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter sentence number: ");
        int sentenceNumber = keyboard.nextInt();
        if ((sentenceNumber < 0) || (sentenceNumber > sentencesList.size())) {
            System.out.println("Error: No sentence found at line " + sentenceNumber);
            System.exit(0);
        }
        System.out.println("Enter word number: ");
        int wordNumber = keyboard.nextInt();
//        if ((wordNumber < 0) || (wordNumber > words.size())) {
//            System.out.println("Error: No word found at position " + wordNumber);
//            System.exit(0);
//        }
        //print out requested word
        ArrayList desiredSentence = sentencesList.get(sentenceNumber-1);
        Object desiredWord = desiredSentence.get(wordNumber-1);
        System.out.println("The word in sentence " + sentenceNumber + " at position " + wordNumber + " is " + desiredWord + ".");
    }
}

//In the file:
//Hello, my name is Chana Liberman.
//I am in TI.
//I live in Chicago.
