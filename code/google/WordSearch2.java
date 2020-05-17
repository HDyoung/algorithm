package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

/**
 * @author dongyoung
 * @since 2020/04/17
 *
 * Word 문제는 만났을때는 Trie를 떠올리자 */
public class WordSearch2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findWords(null, null);

    }

    static class Solution {
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };
        char[][] board;
        boolean[][] visit;
        List<String> ans = new ArrayList<>();

        public List<String> findWords(char[][] board, String[] words) {
            this.board = board;
            this.visit = new boolean[board.length + 2][board[0].length + 2];
            Trie trie = new Trie();
            for (String word : words) {
                trie.insert(word);
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    helper(i, j, trie.root);
                }
            }
            return ans;
        }

        public void helper(int r, int c, TrieNode node) {
            if (node.word != null) {
                ans.add(node.word);
                node.word = null;
                return;
            }
            TrieNode trieNode = node.getChildren().get(board[r][c]);
            if (trieNode != null) {
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr < 0 || nr >= board.length || nc < 0 || nc > +board[0].length || visit[nr][nc]) {
                        continue;
                    }
                    visit[nr][nc] = true;
                    helper(nr, nc, trieNode);
                    visit[nr][nc] = false;
                }
            }
        }

        class Trie {
            public TrieNode root = new TrieNode();

            public void insert(String word) {
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    node = node.getChildren().computeIfAbsent(word.charAt(i), k -> new TrieNode());
                }
                node.word = word;
            }
        }

        class TrieNode {
            public Map<Character, TrieNode> children = new HashMap<>();
            public String word;

            public Map<Character, TrieNode> getChildren() {
                return children;
            }

            public void setChildren(Map<Character, TrieNode> children) {
                this.children = children;
            }
        }
    }
}
