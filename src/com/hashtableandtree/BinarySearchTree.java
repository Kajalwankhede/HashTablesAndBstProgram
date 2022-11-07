package com.hashtableandtree;
public class BinarySearchTree<K extends  Comparable<K>>{
    public class myBinaryNode {
        public int data;
        K key;
        myBinaryNode left, right;
        public myBinaryNode(K value)
        {
            this.key = value;

            this.left =null;
            this. right = null;

        }

    }
    myBinaryNode root;
    BinarySearchTree() { root = null; }


    BinarySearchTree(K value) {
        root = new myBinaryNode( value);
    }

    void insert(K key) {     // This method mainly calls insertkey ()

        this.root = insertKey(this.root,key);
    }

    int size(){
        return  size(root); // function to return size of bst
    }
    int size(myBinaryNode root){
        if (root==null)
            return 0;
        else
            return (size(root.left)+1 +size(root.right));// compute no of nodes in tree
    }

    public myBinaryNode insertKey(myBinaryNode root, K key) {   // A recursive function to insert a new key in BST

        if (root == null) {

            root = new myBinaryNode(key);

            return root;

        }

        int compare = key.compareTo((K) root.key);

        if (compare <= 0) {
            root.left = this.insertKey(root.left, key);
        } else {
            root.right = this.insertKey(root.right, key);
        }
        return root;
    }
public  boolean searchRecursivelyNode(int data){
        return searchRecursivelyNode(data,root)!=null? true:false;
}
private myBinaryNode searchRecursivelyNode( int data,myBinaryNode root) {
    if (root == null) {
      return root;
    } else if (root.data == data) {
        return root;

    } else if (data < root.data) {
        return searchRecursivelyNode( data,root.left);
    }

    return  searchRecursivelyNode(data,root.right);
}

    public void inorderDisplay() {
        System.out.println("Binary Search Tree Program ");
        inorderRec(this.root);
    }

    public void inorderRec(myBinaryNode root)

    {

        if (root != null) {

            inorderRec(root.left);

            System.out.println(root.key+" ");

            inorderRec(root.right);

        }

    }
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(56);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(10);
        tree.insert(11);
        tree.inorderDisplay();
        System.out.println("The size of Binary search tree : "+tree.size());
        tree.inorderDisplay();
        System.out.println("Search Result: "+tree.searchRecursivelyNode(63));
    }
}
