// Sum Root to Leaf Numbers
// Each root-to-leaf path in the tree represents a number.
//  For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
//  Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

class Problem129 
{
    public int sumNumbers(final TreeNode root)
    {
        return sumPath(root, 0);        
    }
    
    
    private int sumPath(final TreeNode root, int path)
    {
        if(root == null)
            return 0;
        
        // at each step we multiply the previous steps by 10 to increment the place
        path = (path * 10) + root.val;

        // if we're at a leaf node nothing else to do
        if(root.left == null && root.right == null)
            return path;

        // add both children paths at each step
        return sumPath(root.left, path) + sumPath(root.right, path);
    }

    public static final class TreeNode 
    {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }
}
