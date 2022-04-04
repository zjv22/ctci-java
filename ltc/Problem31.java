class Problem31 
{

    //  find the next ordered permuation of an integer array 
    //    ex.  [1,2,3] -> [1,3,2] -> [2,1,3]  
    //         [3,2,1] -> [1,2,3]
    // 
    //   modify the input array in place 
    //
    public static void nextPermutation(final int[] nums) 
    {
        if (nums == null || nums.length < 2)
            return;
        
        //  find the highest index which is lower than the following index
        int i = nums.length-2;
        while( i>0 && nums[i] >= nums[i+1] )
            i--;
        
        //  if we don't find one we're at the last permutation. reverse the whole array
        if( nums[i] >= nums[i+1] )
        {
            reverse(nums, 0);
            return;
        }
        
        int tmp = nums[i];
        int k = nums.length-1;
        while( k>0 && tmp >= nums[k])
            k--;
        
        nums[i] = nums[k];
        nums[k] = tmp;
        
        reverse(nums, i+1);
    }
    
    private static void reverse(final int[] nums , int i)
    {
       // reverses all indexes of the array from i to length-1
       int k = nums.length-1;
       int tmp;
        while( i < k )
        {
           tmp = nums[i];
           nums[i] = nums[k];
           nums[k] = tmp;
           i++;
           k--;
        }
    }


    public static void main(String[] args)
    {
       nextPermutation(new int[]{1,2,5,4,3});
    }
    
}
