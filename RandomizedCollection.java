import java.util.*;

/**
 * RandomizedCollection is a data structure that contains a collection of numbers, possibly duplicates (i.e., a multiset). 
 * It should support inserting and removing specific elements and also reporting a random element.

    Implement the RandomizedCollection class:

    RandomizedCollection() Initializes the empty RandomizedCollection object.
    bool insert(int val) Inserts an item val into the multiset, even if the item is already present. Returns true if the item is not present, false otherwise.
    bool remove(int val) Removes an item val from the multiset if present. Returns true if the item is present, false otherwise.
    Note that if val has multiple occurrences in the multiset, we only remove one of them.
    int getRandom() Returns a random element from the current multiset of elements. 
    The probability of each element being returned is linearly related to the number of the same values the multiset contains.
    You must implement the functions of the class such that each function works on average O(1) time complexity.

    Note: The test cases are generated such that getRandom will only be called if there is at least one item in the RandomizedCollection.

    Example 1:

    Input
    ["RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", "getRandom"]
    [[], [1], [1], [2], [], [1], []]
    Output
    [null, true, false, true, 2, true, 1]
 */

public class RandomizedCollection {
    List<Integer> nums;
    Map<Integer, Set<Integer>> numsMap;    

   
    public RandomizedCollection () {
        this.nums = new ArrayList<>();
        this.numsMap = new HashMap<Integer, Set<Integer>>();    
    }

    public boolean insert(int val) {
        if (this.numsMap.containsKey(val)) {
            Set<Integer> numsSet = this.numsMap.get(val);
            numsSet.add(this.nums.size());
            this.numsMap.put(val, numsSet);
            this.nums.add(val);
            return false;
        } else {
            Set<Integer> newNumsSet = new HashSet<Integer>();
            newNumsSet.add(this.nums.size());
            this.numsMap.put(val, newNumsSet);
            this.nums.add(val);
            return true;
        }
    }

     /*
        nums = [1,1,1,2]; l=5
        
        numsMap = {1:{0,1,2}, 2:{3}, 3:{}}
     */

    public boolean remove(int val) {
        if (!this.numsMap.containsKey(val)) {
            return false;
        }

        Set<Integer> numsSetToRemove = this.numsMap.get(val);

        int indexToRemove = numsSetToRemove.iterator().next();
        int lastIndex = this.nums.size() - 1;

        numsSetToRemove.remove(indexToRemove);

        if (indexToRemove != lastIndex) {
            int lastElement = this.nums.get(lastIndex);

            // Move the last element into the removed position
            this.nums.set(indexToRemove, lastElement);

            // Update the moved element's indices
            Set<Integer> lastElementSet = this.numsMap.get(lastElement);
            lastElementSet.remove(lastIndex);
            lastElementSet.add(indexToRemove);
        }

        this.nums.remove(lastIndex);

        if (numsSetToRemove.isEmpty()) {
            this.numsMap.remove(val);
        }

        return true;
    }

    public int getRandom() {
        int randomIndex =  new java.util.Random().nextInt(0, this.nums.size());
        return this.nums.get(randomIndex);
    }
}
