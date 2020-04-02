package code;

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data=data;
		this.left=left;
		this.right=right;
	}
}

public class BinarySearchTree {
	Node insert(Node root,int data) {
		if(root==null) {
			return new Node(data);
		}
		if(data<=root.data) {
			root.left=insert(root.left,data);
		}
		else {
			root.right=insert(root.right,data);
		}
		return root;
	}
	boolean search(Node root,int data) {
		if(root==null) {
			return false;
		}
		if(root.data==data){
			return true;
		}
		else if(data<root.data) {
			return search(root.left,data);
		}
		else {
			return search(root.right,data);
		}
	}
	int getMin(Node root) {
		if(root==null) {
			System.out.println("Empty tree");
			return -1;
		}
		while(root.left!=null) {
			root=root.left;
		}
		return (root.data);
	}
	int getMax(Node root) {
		if(root==null) {
			System.out.println("empty tree");
			return -1;
		}
		while(root.right!=null) {
			root=root.right;
		}
		return (root.data);
	}
	void inorder(Node root) {
		if(root==null) {
			return ;
		}
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	void preorder(Node root) {
		if(root==null) {
			return ;
		}
		System.out.println(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	void postorder(Node root) {
		if(root==null) {
			return ;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.data+" ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
