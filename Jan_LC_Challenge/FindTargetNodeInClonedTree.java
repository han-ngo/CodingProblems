/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
  public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    if (original == null || cloned == null) return null;
    TreeNode left = getTargetCopy(original.left, cloned.left, target);
    if (left != null) return left;
    if (original == target) {
      return cloned;
    }
    TreeNode right = getTargetCopy(original.right, cloned.right, target);
    return right;
  }
  
//   public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
//     List<TreeNode> nodes = new ArrayList<>();
//     traverse(cloned, target.val, nodes);
//     return nodes.get(nodes.size()-1);
//   }
  
//   private void traverse(TreeNode node, int targetVal, List<TreeNode> nodes) {
//     if (node == null) return;
//     traverse(node.left, targetVal, nodes);
//     if (node.val == targetVal) {
//       nodes.add(node);
//       return;
//     }
//     traverse(node.right, targetVal, nodes);
//   }
}