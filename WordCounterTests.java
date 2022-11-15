/*
* File: WordCounterTests.java
* Derek Hessinger
* CS231 B
* 11/11/2022
*/

import java.util.ArrayList;

public class WordCounterTests{

	public static void main(String[] args){

		// case 1: testing WordCounter("hashmap")
		{

			// setup
			WordCounter wc = new WordCounter("hashmap");

			// verify
			System.out.println(wc.wordCount + " == 0");

			// test
			assert wc.wordCount == 0 : "Error in WordCounter::WordCounter()";
		}

		// case 2: testing WordCounter("bst")
		{

			// setup
			WordCounter wc = new WordCounter("bst");

			// verify
			System.out.println(wc.wordCount + " == 0");

			// test
			assert wc.wordCount == 0 : "Error in WordCounter::WordCounter()";
		}

		// case 3: testing readWords()
		{

			// setup
			WordCounter wc = new WordCounter("hashmap");

			ArrayList<String> words = wc.readWords("test.txt");
	

			// verify
			System.out.println(words + " == [This, is, a, test, file]");

			// assert
			assert words.get(0).equals("This") : "Error in WordCounter::readWords()";
			assert words.get(0).equals("is") : "Error in WordCounter::readWords()";
			assert words.get(0).equals("a") : "Error in WordCounter::readWords()";
			assert words.get(0).equals("test") : "Error in WordCounter::readWords()";
			assert words.get(0).equals("file") : "Error in WordCounter::readWords()";
		}

		// case 4: testing buildMap()
		{

			// setup
			WordCounter wc1 = new WordCounter("hashmap");
			ArrayList<String> words1 = wc1.readWords("test.txt");
			long result1 = wc1.buildMap(words1);

			WordCounter wc2 = new WordCounter("bst");
			ArrayList<String> words2 = wc2.readWords("test.txt");
			long result2 = wc2.buildMap(words2);

			// verify
			System.out.println("Time :" + result1);
			System.out.println("Time :" + result2);

			// test
			assert result1 != 0 : "Error in WordCounter::buildMap()";
			assert result2 != 0 : "Error in WordCounter::buildMap()";
		}

		// case 5: testing clearMap()
		{
			// setup
			WordCounter wc = new WordCounter("hashmap");
			ArrayList<String> words = wc.readWords("test.txt");
			wc.buildMap(words);
			wc.clearMap();

			// verify
			System.out.println(wc.wordCount + " == 0");

			// test
			assert wc.wordCount == 0 : "Error in WordCount::clearMap()";
		}

		// case 6: testing totalWordCount
		{
			// setup
			WordCounter wc1 = new WordCounter("hashmap");
			ArrayList<String> words1 = wc1.readWords("test.txt");
			wc1.buildMap(words1);

			WordCounter wc2 = new WordCounter("bst");
			ArrayList<String> words2 = wc2.readWords("test.txt");
			wc2.buildMap(words2);

			int result1 = wc1.totalWordCount();
			int result2 = wc2.totalWordCount();


			// verify
			System.out.println(result1 + " == 5");
			System.out.println(result2 + " == 5");

			// test
			assert result1 == 5 : "Error in WordCounter::totalWordCount()";
			assert result2 == 5 : "Error in WordCounter::totalWordCount()";
		}

		// case 7: testing uniqueWordCount()
		{
			// setup
			WordCounter wc1 = new WordCounter("hashmap");
			ArrayList<String> words1 = wc1.readWords("test.txt");
			wc1.buildMap(words1);

			WordCounter wc2 = new WordCounter("bst");
			ArrayList<String> words2 = wc2.readWords("test.txt");
			wc2.buildMap(words2);

			int result1 = wc1.uniqueWordCount();
			int result2 = wc2.uniqueWordCount();


			// verify
			System.out.println(result1 + " == 5");
			System.out.println(result2 + " == 5");

			// test
			assert result1 == 5 : "Error in WordCounter::uniqueWordCount()";
			assert result2 == 5 : "Error in WordCounter::uniqueWordCount()";
		}

		// case 8: testing getCount()
		{
			// setup
			WordCounter wc1 = new WordCounter("hashmap");
			ArrayList<String> words1 = wc1.readWords("test.txt");
			wc1.buildMap(words1);
			int result1 = wc1.getCount("This");
			int result2 = wc1.getCount("Elephant");

			WordCounter wc2 = new WordCounter("bst");
			ArrayList<String> words2 = wc2.readWords("test.txt");
			wc2.buildMap(words2);
			int result3 = wc2.getCount("This");
			int result4 = wc2.getCount("Elephant");

			// verify
			System.out.println(result1 + " == 1");
			System.out.println(result2 + " == 0");
			System.out.println(result3 + " == 1");
			System.out.println(result4 + " == 0");

			// test
			assert result1 == 1 : "Error in WordCounter::getCount()";
			assert result2 == 0 : "Error in WordCounter::getCount()";
			assert result3 == 1 : "Error in WordCounter::getCount()";
			assert result4 == 0 : "Error in WordCounter::getCount()";
		}

		// case 9: testing getFrequency()
		{
			// setup
			WordCounter wc1 = new WordCounter("hashmap");
			ArrayList<String> words1 = wc1.readWords("test.txt");
			wc1.buildMap(words1);
			double result1 = wc1.getFrequency("This");
			double result2 = wc1.getFrequency("Elephant");

			WordCounter wc2 = new WordCounter("bst");
			ArrayList<String> words2 = wc2.readWords("test.txt");
			wc2.buildMap(words2);
			double result3 = wc2.getFrequency("This");
			double result4 = wc2.getCount("Elephant");

			// verify
			System.out.println(result1 + " == 0.2");
			System.out.println(result2 + " == 0");
			System.out.println(result3 + " == 0.2");
			System.out.println(result4 + " == 0");

			// test
			assert result1 == 0.2 : "Error in WordCounter::getCount()";
			assert result2 == 0 : "Error in WordCounter::getCount()";
			assert result3 == 0.2 : "Error in WordCounter::getCount()";
			assert result4 == 0 : "Error in WordCounter::getCount()";
		}

	}





}