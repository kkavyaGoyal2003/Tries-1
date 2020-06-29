//time complexity- O(n) for insert, search and prefix
//space complexity- O(n) for insert and O(1) for search and prefix
public class ImplementTrie {
    private class TrieNode {
        TrieNode[] chars;
        boolean isEnd;

        public TrieNode () {
            this.chars =  new TrieNode[26];
        }
    }
    private TrieNode root;
    public ImplementTrie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.chars[c - 'a'] == null) {
                curr.chars[c - 'a'] = new TrieNode();
            }
            curr = curr.chars[c - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.chars[c - 'a'] == null) return false;
            curr = curr.chars[c - 'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(curr.chars[c - 'a'] == null) return false;
            curr = curr.chars[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
