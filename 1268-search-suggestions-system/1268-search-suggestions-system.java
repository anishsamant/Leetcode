class Solution {
    class Node {
        Node[] children = new Node[26];
        // Cache the top 3 products directly in the node
        List<String> suggestions = new ArrayList<>(); 
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // 1. Sort upfront so insertions happen in alphabetical order
        Arrays.sort(products); 
        
        Node root = new Node();
        
        // 2. Build Trie and cache products
        for (String product : products) {
            Node curr = root;
            for (char c : product.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new Node();
                }
                curr = curr.children[index];
                // Since products are sorted, the first 3 to hit this node are the correct ones
                if (curr.suggestions.size() < 3) {
                    curr.suggestions.add(product);
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        Node curr = root;
        
        // 3. Search step: No DFS, no re-traversal from root
        for (char c : searchWord.toCharArray()) {
            int index = c - 'a';
            if (curr != null) {
                curr = curr.children[index]; // Move down one step sequentially
            }
            
            if (curr == null) {
                res.add(new ArrayList<>()); // No matches possible anymore
            } else {
                res.add(curr.suggestions); // Instant O(1) lookup!
            }
        }

        return res;
    }
}
