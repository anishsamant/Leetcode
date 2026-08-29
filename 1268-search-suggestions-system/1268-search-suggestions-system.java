class Trie {
    class Node {
        Node[] children = new Node[26];
        List<String> suggestions = new ArrayList<>();
    }

    Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }

            curr = curr.children[index];
            if (curr.suggestions.size() < 3) curr.suggestions.add(word);
        }
    }

    public List<List<String>> getWordsStartingWith(String searchWord) {
        Node curr = root;
        List<List<String>> res = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            int index = c - 'a';
            if (curr != null) {
                curr = curr.children[index];
            }

            if (curr == null) {
                res.add(new ArrayList<>());
            } else {
                res.add(curr.suggestions);
            }
        }

        return res;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        
        return trie.getWordsStartingWith(searchWord);
    }
}
