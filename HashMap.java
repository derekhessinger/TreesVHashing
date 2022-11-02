/*
* File: HashMap.java
* Derek Hessinger
* CS231
* 11/1/22
*/
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K, V> implements MapSet<K, V>{

	// use .hashCode()
	// returns an int to represent an object
	// if two objects are the same (have the same contents), they will have the same hashcode (via the hashCode() method)

	private LinkedList<MapSet.KeyValuePair<K, V>>[] map;
	int size;

	public HashMap(int initialCapacity){

		map = (LinkedList<MapSet.KeyValuePair<K, V>>[]) new LinkedList[initialCapacity];
		size = 0;
	}

	private int capacity(){

		return map.length;
	}


	// Returns index that I should look at to insert/find specified key within my map
	private int hash(K key){

		return Math.abs(key.hashCode() % capacity()); // returns a value between 0 and capacity - 1 inclusive
	}

	public void clear(){

		this.map = null;
		this.size = 0;
	}

	public int size(){

		return this.size();
	}

	public V put(K key, V value){

		int index = hash(key);
		if (map[index] != null){

			for (MapSet.KeyValuePair<K, V> kvp : map[index]){

				if (kvp.getKey().equals(key)){

					V toReturn = kvp.getValue();
					kvp.setValue(value);
					return toReturn;
				}
			}
			map[index] = new LinkedList<MapSet.KeyValuePair<K, V>>();
			map[index].add(new MapSet.KeyValuePair<K, V>(key, value));
			size++;
			// If size is too big compared to capacity, expand
			//map = (LinkedList<MapSet.KeyValuePair<K, V>>[]) new LinkedList[map.length * someReasonableFactor]
			return null;
		}
		else{
			map[index] = new LinkedList<MapSet.KeyValuePair<K, V>>();
			map[index].add(new MapSet.KeyValuePair<K, V>(key, value));
			size++;
			// If size is too big compared to capacity, expand
			//map = (LinkedList<MapSet.KeyValuePair<K, V>>[]) new LinkedList[map.length * someReasonableFactor]
			return null;
		}
	}

	public V get(K key){

		int index = hash(key);
		
		if (map[index] == null){
			return null;
		}
		else{

			for (MapSet.KeyValuePair<K, V> kvp: map[index]){

				if (kvp.getKey().equals(key)){

					return kvp.getValue();
				}
			}
			return null;
		}
	}

	public static void main(String[] args){

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(5);
		for (int i = 0; i < 5; i++){
			hm.put(i, i+1);
		}

		System.out.println(hm.get(0));
		System.out.println(hm.get(5));
	}
}