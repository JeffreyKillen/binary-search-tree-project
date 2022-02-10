/*
 * File: MyNode.java
 * Created: 4/12/19
 * Author: Jeffrey Killen - jkillen2@student.umuc.edu
 * Last Update: 4/19/19

 * This class has two aspects, Tree Control, and Nodes. 

 * The nodes are instantiated with the argument constructor. Each node contains 
 * a MyFraction or MyInteger object as a value, and references to left and 
 * right child nodes.

 * The tree control uses the default constructor to catalyze the tree building
 * process using the nodes in the MyStack hopper. The rules for tree construction
 * are applied recursively by the add(node, node) method. The tree can be traversed
 * recursively either in order, or in reverse order, returning a String representing
 * the innermost values of each node, in the appropriate order. The close()
 * method resets the tree for next use.
 */
//package bstproject;

//Suppress unchecked exception warning
//Uncheck warning due to generics
@SuppressWarnings("unchecked") 
public class MyNode<E extends Comparable> {
    
    //Node Variables
    private E myValue = null;
    private MyNode left = null;   
    private MyNode right = null;
    
    //Tree Control Variables
    private static MyNode root = null;
    private static MyStack<MyNode> hopper = null;
    
    //Default Constructor
    public MyNode() throws Exception {
        
        /*
         * This default constructor is used as the catalyst for triggering
         * the creation of a new Binary Search Tree
        */
        
        buildBST();
        
    } // end of public MyNode() throws Exception {
    
    //Constructor
    public MyNode(E x) {
        
        /*
         * Create a new MyNode object with it's myValue set
         * to the supplied Object->extends Comparable
         * (i.e. a MyFraction or MyInteger object
        */
        
        this.myValue = x;
        
    } // end of public MyNode(E x) {
    
    //Methods
    public E getMyValue() {
        
        /*
         * This method returns the MyFraction/MyInteger object that is
         * stored in myValue.
        */
        
        return this.myValue;
        
    } // end of public E getMyValue() {
    
    public static MyNode getRoot() {
        
        /*
         * This method returns the root node of the tree
        */
        
        return root;
        
    } // end of public static MyNode getRoot() {
    
    public static void setHopper(MyStack<MyNode> stack) {
        
        /*
         * This method sets the static MyStack hopper to the supplied MyStack
        */
        
        hopper = stack;
        
    } // end of public void setHopper(MyStack<MyNode> stack) {
    
    public void buildBST() throws Exception {
        
        /*
         * This method builds a binary search tree out of the nodes
         * in the Stack<E> hopper using recursion
        */
        
        //Base Case
        if(hopper.isEmpty()) {
            return;
        }
        
        //Recursive Case
        add(root, hopper.pop());
        buildBST();
        
    } // end of public void buildBST(MyNode r, MyNode n) throws Exception {
    
    public MyNode createNode(E x) {
        
        /*
         * This method returns a new node with a value
         * of a generic extention of a Comparable object
        
         * For this program, this means that the new node contains
         * either a MyInteger, or a MyFraction object
        */
        
        return new MyNode(x);
        
    } // end of public MyNode createNode(E x) {
    
    public MyNode add(MyNode nextNode, MyNode hopperNode) throws Exception {
        
        /*
         * This method recursively applies the rules for building a binary
         * search tree for each node supplied. First, this method checks
         * if there is a node present at the current location on the tree. It
         * assigns the supplied node to this location if it is not, and returns
         * the node assigned to this postion.
        
         * If a node is already present, then the method is called recursively
         * on the left child of the node at this position if this node has a
         * lower key, and to the right child of the node at this position if this
         * node has a higher value.
        
         * The node returned from calling this method recursively is assigned
         * to the appropriate child (left/right) of the node that called this
         * function.
        */
        
        //If there is no node at this pointer
        //Set this node 
        if(nextNode == null) {
            
            nextNode = hopperNode;
            
            if(root == null) {
                
                root = nextNode;
                
            } // end of if(root == null) {
            
            return nextNode;
            
        } // end of if(n.myValue == null) {
        
        //If the Value of the node at this pointer is greater than or equal to
        //the supplied Value, recurse to the right
        if(hopperNode.myValue.compareTo(nextNode) >= 0){
           
           nextNode.right = add(nextNode.right, hopperNode);
           
        } // end of if(myValue.compareTo(n) >= 0){
        
        //If the Value of the node at this pointer is less than
        //the supplied Value, recurse to the left
        if(hopperNode.myValue.compareTo(nextNode) == -1) {
            
            nextNode.left = add(nextNode.left, hopperNode);
            
        } // end of if(myValue.compareTo(n) == -1) {
        
        return nextNode;
        
    } // end of public void add(MyNode n, Value x) {
    
    public static String inOrderTraverse(MyNode n) {
        
        /*
         * This method traverses the binary search tree and returns
         * the node values, as a string, in order.
        */
        
        //If there is no node, this is a deadend, go back
        if(n == null) {
            
            return "";
            
        } // end of if(n == null) {
        
        //Return the string values of this, the left child, and the right
        //child nodes in order
        return inOrderTraverse(n.left) + " " +  n.myValue.toString() + " " + inOrderTraverse(n.right);
        
    } // end of public String inOrderTraverse(MyNode n) {
    
    public static String invInOrderTraverse(MyNode n) {
        
        /*
         * This method traverses the binary search tree and returns
         * the node values, as a string, in reverse order.
        */
        
        //If there is no node, this is a deadend, go back
        if(n == null) {
            
            return "";
            
        } // end of if(n == null) {
        
        //Return the string values of this, the left child, and the right
        //child nodes in reverse order
        return invInOrderTraverse(n.right) + " " +  n.myValue.toString() + " " +  invInOrderTraverse(n.left);
        
    } // end of public String invInOrderTraverse(MyNode n) {
    
    public static void close() {
        
        /*
         * This method is used to reset the static variables for 
         * the next use of this class.
        */
        
        root = null;
        hopper = null;
        
    } // end of public static void close() {
    
} // end of public class MyNode<E extends Comparable> {
