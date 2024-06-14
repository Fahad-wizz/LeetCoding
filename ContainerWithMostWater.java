// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

 

// Example 1:


// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
// Example 2:

// Input: height = [1,1]
// Output: 1
 

// Constraints:

// n == height.length
// 2 <= n <= 105
// 0 <= height[i] <= 104 {
    
// The Approach is to use two pointers left and right. We initialize left to 0 and right to height.length - 1. We also initialize maxArea to 0. We then iterate over the array until left is less than right. We calculate the currentArea by taking the minimum of height[left] and height[right] and multiplying it by the difference between right and left. We then update maxArea to be the maximum of maxArea and currentArea. If height[left] is less than height[right] then we increment left by 1 else we decrement right by 1. Finally, we return maxArea which contains the maximum amount of water a container can store.\
// Time complexity: O(n) where n is the length of the array height.
// Space complexity: O(1)

class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(obj.maxArea(height));
        int[] height1 = {1,1};
        System.out.println(obj.maxArea(height1));
        int[] height2 = {4,3,2,1,4};
        System.out.println(obj.maxArea(height2));
    }
}
