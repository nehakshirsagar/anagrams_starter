/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    HashMap<String, List<String>> LettersToWord = new HashMap<String ,List<String>>();
    ArrayList<String> Wordlist = new ArrayList<String>();
    HashSet<String> wordSet= new HashSet<String>();
    public AnagramDictionary(Reader reader) throws IOException {
        BufferedReader in = new BufferedReader(reader);

        String line;
        while ((line = in.readLine()) != null) {
            String word = line.trim();
            wordSet.add(word);
            String sorted = sortLetter(word);
            List<String> l = LettersToWord.get(sorted);
            if (l == null )
                LettersToWord.put(sorted, l=new ArrayList<String>());
            l.add(word);

            Wordlist.add(word);

        }

    }

    public boolean isGoodWord(String word, String base) {
            if(wordSet.contains(word) && !(base.contains(word)));
                    return true;

    }

    public List<String> getAnagrams(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();
        List<String> l = LettersToWord.get(sortLetter(targetWord));
        Object[] arr = l.toArray();
        for (int i=0; i < arr.length; i++)
           result.add((String) arr[i]);



        return result;
    }

    public List<String> getAnagramsWithOneMoreLetter(String word) {

        ArrayList<String> temp ;

        ArrayList<String> result = new ArrayList<String>();

        for (char ch='a' ;ch<='z';ch++) {
            String newone = word + ch;
            String sorted = sortLetter(newone);


            if (LettersToWord.containsKey(sorted))
            {
                temp= (ArrayList<String>) LettersToWord.get(sorted);
            }


        }
        return result;
    }

    public String pickGoodStarterWord() {
        return "stop";
    }

    private static String sortLetter(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }



}
