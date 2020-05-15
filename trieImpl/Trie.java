package Trie;

public class Trie {
    /** Refferance link
     * https://leetcode.com/articles/implement-trie-prefix-tree/
     * https://github.com/gkcs/Competitive-Programming/blob/master/src/main/java/main/java/videos/Tries.java
     */
    private final TrieNode  root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode current = root;
        for (char c : s.toCharArray()) {
            if (current.nodes[c - 'a'] == null) {
                current.nodes[c - 'a'] = new TrieNode();
            }
            current = current.nodes[c - 'a'];
        }
        current.setEnd(true);
    }

    public boolean search(String s) {
        TrieNode current = root;
        for (char c : s.toCharArray()) {
            if (current.nodes[c - 'a'] == null) {
                return false;
            }
            current = current.nodes[c - 'a'];
        }
        return current.isEnd();
    }

    public boolean startWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (current.nodes[c - 'a'] == null) {
                return false;
            }
            current = current.nodes[c - 'a'];
        }
        return true;
    }

    public boolean delete(String s) {
        TrieNode current = root;
        for (char c : s.toCharArray()) {
            if (current.nodes[c - 'a'] == null) {
                return false;
            }
            current = current.nodes[c - 'a'];
        }
        if (current.isEnd())
            current.setEnd(false);

        return false;
    }

    public void update(String oldStr, String newStr) {
          delete(oldStr);
          insert(newStr);
    }

}

