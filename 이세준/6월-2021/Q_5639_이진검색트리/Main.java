package Q_5639_이진검색트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
class Node{
	Node left;
	Node right;
	int val;
	public Node(int val)
	{
		this.val = val;
	}
}
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = "";
		Node root = new Node(Integer.parseInt(br.readLine()));
		while( (input = br.readLine()) != null ) {
			int n = Integer.parseInt(input);
			root = insertNode(root , n);
			
		}
		posetorder(root);
	}

	private static void posetorder(Node node) {
		// TODO Auto-generated method stub
		if(node != null) {
			posetorder(node.left);
			posetorder(node.right);
			System.out.println(node.val);
		}
		
	}

	private static Node insertNode(Node node, int n) {
		// TODO Auto-generated method stub
		
		Node current = null;
		if(node == null) {
			return new Node(n);
		}
		
		
		if(node.val > n) {
			current = insertNode(node.left, n);
			node.left= current;
		}else {
			current = insertNode(node.right, n);
			node.right = current;
		}
		return node;
	}
}
