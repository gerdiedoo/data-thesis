import java.util.Set;
import java.util.List;

/**
 * Interface for a HashMap.
 * DO NOT EDIT THIS FILE!
 *
 * @version 1.0
 * @author CS 1332 TAs
 */
public interface HashMapInterface<K, V> {
    int STARTING_SIZE = 9;
    double MAX_LOAD_FACTOR = 0.67;

    /**
     * Adds the given key-value pair to the HashMap.
     * If the key is already in the HashMap, then replace the value with this
     * value.
     * 
     * In the case of a collision, use linear probing as your resolution
     * strategy.
     *
     * Check to see if the backing array needs to be regrown BEFORE
     * adding. For example, If my HashMap has a backing array of size 5, and 3
     * elements in it, I should regrow at the start of the next add operation
     * (even if it is a key that is already in the hash map).
     *
     * Return null if the key was not already in the map. If it was in the map,
     * return the old value associated with it.
     * 
     * @param key key to add into the HashMap
     * @param value value to add into the HashMap
     * @throws IllegalArgumentException if key or value is null
     * @return null if the key was not already in the map.  If it was in the
     * map, return the old value associated with it
     */
    V add(K key, V value);

    /**
     * Removes the value associated with the key from the map.
     *
     * When removing, do not set the key and value to {@code null}; keep them as
     * is.
     * 
     * @param key the key to remove
     * @throws IllegalArgumentException if key is null
     * @throws java.util.NoSuchElementException if the key does not exist
     * @return the value previously associated with the key
     */
    V remove(K key);

    /**
     * Gets the value associated with the given key.
     * 
     * @param key the key to search for
     * @throws IllegalArgumentException if key is null
     * @throws java.util.NoSuchElementException if the key is not in the map
     * @return the value associated with the given key
     */
    V get(K key);

    /**
     * Returns whether or not the key is in the map.
     * 
     * @param key the key to search for
     * @throws IllegalArgumentException if key is null
     * @return whether or not the key is in the map
     */
    boolean contains(K key);

    /**
     * Clears the table and resets it to the default size.
     */
    void clear();

    /**
     * Returns the number of elements in the map.
     * 
     * @return number of elements in the HashMap
     */
    int size();

    /**
     * Returns a Set view of the keys contained in this map.
     * Use {@code java.util.HashSet}.
     *
     * @return set of keys in this map
     */
    Set<K> keySet();

    /**
     * Returns a List view of the values contained in this map.
     * Use any class that implements the List interface
     * This includes {@code java.util.ArrayList} and
     * {@code java.util.LinkedList}.
     *
     * @return list of values in this map
     */
    List<V> values();

    /**
     * Resize the backing table to {@code length}. This may mean that after
     * resizing, the load factor may exceed MAX_LOAD_FACTOR. In this case, do
     * NOT regrow the table; keep it at {@code length}.
     *
     * Remember that you cannot just simply copy the entries over to the new
     * array.
     *
     * @param length new length of the backing table
     * @throws IllegalArgumentException if length is non-positive or less than
     * the number of items in the hash map.
     */
    void resizeBackingTable(int length);

    /**
     * DO NOT USE THIS METHOD IN YOUR CODE.  IT IS FOR TESTING ONLY.
     * 
     * @return the backing array of the data structure, not a copy.  INCLUDE
     * EMPTY SPACES
     */
    MapEntry<K, V>[] getTable();
}
