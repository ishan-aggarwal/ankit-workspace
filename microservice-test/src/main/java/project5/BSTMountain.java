package project5;

import java.util.*;

public class BSTMountain {

    private BSTNode root;   //reference to the root node of the tree 
    private Comparator<RestStop> comparator;   //comparator object to overwrite the
                                //natural ordering of the elements 


    	
	private boolean found;  //helper variable used by the remove methods
    private boolean added ; //helper variable used by the add method 

    public BSTNode getRoot() {
        return root;
    }

    /**
	 * Constructs a new, empty tree, sorted according to the natural ordering of its elements.
	 */
    public BSTMountain() {
        root = null; 
        comparator = null; 
    }

    /**
	 * Constructs a new, empty tree, sorted according to the specified comparator.
	 */
    public BSTMountain(Comparator<RestStop> comparator) {
        this.comparator = comparator;
    }


	/**
	 * Adds the specified element to this tree if it is not already present. 
	 * If this tree already contains the element, the call leaves the 
     * tree unchanged and returns false.
	 * @param data element to be added to this tree 
     * @return true if this tree did not already contain the specified element 
     * @throws NullPointerException if the specified element is null  
	 */
    public boolean add ( RestStop data ) {
        if (root == null) {
            this.root = new BSTNode(data);
            return true;
            
        } else {
            added = recAdd(data, root); 
        }

         return added; 
    }
    public boolean recAdd(RestStop data, BSTNode node) {
        if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new BSTNode(data);
                return true;
            }
            return recAdd(data, node.left);         
        } else if (data.compareTo(node.data) > 0) {
            if (node.right == null) {
                node.right = new BSTNode(data);
                return true;
            }
            return recAdd(data, node.right);
        } else 
        return false;
    }
    


    /**
	 * Removes the specified element from this tree if it is present. 
	 * Returns true if this tree contained the element (or equivalently, 
     * if this tree changed as a result of the call). 
     * (This tree will not contain the element once the call returns.)
	 * @param target object to be removed from this tree, if present
     * @return true if this set contained the specified element 
     * @throws NullPointerException if the specified element is null  
	 */
	public boolean remove(RestStop target)
	{
        //replace root with a reference to the tree after target was removed 
		root = recRemove(target, root);

		return found;
	}


	/*
	 * Actual recursive implementation of remove method: find the node to remove.
     *
	 * This function recursively finds and eventually removes the node with the target element 
     * and returns the reference to the modified tree to the caller. 
     * 
	 * @param target object to be removed from this tree, if present
     * @param node node at which the recursive call is made 
	 */
	private BSTNode recRemove(RestStop target, BSTNode node)
	{
		if (node == null)  { //value not found 
			found = false;
            return node; 
        }
        
        //decide how comparisons should be done 
        int comp = 0 ;
        /*if (comparator == null ) //use natural ordering of the elements
            comp = target.compareTo(node.data);
        else                     //use the comparator
            comp = comparator.compare(target, node.data ) ;*/

        comp = target.compareTo(node.data);
        if (comp < 0)       // target might be in a left subtree
			node.left = recRemove(target, node.left);
		else if (comp > 0)  // target might be in a right subtree 
			node.right = recRemove(target, node.right );
		else {          // target found, now remove it 
			node = removeNode(node);
			found = true;
		}
		return node;
	}

	/*
	 * Actual recursive implementation of remove method: perform the removal.
	 *
	 * @param target the item to be removed from this tree
	 * @return a reference to the node itself, or to the modified subtree
	 */
	private BSTNode removeNode(BSTNode node)
	{
		RestStop data;
		if (node.left == null)   //handle the leaf and one child node with right subtree 
			return node.right ; 
		else if (node.right  == null)  //handle one child node with left subtree 
			return node.left;
		else {                   //handle nodes with two children 
			data = getPredecessor(node.left);
			node.data = data;
			node.left = recRemove(data, node.left);
			return node;
		}
	}

	/*
	 * Returns the information held in the rightmost node of subtree
	 *
	 * @param subtree root of the subtree within which to search for the rightmost node
	 * @return returns data stored in the rightmost node of subtree
	 */
	private RestStop getPredecessor(BSTNode subtree)
	{
		if (subtree==null) //this should not happen 
            throw new NullPointerException("getPredecessor called with an empty subtree");
		BSTNode temp = subtree;
		while (temp.right  != null)
			temp = temp.right ;
		return temp.data;
	}


	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
        //TO DO: implement this method 

		return 0;
	}


    public String toStringTree( ) {
        StringBuffer sb = new StringBuffer(); 
        toStringTree(sb, root, 0);
        return sb.toString();
    }

/*    public void printRootToLeafPaths() {
        if(root == null) {
            return;
        }
        ArrayList<RestStop> path = new ArrayList<RestStop>();
        printRootToLeafPaths(root, path);
    }

    private void printRootToLeafPaths(BSTNode root, ArrayList<RestStop> path) {

	    if(root == null) return;

	    RestStop data = null;
        data = root.data;
        if(root == this.root){
	        if(!data.obstaclesMap.isEmpty() || !data.suppliesMap.containsKey("food")) return;
            path.add(data);
        } else {

            RestStop prevNode = path.get(path.size()-1);

            Map<String,Integer> resultMap = data.suppliesMap;
            for (Map.Entry<String, Integer> entry : prevNode.suppliesMap.entrySet()) {
                int value = resultMap.getOrDefault(entry.getKey(), 0);
                resultMap.put(entry.getKey(), value+entry.getValue());
            }

            if(data.obstaclesMap.isEmpty() && !data.suppliesMap.containsKey("food")){
                return;
            }else if(data.obstaclesMap.isEmpty() && data.suppliesMap.containsKey("food")){

                int val = data.suppliesMap.get("food") -1;
                data.suppliesMap.put("food", val);
            } else{
                Map<String ,String> mapString = new HashMap<>();
                mapString.put("fallen-tree", "axe");
                mapString.put("river", "raft");

                for (Map.Entry<String, Integer> entry : data.obstaclesMap.entrySet()) {
                    int value = entry.getValue();
                    String key = mapString.get(entry.getKey());
                    int suppliesVal = data.suppliesMap.getOrDefault(key,0);
                    if(suppliesVal < value) return;
                    data.suppliesMap.put(key, suppliesVal-value);
                }
            }
            path.add(data);

        }

        if(root.left == null && root.right == null) {
            if(path.size()%2 ==1)
            printList(path);
            return;
        }

        printRootToLeafPaths(root.left,new ArrayList<RestStop>(path));
        printRootToLeafPaths(root.right,new ArrayList<RestStop>(path));
    }

    private void printList(ArrayList<RestStop> path) {
        for(RestStop i: path) {
            System.out.print(i.LABEL + " ");
        }
        System.out.println();
    }*/

    //uses preorder traversal to display the tree 
    //WARNING: will not work if the data.toString returns more than one line 
    private void toStringTree( StringBuffer sb, BSTNode node, int level ) {
        //display the node 
        if (level > 0 ) {
            for (int i = 0; i < level-1; i++) {
                sb.append("   ");
            }
            sb.append("|--");
        }
        if (node == null) {
            sb.append( "->\n"); 
            return;
        }
        else {
            sb.append( node.data + "\n"); 
        }

        //display the left subtree 
        toStringTree(sb, node.left, level+1); 
        //display the right subtree 
        toStringTree(sb, node.right, level+1); 
    }


    /* 
     * Node class for this BSTMountain
     */
    class BSTNode implements Comparable < BSTNode > {

        RestStop data;
        BSTNode  left;
        BSTNode  right;

        public BSTNode ( RestStop data ) {
            this.data = data;
        }

        public BSTNode (RestStop data, BSTNode left, BSTNode right ) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int compareTo ( BSTNode other ) {
          //  if (BSTMountain.this.comparator == null )
                return this.data.compareTo ( other.data );
          /*  else
                return comparator.compare(this.data, other.data); */
        }
    }

    
}


