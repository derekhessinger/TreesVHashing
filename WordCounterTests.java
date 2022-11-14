/*
* File: WordCounterTests.java
* Derek Hessinger
* CS231 B
* 11/11/2022
*/

public class WordCounterTests{

	public static void main(String[] args){

		// case 1: testing WordCounter("bst")
		{

			// setup
			WordCounter wc = new WordCounter("bst");

			// verify
			System.out.println(wc.getClass() + " == bst");
		}
	}
}