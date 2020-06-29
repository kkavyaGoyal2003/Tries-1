//time complexity- O(s*l) where s is the number of words and l is the length of longest words
//space complexity- O(s*l)
import java.util.*;
public class ReplaceWords {
    private static class TrieNode {
        TrieNode[] chars;
        boolean isEnd;
        TrieNode() {
            chars = new TrieNode[26];
        }
    }
    private static TrieNode root = new TrieNode();
    static void insert(String word) {
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

    public static String startsWith(String wrds) {
        TrieNode curr = root;
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < wrds.length(); i++) {
            char c = wrds.charAt(i);
            if(curr.chars[c - 'a'] == null) {
                return wrds;
            }
            temp.append(c);
            curr = curr.chars[c - 'a'];
            if(curr.isEnd) return temp.toString();
        }
        return wrds;
    }
    static String replaceWords(List<String> dictionary, String sentence) {
        for(String str : dictionary) {
            insert(str);
        }

        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for(String w : words) {
            startsWith(w);
            ans.append(startsWith(w)).append(" ");
        }

        return ans.toString().trim();
    }

    public static void main(String[] args) {
        List<String> dictionary = List.of(new String[]{"cat", "bat", "rat"});
        String sentence = "the cattle was rattled by the battery";
        System.out.println(sentence + "=> " + replaceWords(dictionary, sentence));

    }
}
