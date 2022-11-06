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
			HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>(10);
			HashMap<Integer, Integer> map3 = new HashMap<Integer, Integer>(10, 0.5);

			// verify
			System.out.println(map1.getClass() + " == class HashMap");
			System.out.println(map2.getClass() + " == class HashMap");
			System.out.println(map3.getClass() + " == class HashMap");

			// test
			assert map1.getClass() == HashMap.class : "Error in HashMap::HashMap()";
			assert map2.getClass() == HashMap.class : "Error in HashMap::HashMap()";
			assert map3.getClass() == HashMap.class : "Error in HashMap::HashMap()";


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
			System.out.println(map1);
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

		// case 8: testing keySet() ***finish this***
		{

			// setup
			HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
			map1.put(1,1);
			map1.put(2,2);
			map1.put(3,3);
			map1.put(4,4);
			map1.put(5,5);
			ArrayList<K> keys = new ArrayList<K>();
			keys.add(1);
			keys.add(2);
			keys.add(3);
			keys.add(4);
			keys.add(5);

			// verify
			System.out.println(map1.keySet() + " == [1, 2, 3, 4, 5]");

			// test
			assert map1.keySet() == keys : "Error in HashMap::keySet()";
		}
	}
}