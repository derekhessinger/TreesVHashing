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

	// Constuctor for WordCounter
	public WordCounter (String data_structure){

		if (data_structure.equals("bst")){
			ds = new BSTMap<String, Integer>();
		}
		else if (data_structure.equals("hashmap")){
			ds = new HashMap<String, Integer>(1000, 0.75);
		}
	}

	// Returns an arraylist of all words in file
	public ArrayList<String> readWords(String filename){

		try{

			// Create ArrayList to hold words
			ArrayList<String> wordlist = new ArrayList<String>();

  			// Create file reader with file passed
  			FileReader fr = new FileReader(filename);

  			// Create buffered reader with file reader passed
  			BufferedReader br = new BufferedReader(fr);

  			// Read the first line
  			String line = br.readLine();

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

  	// Builds map and returns time in nanoseconds
  	public long buildMap(ArrayList<String> words){

  		// Start recording time
  		long start = System.nanoTime();

  		// Put each word into the map
  		for (String word : words){

  			if (ds.get(word) != null){

  				int val = ds.get(word) + 1;
  				ds.put(word, val);
  			}

  			ds.put(word, 1);
  		}

  		// Stop recording time
  		long end = System.nanoTime();

  		// Calculate total time
  		long time = end - start;

  		return time;
  	}

  	// Clears map
  	public void clearMap(){

  		ds.clear();
  		this.wordCount = 0;
  	}

  	// Returns total word count
  	public int totalWordCount(){

  		return wordCount;
  	}

  	// Returns unique word count
  	public int uniqueWordCount(){

  		return ds.size();
  	}

  	// Returns count of word passed
  	public int getCount(String word){

  		if (ds.get(word) == null){

  			return 0;
  		}

  		int count = ds.get(word);

  		return count;
  	}

  	// Returns the frequency of the word passed
  	public double getFrequency(String word){

  		if (ds.get(word) == null){

  			return 0;
  		}

  		int wc = ds.get(word);

  		double freq = (double)wc / totalWordCount();

  		return freq;
  	}

  	// Returns the number of collisions (HashMap only)
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

  		System.out.println("file,iteration,time,jesus,count,freq");

  		for (String file : files){

  			ArrayList<String> words = wc.readWords(file);

  			for (int i = 0; i < 2; i++){
  				long time = wc.buildMap(words);
  				System.out.println(file + "," + i + "," + time + "," + wc.getCount("jesus") + ", " + wc.getFrequency("jesus"));
  				wc.clearMap();
  			}
  		}
  	}
}