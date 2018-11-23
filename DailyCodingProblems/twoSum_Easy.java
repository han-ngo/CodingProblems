class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        int diff = 0;
        HashMap<Integer, Integer> nums_map = new HashMap<>();
        nums_map.put(nums[0], 0);
        
        for (int i = 1; i < nums.length; i++) {
            diff = target-nums[i];
            if (nums_map.containsKey(diff)) {
                results[0] = nums_map.get(diff);
                results[1] = i;
                return results;
            } else {
                nums_map.put(nums[i], i);       
            }    
        }
     
        return results;
    }
    
}