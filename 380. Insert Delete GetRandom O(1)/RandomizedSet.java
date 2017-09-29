// The Random class uses a 48-bit seed, which is modified using a linear congruential formula.
// Xi+1 = (aXi+b) mod c
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
class RandomizedSet {
    ArrayList<Integer> nums; // <val>
    HashMap<Integer, Integer> location; //<val, nums location>

    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        location = new HashMap<Integer, Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (location.containsKey(val)) {
            return false;
        }

        nums.add(val);
        location.put(val, nums.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!location.containsKey(val)) {
            return false;
        }
        int numSize = nums.size();
        int lastVal = nums.get(numSize - 1);
        int index = location.get(val);
        nums.set(index, lastVal);
        location.put(lastVal, index);
        nums.remove(numSize - 1); // O(1)
        location.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return nums.get(random.nextInt(nums.size()));
    }

    public static void main(String[] args) {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomSet.insert(1));

        // Returns false as 2 does not exist in the set.
        System.out.println(randomSet.remove(2));

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomSet.insert(2));

        // getRandom should return either 1 or 2 randomly.
        System.out.println(randomSet.getRandom());

        // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomSet.remove(1));

        // 2 was already in the set, so return false.
        System.out.println(randomSet.insert(2));

        // Since 2 is the only number in the set, getRandom always return 2.
        System.out.println(randomSet.getRandom());
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
