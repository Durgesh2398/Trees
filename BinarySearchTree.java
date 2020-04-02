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
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	void postorder(Node root) {
		if(root==null) {
			return ;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
	Node getInorderSuccessor(Node root,int val) {
		if(root==null) {
			return null;
		}
		//to store successor while we move left;
		Node inorderSuccessor = null;
		while(root!=null) {
			if(val<root.data) {
				inorderSuccessor=root;
				root=root.left;
			}
			else if(val>root.data) {
				root=root.right;
			}
			else {
				if(root.right!=null) {
					inorderSuccessor=getMinNode(root.right);
				}
				break;
			}
		}
		if(root==null) {
			return null;
		}
		return inorderSuccessor;
	}
	Node getMinNode(Node root) {
		if(root==null) {
			return null;
		}
		while(root.left!=null) {
			root=root.left;
		}
		return root;
	}
	Node deleteNode(Node root,int data) {
		if(root==null) {
			return null;
		}
		if(data<root.data) {
			root.left=deleteNode(root.left,data);
		}
		else if(data>root.data) {
			root.right=deleteNode(root.right,data);
		}
		else {
			if(root.left==null) {
				return root.right;
			}
			else if(root.right==null) {
				return root.left;
			}
			root.data=getMin(root.right);
			root.right=deleteNode(root.right,root.data);
		}
		return root;
	}
	Node bstLCA(Node root,int n1,int n2) {
		if(root==null) {
			return null;
		}
		if(n1<root.data && n2<root.data) {
			return bstLCA(root.left,n1,n2) ;
		}
		if(n1>root.data && n2>root.data) {
			return bstLCA(root.right,n1,n2) ;
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree ob=new BinarySearchTree();
		Node root=null;
		root=ob.insert(root,8);
		root=ob.insert(root,40);
		root=ob.insert(root,12);
		root=ob.insert(root,9);
		root=ob.insert(root,0);
		root=ob.insert(root,14);
		root=ob.insert(root,67);
		root=ob.insert(root,5);
		root=ob.insert(root,6);
		root=ob.insert(root,2);
		root=ob.insert(root,3);
		System.out.println(ob.getMin(root));
		System.out.println(ob.getMax(root));
		System.out.println(ob.search(root, 5));
		System.out.println(ob.search(root, 17));
		ob.inorder(root);
		System.out.println("");
		ob.preorder(root);
		System.out.println("");
		ob.postorder(root);
		System.out.println("");
		System.out.println(ob.getInorderSuccessor(root, 3).data);
		System.out.println(ob.getInorderSuccessor(root,45 ));
		ob.inorder(root);
		System.out.println("");
		root=ob.deleteNode(root,40);
		ob.inorder(root);
		System.out.println("");
		System.out.println(ob.bstLCA(root, 3, 2).data);
	}
}
