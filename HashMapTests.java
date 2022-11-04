/*
* File: HashMapTests.java
* Derek Hessinger
* CS231 B
* 11/4/22
*/

public class HashMapTests{

	public static void HashMapTests(){

		// case 1: testing HashMap()
		{

			// setup
			HashMap map1 = new HashMap();
			HashMap map2 = new HashMap(10);
			HashMap map3 = new HashMap(10, 0.5);

			// verify
			System.out.println(map1.getObjType() + " == HashMaps");
		}
	}
}