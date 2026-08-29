class Trie {
    class Node {
        boolean isWord = false;
        Node[] children = new Node[26];
    }

    Node root;
    List<String> res;

    Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }

        curr.isWord = true;
    }

    public void dfs(Node curr, StringBuilder word) {
        if (res.size() == 3) return;

        if (curr.isWord) res.add(word.toString());

        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                dfs(curr.children[i], word.append((char)('a' + i)));
                word.deleteCharAt(word.length() - 1);
            }
        }
    }

    public List<String> getWordsStartingWith(String prefix) {
        Node curr = root;
        res = new ArrayList<>();
        for (char c: prefix.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                return res;
            }
            curr = curr.children[index];
        }

        dfs(curr, new StringBuilder(prefix));
        return res;
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }

        List<List<String>> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            String prefix = sb.append(c).toString();
            res.add(trie.getWordsStartingWith(prefix));
        }

        return res;
    }
}