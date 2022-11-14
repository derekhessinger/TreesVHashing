/*
* File: WordCounter.java
* Derek Hessinger
* CS231 B
* 11/11/2022
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File; 
import java.io.FileWriter;

public class WordCounter{

	MapSet<String, Integer> ds;
	int wordCount;

	public WordCounter (String data_structure){

		if (data_structure.equals("bst")){
			ds = new BSTMap<String, Integer>();
		}
		else if (data_structure.equals("hashmap")){
			ds = new HashMap<String, Integer>(1000, 0.5);
		}
	}

	public ArrayList<String> readWords(String filename){

		try{

			// Create ArrayList to hold words
			ArrayList<String> wordlist = new ArrayList<String>();

  			// Create file reader with file passed
  			FileReader fr = new FileReader(filename);

  			// Create buffered reader with file reader passed
  			BufferedReader br = new BufferedReader(fr);

  			// Read the first line so it is not included in ArrayList
  			String line = br.readLine();

  			// Read again to get to first line of data in file
  			line = br.readLine();

  			// While the line is not equal to null
  			while (line != null){

  				// Split on anything that isnt a letter or number
  				String[] words = line.split("[^a-zA-Z0-9']");

  				for (String word : words){

  					wordlist.add(word);

  					wordCount += 1;
  				}

  				// Go to next line
  				line = br.readLine();
  			}

  			return wordlist;
  		}
  		catch(FileNotFoundException ex) {

      	System.out.println("WordCounter.analyze():: unable to open file " + filename );
    	}
   		catch(IOException ex) {

    	System.out.println("WordCounter.analyze():: error reading file " + filename);
    	}
    	return null;
  	}

  	public long buildMap(ArrayList<String> words){

  		long start = System.nanoTime();

  		for (String word : words){

  			if (ds.get(word) != null){

  				int val = ds.get(word) + 1;
  				ds.put(word, val);
  			}

  			ds.put(word, 0);
  		}

  		long end = System.nanoTime();

  		long time = end - start;

  		return time;
  	}

  	public void clearMap(){

  		ds.clear();
  	}

  	public int totalWordCount(){

  		return wordCount;
  	}

  	public int uniqueWordCount(){

  		return ds.size();
  	}

  	public int getCount(String word){

  		if (ds.get(word) == null){

  			return 0;
  		}

  		int count = ds.get(word);

  		return count;
  	}

  	public double getFrequency(String word){

  		if (ds.get(word) == null){

  			return 0;
  		}

  		int wc = ds.get(word);

  		double freq = wc / totalWordCount();

  		return freq;
  	}

  	public int getCollisions(){

  		return ds.getCollisions();
  	}

  	public static void main(String[] args){

  		WordCounter wc = new WordCounter("hashmap");

  		ArrayList<String> files = new ArrayList<String>();
  		files.add("reddit_comments_2008.txt");
  		files.add("reddit_comments_2009.txt");
  		files.add("reddit_comments_2010.txt");
  		files.add("reddit_comments_2011.txt");
  		files.add("reddit_comments_2012.txt");
  		files.add("reddit_comments_2013.txt");
  		files.add("reddit_comments_2014.txt");
  		files.add("reddit_comments_2015.txt");

  		System.out.println("file,iteration,time,collisions");

  		for (String file : files){

  			ArrayList<String> words = wc.readWords(file);

  			for (int i = 0; i < 5; i++){
  				//TODO: figure out how to count and print collisions
  				long time = wc.buildMap(words);
  				System.out.println(file + "," + i + "," + wc.buildMap(words) + "," + wc.getCollisions());
  				wc.clearMap();
  			}
  		}
  	}
}