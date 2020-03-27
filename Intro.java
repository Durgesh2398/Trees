package code;

import java.util.Queue;

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
	
	//to calculate sum of leaf nodes
	int sumLeafNodes(Node root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null&&root.right==null) {
			return root.data;
		}
		return sumLeafNodes(root.left)+sumLeafNodes(root.right);
	}
	
	//to get height of tree
	int height(Node root) {
		if(root==null) {
			return -1;
		}
		return 1+Math.max(height(root.left),height(root.right)); 
	}
	
	//print data at a given level
	void printAtLevel(Node root,int level) {
		if(root==null) {
			return ;
		}
		if(level==1) {
			System.out.print(root.data+" ");
			return ;
		}
		printAtLevel(root.left,level-1);
		printAtLevel(root.right,level-1);
	}
	
	//level wise printing
	void levelWise(Node root) {
		if(root==null) {
			return;
		}
		int h=height(root);
		for(int i=1;i<=h+1;i++) {
			printAtLevel(root,i);
			System.out.println();
		}
	}
	
	//level order traversal
	void levelOrderTraversal(Node root) {
		if(root==null) {
			return ;
		}
		Queue<Node> q = new java.util.LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.remove();
			System.out.print(temp.data+" ");
			if(temp.left!=null) {
				q.add(temp.left);
			}
			if(temp.right!=null) {
				q.add(temp.right);
			}
		}
		System.out.println();
	}
	
	//
	void levelOrderTraversal2(Node root) {
		if(root==null) {
			return;
		}
		Queue<Node> q = new java.util.LinkedList<>();
		q.add(root);
		while(true) {
			int size=q.size();
			if(size==0) {
				break;
			}
			for(int i=0;i<size;i++) {
				Node temp= q.remove();
				System.out.print(temp.data+" ");
				if(temp.left!=null) {
					q.add(temp.left);
				}
				if(temp.right!=null) {
					q.add(temp.right);
				}
			}
			System.out.println();
		}
	}
	
	//tree is identical or not
	boolean isIdentical(Node root1,Node root2) {
		if(root1==null && root2==null) {
			return true;
		}
		if(root1==null || root2==null) {
			return false;
		}
		return root1.data==root2.data&&isIdentical(root1.left,root2.left)&&isIdentical(root1.right,root2.right);
	}
	
	//tree is mirror of another tree
	boolean isMirror(Node root1,Node root2) {
		if(root1==null && root2==null) {
			return true;
		}
		if(root1==null || root2==null) {
			return false;
		}
		return root1.data==root2.data&&isMirror(root1.left,root2.right)&&isMirror(root1.right,root2.left);
	}
	
	//making of mirror tree
	Node toMirror(Node root) {
		if(root==null) {
			return null;
		}
		Node temp=root.left;
		root.left=root.right;
		root.right=temp;
		toMirror(root.left);
		toMirror(root.right);
		return root;
	}
	
	//same structure of tree
	boolean sameStructure(Node root1,Node root2) {
		if(root1==null&&root2==null) {
			return true;
		}
		if(root1==null|| root2==null) {
			return false;
		}
		return sameStructure(root1.left,root2.left)&& sameStructure(root1.right,root2.right);
	}
	
	//isomorphic
	boolean isIsomorphic(Node root1,Node root2) {
		if(root1==null&&root2==null) {
			return true;
		}
		if(root1==null|| root2==null) {
			return false;
		}
		return (isIsomorphic(root1.left,root2.left)&&isIsomorphic(root1.right,root2.right))||(isIsomorphic(root1.left,root2.right)&&isIsomorphic(root1.right,root2.left));
	}
	
	//level of tree by queue
	int heightitr(Node root) {
		if(root==null) {
			return -1;
		}
		Queue<Node> q=new java.util.LinkedList<>();
		q.add(root);
		int level =0;
		while(true) {
			int size=q.size();
			if(size==0) {
				break;
			}
			for(int i=0;i<size;i++) {
				Node temp = q.remove();
				//System.out.print(temp.data +" ");
				if(temp.left!=null) {
					q.add(temp.left);
				}
				if(temp.right!=null) {
					q.add(temp.right);
				}
			}
			level++;
		}
		return level-1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Intro ob= new Intro(2);//binary tree with root node 2
		ob.root.left=new Node(3);
		ob.root.right=new Node(5);
		ob.root.left.left=new Node(7);
		ob.root.left.right=new Node(8);
		ob.root.right.left=new Node(10);
		ob.root.right.right=new Node(12);
		ob.root.right.right.right=new Node(6);
		
		System.out.println("sum of nodes in tree");
		System.out.println(ob.TreeSum(ob.root));
		
		System.out.println("count number of nodes");
		System.out.println(ob.countNodes(ob.root));
		
		System.out.println("count leaf node");
		System.out.println(ob.leafNodes(ob.root));
		
		System.out.println("sum of leaf nodes");
		System.out.println(ob.sumLeafNodes(ob.root));
		
		System.out.println("get height of tree counting by edges");
		System.out.println(ob.height(ob.root));
		
		System.out.print("Nodes at lvel 1  :");
		ob.printAtLevel(ob.root, 1);
		System.out.println("");
		
		System.out.print("Nodes at lvel 2  :");
		ob.printAtLevel(ob.root, 2);
		System.out.println("");
		
		System.out.print("Nodes at lvel 3  :");
		ob.printAtLevel(ob.root, 3);
		System.out.println("");
		
		System.out.print("Nodes at lvel 4  :");
		ob.printAtLevel(ob.root, 4);
		System.out.println("");
		
		System.out.println("level order traversal by getting height");
		ob.levelWise(ob.root);
		
		System.out.println("level order traversal in a line by queue");
		ob.levelOrderTraversal(ob.root);
		
		System.out.println("level order traversal by queue");
		ob.levelOrderTraversal2(ob.root);
		
		Intro ob1= new Intro(2);//binary tree with root node 2
		ob1.root.left=new Node(3);
		ob1.root.right=new Node(5);
		ob1.root.left.left=new Node(7);
		ob1.root.left.right=new Node(8);
		ob1.root.right.left=new Node(10);
		ob1.root.right.right=new Node(12);
		ob1.root.right.right.right=new Node(6);
		
		System.out.println("tree is identical or not");
		System.out.println(ob.isIdentical(ob.root,ob1.root));
		
		System.out.println("tree is mirror or not");
		System.out.println(ob.isMirror(ob.root,ob1.root));
		
		Intro ob2= new Intro(2);//binary tree with root node 2
		ob2.root.right=new Node(3);
		ob2.root.left=new Node(5);
		ob2.root.right.right=new Node(7);
		ob2.root.right.left=new Node(8);
		ob2.root.left.right=new Node(10);
		ob2.root.left.left=new Node(12);
		ob2.root.left.left.left=new Node(6);
		//ob2.root.left.left.right=new Node(6);

		System.out.println("tree is mirror or not");
		System.out.println(ob.isMirror(ob.root,ob2.root));
		
		System.out.println("tree to mirror tree");
		Node temp=ob.toMirror(ob.root);
		System.out.println(temp.data+" "+temp.left.data+" "+temp.right.data);
		
		System.out.println("same structure");
		System.out.println(ob.sameStructure(ob.root,ob.root));
		
		System.out.println("isomorphic");
		System.out.println(ob.isIsomorphic(ob.root,ob2.root));
		
		System.out.println("print level of binary tree");
		System.out.println(ob.heightitr(ob.root));
		
	}

}
