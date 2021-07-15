package edu.ncsu.csc216.service_wolf.model.io;

import java.util.Arrays;
  
public class BinarySearchTree {
  
    public Node root;
  
    int[] arrayTree;
    int index = 0;  
  
    public BinarySearchTree(){
        root = null;  
    }  
  
    public Node convertBinaryTreeToBinarySearchTree(Node node) {
  
        int size = getSize(node);
        arrayTree = new int[size];
  
        convertBTtoArray(node);
  
        Arrays.sort(arrayTree);
  
        return createBinarySearchTree(0, arrayTree.length -1);
    }
  
    public void convertBTtoArray(Node node) {
        if(root == null){
            System.out.println("Empty Tree");
            return;  
        }  
        else {  
            if(node.left != null)  
                convertBTtoArray(node.left);  
            arrayTree[index] = node.data;
            index++;  
            if(node.right != null)  
                convertBTtoArray(node.right);  
            }  
        }  
  
    public Node createBinarySearchTree(int start, int end) {
  
        if (start > end) {
            return null;  
        }  
  
        int mid = (start + end) / 2;
        Node node = new Node(arrayTree[mid]);
  
        node.left = createBinarySearchTree(start, mid - 1);
  
        node.right = createBinarySearchTree(mid + 1, end);
  
        return node;  
    }

    public int getSize(Node node)
    {
        int size = 0;
        if (node == null)
            return 0;
        else {
            size = getSize(node.left) + getSize(node.right) + 1;
            return size;
        }
    }

    public void inorderTreeTraversal(Node node) {
  
        //base condition to check if tree is empty
        if(root == null){  
            System.out.println("Tree is empty");  
            return;  
           }  
        else {  
  
            if(node.left!= null)  
                inorderTreeTraversal(node.left);
            System.out.print(node.data + " ");  
            if(node.right!= null)  
                inorderTreeTraversal(node.right);
  
          }  
      }  
  
    public static void main(String[] args) {  
  
        BinarySearchTree searchTree = new BinarySearchTree();
        //Add nodes to the binary tree  
        searchTree.root = new Node(1);
        searchTree.root.left = new Node(2);
        searchTree.root.right = new Node(3);
        searchTree.root.left.left = new Node(4);
        searchTree.root.left.right = new Node(5);
        searchTree.root.right.left = new Node(6);

        //print binary tree
        System.out.println("binary tree using Inorder representation: ");
        searchTree.inorderTreeTraversal(searchTree.root);
  
        Node bst = searchTree.convertBinaryTreeToBinarySearchTree(searchTree.root);
  
        //print the calculated binary search tree
        System.out.println();
        System.out.println("Inorder representation of binary search tree: ");
        searchTree.inorderTreeTraversal(bst);
      }

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}  