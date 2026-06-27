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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);

                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            ans += minSwaps(level);
        }

        return ans;
    }

    private int minSwaps(ArrayList<Integer> arr) {
        int n = arr.size();

        int[] sorted = new int[n];
        for (int i = 0; i < n; i++)
            sorted[i] = arr.get(i);

        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++)
            map.put(arr.get(i), i);

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == sorted[i])
                continue;

            swaps++;

            int curr = arr.get(i);
            int correct = sorted[i];

            int idx = map.get(correct);

            arr.set(idx, curr);
            arr.set(i, correct);

            map.put(curr, idx);
            map.put(correct, i);
        }

        return swaps;
    }
}