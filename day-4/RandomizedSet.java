import java.util.*;

public class RandomizedSet {

    HashMap<Integer, Integer> valueMap;
    HashMap<Integer, Integer> idxMap;

    public RandomizedSet() {
        valueMap = new HashMap();
        idxMap = new HashMap();
    }

    public boolean insert(int val) {
        int index = valueMap.size();
        if (valueMap.containsKey(val)) {
            return false;
        } else {
            valueMap.put(val, index);
            idxMap.put(index, val);
        }
        return true;
    }

    public boolean remove(int val) {
        if (valueMap.containsKey(val)) {
            int index = valueMap.get(val);

            if (index == valueMap.size() - 1) {
                valueMap.remove(val);
                idxMap.remove(index);
            } else {
                int lastIndex = valueMap.size() - 1;
                int lastElement = idxMap.get(lastIndex);

                idxMap.remove(lastIndex);
                idxMap.put(index, lastElement);

                valueMap.remove(val);
                valueMap.put(lastElement, index);
            }

            return true;
        }
        return false;
    }

    public int getRandom() {
        int randomValue = (int) (Math.random() * 1000000) % valueMap.size();
        return idxMap.get(randomValue);
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(0));
        System.out.println(rs.insert(1));
        System.out.println(rs.remove(0));
        System.out.println(rs.insert(2));
        System.out.println(rs.remove(1));
        System.out.println(rs.getRandom());
    }

}
