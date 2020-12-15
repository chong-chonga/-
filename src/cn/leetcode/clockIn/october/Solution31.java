package cn.leetcode.clockIn.october;

import java.util.*;

/**
 * @author 悠一木碧
 * 题目编号: 381
 */
public class Solution31 {
    class RandomizedCollection {
        Map<Integer, Set<Integer>> indexMap;
        List<Integer> nums;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            nums = new ArrayList<>();
            indexMap = new HashMap<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            nums.add(val);
            Set<Integer> indexs = indexMap.getOrDefault(val, new HashSet<>());
            indexs.add(nums.size() - 1);
            indexMap.put(val, indexs);
            return 1 == indexs.size();

        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!indexMap.containsKey(val)){
                return false;
            } else{
                Set<Integer> indexs = indexMap.get(val);
                Iterator<Integer> iterator = indexs.iterator();
                int oneIndex = iterator.next();
                int len = nums.size();
                int endVal = nums.get(len - 1);
                Set<Integer> endValIndexs = indexMap.get(endVal);
                nums.set(oneIndex, endVal);
                indexs.remove(oneIndex);
                endValIndexs.remove(len - 1);

                if(oneIndex != len - 1){
                    endValIndexs.add(oneIndex);
                }
                if(0 == indexs.size()){
                    indexMap.remove(val);
                }
                nums.remove(len - 1);
                return true;

            }
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            Random r = new Random();
            return nums.get(r.nextInt(nums.size()));
        }
    }




}
