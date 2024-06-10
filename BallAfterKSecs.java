class BallAfterKSecs {
    public int numberOfChild(int n, int k) {
         int position = 0;
        int direction = 1; // 1 for right, -1 for left
        
        if(n <= 50 && n >=2 && k>=2 && k<=50){
            for (int i = 0; i < k; i++) {
                if (position == 0) {
                    direction = 1;
                } else if (position == n - 1) {
                    direction = -1;
                }

                position += direction;
            }
        }else{
            return 1;
        }
        return position;
    }

    public static void main(String[] args) {
        BallAfterKSecs ballAfterKSecs = new BallAfterKSecs();
        System.out.println(ballAfterKSecs.numberOfChild(5, 2));
    }
    
}

// {100320. Maximum Total Reward Using Operations II
// User Accepted:88
// User Tried:1198
// Total Accepted:97
// Total Submissions:2352
// Difficulty:Hard
// You are given an integer array rewardValues of length n, representing the values of rewards.

// Initially, your total reward x is 0, and all indices are unmarked. You are allowed to perform the following operation any number of times:

// Choose an unmarked index i from the range [0, n - 1].
// If rewardValues[i] is greater than your current total reward x, then add rewardValues[i] to x (i.e., x = x + rewardValues[i]), and mark the index i.
// Return an integer denoting the maximum total reward you can collect by performing the operations optimally.

 

// Example 1:

// Input: rewardValues = [1,1,3,3]

// Output: 4

// Explanation:

// During the operations, we can choose to mark the indices 0 and 2 in order, and the total reward will be 4, which is the maximum.

// Example 2:

// Input: rewardValues = [1,6,4,3,2]

// Output: 11

// Explanation:

// Mark the indices 0, 2, and 1 in order. The total reward will then be 11, which is the maximum.

 

// Constraints:

// 1 <= rewardValues.length <= 5 * 104
// 1 <= rewardValues[i] <= 5 * 104}