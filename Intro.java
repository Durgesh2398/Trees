package code;
class Node{
	int data;
	Node left,right;
	Node(int data){
		this.data=data;
		left=right=null;
	}
}

public class Intro {
	Node root;
	Intro(){
		root=null;
	}
	
	Intro(int data){
		this.root=new Node(data);
	}
	
	//sum of binary tree
	int TreeSum(Node root) {
		if(root==null) {
			return 0;
		}
		return root.data+TreeSum(root.left)+TreeSum(root.right);
	}
	
	//count number of nodes
	int countNodes(Node root) {
		if(root==null) {
			return 0;
		}
		return 1+countNodes(root.left)+countNodes(root.right);
	}
	
	//count number of leaves nodes
	int leafNodes(Node root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null&&root.right==null) {
			return 1;
		}
		return leafNodes(root.left)+leafNodes(root.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Intro ob= new Intro(2);//binary tree with root node 2
		ob.root.left=new Node(3);
		ob.root.right=new Node(5);
		ob.root.left.left=new Node(7);
		ob.root.left.right=new Node(8);
		ob.root.right.left=new Node(10);
		System.out.println(ob.TreeSum(ob.root));
		System.out.println(ob.countNodes(ob.root));
		System.out.println(ob.leafNodes(ob.root));
	}

}
