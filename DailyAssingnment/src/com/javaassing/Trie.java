package com.javaassing;
import java.util.HashMap;
import java.util.Map;
class TrieNode {
	Map<Character, TrieNode> children;
	boolean isEndOfWord;
	
	public TrieNode() {
		children = new HashMap<>();
		isEndOfWord = false;
	}
}
public class Trie {
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode current = root;
		for (char ch: word.toCharArray()) {
			current.children.putIfAbsent(ch, new TrieNode());
			current = current.children.get(ch);
		}
		current.isEndOfWord = true;
	}
	public boolean startsWith(String prefix) {
		TrieNode current = root;
		for (char ch : prefix.toCharArray()) {
			TrieNode node = current.children.get(ch);
			if (node == null) {
				return false;
			}
			current = node;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		trie.insert("app");
		trie.insert("apricot");
		
		System.out.println(trie.startsWith("app")); // true 
		System.out.println(trie.startsWith("apr")); // true 
		System.out.println(trie.startsWith("apl")); // false
	}

}
