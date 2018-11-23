class Solution {
    /* Time Complexity: O(n) */
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }

        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0 || nums[i] > nums.length || nums[nums[i] - 1] == nums[i]) {
                /* Skip negative, out of length confinement, or already in correct place */
                i++;
            } else if (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1); // Swap to the correct place
            } else {
                i++;
            }
        }

        i = 0;
        while (i < nums.length && nums[i] == i + 1) {
            i++;
        }
        return i + 1;
    }

    private void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    /* Time Complexity: O(nlogn) */
    public int firstMissingPositive_Sort(int[] nums) {
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