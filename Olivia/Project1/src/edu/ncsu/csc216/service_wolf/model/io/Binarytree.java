package edu.ncsu.csc216.service_wolf.model.io;

public class Binarytree {
    Node root;
    public void addNode(int num) {
 
        // Create a new Node and initialize it
        Node newNode = new Node(num);
        // If there is no root this becomes root
        if (root == null) {
            root = newNode;
        } else {
            // Set root as the Node we will start
            // with as we traverse the tree
            Node focusNode = root;
            // Future parent for our new Node
            Node parent;

            while (true) {
                // root is the top parent so we initialize everything there

                parent = focusNode;

              // Check if the new node should go on the left side of the parent
                if (num < focusNode.num) {
                    // Switch focus to the left child
                    focusNode = focusNode.leftChild;
                    
                    // If the left child has no children 
                    if (focusNode == null) {
                        // then place the new node on the left of it
                        parent.leftChild = newNode;
                        return; 
                    }

                } else { // if not left this will put the node on the right 
                    focusNode = focusNode.rightChild;
 
                    // If the right child has no children
                    if (focusNode == null) {
                        // then place the new node on its right 
                        parent.rightChild = newNode;
                        return;  
                    }
                }
            }

        }

    }
    public void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {
            // Traverse the left node
            inOrderTraverseTree(focusNode.leftChild);
            // Visit the currently focused on node
            System.out.println(focusNode);
            // Traverse the right node
            inOrderTraverseTree(focusNode.rightChild);
        }
}

   
public static void main(String[] args) {

        Binarytree Tree = new Binarytree();
        Tree.addNode(1);
        Tree.addNode(3);
        Tree.addNode(5);
       
         Tree.inOrderTraverseTree(Tree.root);
            }
}

 class Node {
    int num;
    Node leftChild, rightChild;
  
    Node(int num) {

        this.num = num;  
    }

 
    

 

}
