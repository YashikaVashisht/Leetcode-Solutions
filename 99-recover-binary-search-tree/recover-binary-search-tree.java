
        /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static void inorder(TreeNode root, ArrayList<TreeNode> list){
        if(root==null) return ;
        inorder(root.left, list); 
        list.add(root);
        inorder(root.right, list); 
    }
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> list= new ArrayList<>();
        inorder(root, list);
        ArrayList<TreeNode> res = new ArrayList<>(list);
        res.sort(Comparator.comparingInt(node -> node.val)); 
        ArrayList<TreeNode> swap= new ArrayList<>();
      
        
        for(int i=0;i<list.size();i++){
            if(res.get(i)!= list.get(i)){
                swap.add(list.get(i));
            }
        }
        if (swap.size() == 2) {
            int temp = swap.get(0).val;
            swap.get(0).val = swap.get(1).val;
            swap.get(1).val = temp;
        }

    }
}
        

    