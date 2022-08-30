import java.util.*;

class Node<K, V> {
    K key;
    V value;
}

class TempMap {
    private List<Integer> bucket;

    TempMap() {
        bucket = new ArrayList<Integer>();
    }

}

public class HowHashMapWorks {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.get(0);
        Integer i = new Integer("abcd");
        // returns a hash code value for this object
        int result = i.hashCode();
        System.out.println("Hash Code Value= " + result);
    }
}