class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        Arrays.sort(nums);
        int num = 1;
        int prev = nums[0];

        if (prev <= 0) {
            // Do nothing
        } else if (prev == 1) {
            num++;
        } else {
            return 1;
        }

        for (int i = 1; i < nums.length; i++) {
            if (prev != nums[i] && nums[i] > 0 && nums[i] != num) {
                return num;
            }
            if (nums[i] > 0 && prev != nums[i]) {
                num++;
            }
            prev = nums[i];
        }

        return num;
    }
}