/*
* File: HashMap.java
* Derek Hessinger
* CS231 B
* 11/2/22
*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class HashMap<K, V> implements MapSet<K, V> {

    // Fields
    LinkedList<KeyValuePair<K, V>>[] map;
    int size;
    double loadFactor;
    int collisions;

    // Constructor for HashMap
    public HashMap(){

        this.map = new LinkedList[1000];
        this.size = 0;
        this.loadFactor = 0.75;
    }

    // Constuctor for HashMap with initial capacity taken as argument
    public HashMap(int initialCapacity) {
        this.map = new LinkedList[initialCapacity];
        this.size = 0;
        this.loadFactor = 0.75;
    }
    // Constuctor for HashMap with initial capacity and load factor taken as arguments
    public HashMap(int initialCapacity, double loadFactor) {
        this.map = new LinkedList[initialCapacity];
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    // Returns size of HashMap
    public int size(){
        return this.size;
    }

    // Clears the HashMap
    public void clear(){
        this.map = (LinkedList<KeyValuePair<K, V>>[]) new LinkedList[(capacity())];
        this.size = 0;
        this.collisions = 0;
    }

    // Helper function to return capacity of HashMap
    private int capacity(){
        return this.map.length;
    }

    // Creates hash for key passed
    private int hash(K key){
        return Math.abs(key.hashCode() % capacity()); // this returns a value between 0 and capacity() - 1, inclusive
    }

    // Puts value in hashmap
    public V put(K key, V value){

        // Grab index by hashing key
        int index = hash(key);

        // If map index is null, start linked list and add the kvp
        if (map[index] == null) {
            map[index] = new LinkedList<KeyValuePair<K, V>>();
            map[index].add(new KeyValuePair<K, V>(key, value));
            this.size++;

            // If size is greater than capacity*loadfactor, increase map size
            if (size() > (int)(capacity()*this.loadFactor)){

                ArrayList<KeyValuePair<K, V>> kvpList = entrySet();

                map = (LinkedList<KeyValuePair<K, V>>[]) new LinkedList[map.length * 3];

                this.size = 0;

                this.collisions = 0;

                // Copies each kvp to increased size HashMap
                for (KeyValuePair<K, V> kvp : kvpList){

                    this.put(kvp.getKey(), kvp.getValue());
                }
            }
            return null;
        }
        // If the key already exists in the map, change the value to the one passed
        else {
            for (KeyValuePair<K, V> kvp : map[index]) {
                if (kvp.getKey().equals(key)) {
                    V oldValue = kvp.getValue();
                    kvp.setValue(value);
                    return oldValue;
                }
            }
            // Add kvp to linked list if it has a different key
            map[index].add(new KeyValuePair<K, V>(key, value));
            this.size++;
            this.collisions++;

            // Increase map size if size becomes to large
            if (size() > (int)(capacity()*this.loadFactor)){

                ArrayList<KeyValuePair<K, V>> kvpList = entrySet();

                map = (LinkedList<KeyValuePair<K, V>>[]) new LinkedList[map.length * 3];

                this.size = 0;

                this.collisions = 0;

                // Add each kvp into larger HashMap
                for (KeyValuePair<K, V> kvp : kvpList){

                    put(kvp.getKey(), kvp.getValue());
                }
            }
            return null;
        }
    }

    // Returns total collisions
    public int getCollisions(){

        return this.collisions;
    }

    // Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key
    public V get(K key) {
        int index = hash(key);

        if (map[index] == null) {
            return null;
        } else {
            for (KeyValuePair<K, V> kvp : map[index]) {
                if (kvp.getKey().equals(key)) {
                    return kvp.getValue();
                }
            } return null;
        }
    }

    // Returns true if this map contains a mapping for the specified key to a value
    public boolean containsKey(K key){

        if (this.get(key) != null){
            return true;
        }

        return false;
    }

    // Removes kvp from map
    public V remove(K key){

        int index = hash(key);

        // If nothing in index, return null
        if (map[index] == null){

            return null;
        }

        // Iterate through each element in the index until the correct kvp is found
        for (KeyValuePair<K, V> kvp : map[index]){

            if (kvp.getKey().equals(key)){

                int idx = map[index].indexOf(kvp);

                V removed = kvp.getValue();

                map[index].remove(idx);

                this.size--;

                // If size becomes too small compared to mapsize, decrease map size
                if (this.size < (capacity()*(this.loadFactor*this.loadFactor*this.loadFactor))){

                    ArrayList<KeyValuePair<K, V>> kvpList = entrySet();

                    map = (LinkedList<KeyValuePair<K, V>>[]) new LinkedList[this.map.length / 3];

                    this.size = 0;

                    // Put each kvp back into smaller HashMap
                    for (KeyValuePair<K,V> kv : kvpList){

                        K k = kv.getKey();
                        V v = kv.getValue();
                        this.put(k, v);
                    }
                }
                return removed;
            }
        }
        return null; 
    }

    // Returns ArrayList of all keys in map
    public ArrayList<K> keySet(){

        ArrayList<K> keys = new ArrayList<K>();

        int index = 0;
        
        while (index < this.map.length){

            if (map[index] != null){

                for (KeyValuePair<K, V> kvp: map[index]){

                    keys.add(kvp.getKey());
                }
            }
            index += 1;
        }
        return keys;
    }

    // Returns ArrayList of all values in map
    public ArrayList<V> values(){

        ArrayList<V> vals = new ArrayList<V>();

        int index = 0;

        while (index < this.map.length){

            if (map[index] != null){

                for (KeyValuePair<K, V> kvp: map[index]){

                    vals.add(kvp.getValue());
                }
            }
            index += 1;
        }
        return vals;
    }

    // Returns ArrayList of all kvps in map
    public ArrayList<KeyValuePair<K, V>> entrySet(){

        ArrayList<KeyValuePair<K, V>> set = new ArrayList<KeyValuePair<K, V>>();

        int index = 0;

        while (index < this.map.length){

            if (map[index] != null){

                for (KeyValuePair<K, V> kvp: map[index]){

                    set.add(kvp);
                }
            }
            index += 1;
        }
        return set;
    }

    // ToString function
    public String toString(){

        String str = "";

        int index = 0;

        while (index < this.map.length){ 

            str += index + ": ";

            if (map[index] != null){

                for (KeyValuePair<K,V> kvp: map[index]){

                    str += kvp + ", ";
                }
            }
            str += "\n";

            index += 1;
        }
        return str;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(5);

        System.out.println(hm);

        for (int i = 5; i < 10; i++) {
            hm.put(i, i + 1);
            System.out.println(hm);
        }

        
        hm.remove(8);
        hm.remove(9);

        System.out.println(hm);

        System.out.println(hm.get(5));
    }

    // @Override
    // public boolean containsKey(K key) {
    //     // TODO Auto-generated method stub
    //     return false;
    // }

    // @Override
    // public ArrayList<K> keySet() {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    // @Override
    // public ArrayList<V> values() {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    // @Override
    // public ArrayList<MapSet.KeyValuePair<K, V>> entrySet() {
    //     // TODO Auto-generated method stub
    //     return null;
    // }

    // @Override
    // public int size() {
    //     // TODO Auto-generated method stub
    //     return 0;
    // }

    // @Override
    // public void clear() {
    //     // TODO Auto-generated method stub

    // }
}