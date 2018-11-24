/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.StringJoiner;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringJoiner str = new StringJoiner(",");
        serializeUtil(root, str);
        System.out.println(str.toString());
        return str.toString();
    }
    
    private void serializeUtil(TreeNode root, StringJoiner str) {
        if (root == null) {
            str.add("null");
        } else {
            str.add(Integer.toString(root.val));
            serializeUtil(root.left, str);
            serializeUtil(root.right, str);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tree_arr = data.split(",");
        Deque<String> deque = new LinkedList<>();
        deque.addAll(Arrays.asList(tree_arr));
        TreeNode root = deserializeUtil(deque);
        return root;
    }
    
    private TreeNode deserializeUtil(Deque<String> d) {
        String cur = d.remove();
        if (cur.equals("null")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(cur));
            node.left = deserializeUtil(d);
            node.right = deserializeUtil(d);
            return node;
        }
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));