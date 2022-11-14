/*
* File: HashMapTests.java
* Derek Hessinger
* CS231 B
* 11/4/22
*/

import java.util.ArrayList; 

public class HashMapTests{

	public static void main(String[] args){

		// case 1: testing HashMap()
		{

			// setup
			HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>(10, 0.5);

			// verify
			System.out.println(map1.size() + " == 0");
			//System.out.println(map1.loadFactor + " == 0.5");
			//System.out.println(map1.collisions + " == 0");

			// test
			assert map1.size() == 0 : "Error in HashMap::HashMap()";
			//assert map1.loadFactor == 0.5 : "Error in HashMap::HashMap()";
			//assert map1.collisions == 0 : "Error in HashMap::HashMap()";

		}

		// case 2: testing size()
		{

			// setup
			HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();

			// verify
			System.out.println(map1.size() + " == 0");

			// test
			assert map1.size() == 0 : "Error in HashMap::size()";
		}

		// case 3: testing put()
		{

			// setup
			HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
			map1.put(1,1);

			// verify
			//System.out.println(map1);
			System.out.println(map1.size() + " == 1");

			// test
			assert map1.size() == 1 : "Error in HashMap::put()";
		}

		// case 4: testing clear()
		{

			// setup
			HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
			map1.put(1,1);
			map1.put(2,2);
			map1.put(3,4);
			map1.clear();

			// verify
			System.out.println(map1.size() + " == 0");

			// test
			assert map1.size() == 0 : "Error in HashMap::clear()";
		}

		// case 5: testing get()
		{

			// setup
			HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
			map1.put(1,1);

			// verify
			System.out.println(map1.get(1) + " == 1");
			System.out.println(map1.get(5) + " == null");

			// test
			assert map1.get(1) == 1 : "Error in HashMap::get()";
			assert map1.get(5) == null : "Error in HashMap::get()";
		}

		// case 6: testing containsKey()
		{

			// setup
			HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
			map1.put(1,1);

			// verify
			System.out.println(map1.containsKey(1) + " == true");
			System.out.println(map1.containsKey(2) + " == false");

			// test
			assert map1.containsKey(1) == true : "Error in HashMap::containsKey()";
			assert map1.containsKey(2) == false: "Error in HashMap::containsKey()";
		}


		// case 7: testing remove()
		{

			// setup
			HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
			map1.put(1,1);
			map1.remove(1);

			// verify
			System.out.println(map1.get(1) + " == null");
			System.out.println(map1.size() + " == 0");

			// test
			assert map1.get(1) == null : "Error in HashMap::remove()";
			assert map1.size() == 0 : "Error in HashMap::remove()";
		}

		// case 8: testing keySet()
		{

			// setup
			HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
			map1.put(1,1);
			map1.put(2,2);
			map1.put(3,3);
			map1.put(4,4);
			map1.put(5,5);

			ArrayList<Integer> keys = new ArrayList<Integer>();
			keys.add(1);
			keys.add(2);
			keys.add(3);
			keys.add(4);
			keys.add(5);

			ArrayList<Integer> keyList = map1.keySet();

			// verify
			System.out.println(map1.keySet() + " == " + keys);
			System.out.println(keyList.get(0) + " == 1");
			System.out.println(keyList.get(1) + " == 2");
			System.out.println(keyList.get(2) + " == 3");
			System.out.println(keyList.get(3) + " == 4");
			System.out.println(keyList.get(4) + " == 5");

			// test
			assert map1.keySet().size() == 5 : "Error in HashMap::keySet()";
			assert keyList.get(0).equals(1) : "Error in HashMap::keySet()";
			assert keyList.get(1).equals(2) : "Error in HashMap::keySet()";
			assert keyList.get(2).equals(3) : "Error in HashMap::keySet()";
			assert keyList.get(3).equals(4) : "Error in HashMap::keySet()";
			assert keyList.get(4).equals(5) : "Error in HashMap::keySet()";
		}

		// case 9: testing values()
		{

			// setup
			HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
			map1.put(1,1);
			map1.put(2,2);
			map1.put(3,3);
			map1.put(4,4);
			map1.put(5,5);

			ArrayList<Integer> vals = new ArrayList<Integer>();
			vals.add(1);
			vals.add(2);
			vals.add(3);
			vals.add(4);
			vals.add(5);

			// verify
			System.out.println(map1.values() + " == " + vals);
			System.out.println(vals.get(0) + " == 1");
			System.out.println(vals.get(1) + " == 2");
			System.out.println(vals.get(2) + " == 3");
			System.out.println(vals.get(3) + " == 4");
			System.out.println(vals.get(4) + " == 5");

			// test
			assert map1.values().size() == 5 : "Error in HashMap::values()";
			assert vals.get(0).equals(1) : "Error in HashMap::values()";
			assert vals.get(1).equals(2) : "Error in HashMap::values()";
			assert vals.get(2).equals(3) : "Error in HashMap::values()";
			assert vals.get(3).equals(4) : "Error in HashMap::values()";
			assert vals.get(4).equals(5) : "Error in HashMap::values()";
		}

		// case 10: testing entrySet()
		{

			// setup
			HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
			map1.put(1,1);
			map1.put(2,2);
			map1.put(3,3);
			map1.put(4,4);
			map1.put(5,5);

			ArrayList<MapSet.KeyValuePair<Integer,Integer>> set = new ArrayList<MapSet.KeyValuePair<Integer,Integer>>();
			MapSet.KeyValuePair<Integer, Integer> num1 = new MapSet.KeyValuePair<Integer, Integer> (1,1);
			MapSet.KeyValuePair<Integer, Integer> num2 = new MapSet.KeyValuePair<Integer, Integer> (2,2);
			MapSet.KeyValuePair<Integer, Integer> num3 = new MapSet.KeyValuePair<Integer, Integer> (3,3);
			MapSet.KeyValuePair<Integer, Integer> num4 = new MapSet.KeyValuePair<Integer, Integer> (4,4);
			MapSet.KeyValuePair<Integer, Integer> num5 = new MapSet.KeyValuePair<Integer, Integer> (5,5);
			set.add(num1);
			set.add(num2);
			set.add(num3);
			set.add(num4);
			set.add(num5);

			// verify
			System.out.println(map1.entrySet() + " == " + set);
			System.out.println(map1.entrySet().get(0) + " == " + num1);
			System.out.println(map1.entrySet().get(1) + " == " + num2);
			System.out.println(map1.entrySet().get(2) + " == " + num3);
			System.out.println(map1.entrySet().get(3) + " == " + num4);
			System.out.println(map1.entrySet().get(4) + " == " + num5);

			// figure out why this doesn't work
			// test
			assert map1.entrySet().size() == 5 : "Error in HashMap::entrySet()";
			assert map1.entrySet().get(0).equals(num1) : "Error in HashMap::entrySet()";
			assert map1.entrySet().get(1).equals(num2) : "Error in HashMap::entrySet()";
			assert map1.entrySet().get(2).equals(num3) : "Error in HashMap::entrySet()";
			assert map1.entrySet().get(3).equals(num4) : "Error in HashMap::entrySet()";
			assert map1.entrySet().get(4).equals(num5) : "Error in HashMap::entrySet()";
		}
	}
}