/*
 * File: MyStack.java
 * Created: 3/26/19
 * Author: Jeffrey Killen - jkillen2@student.umuc.edu
 * Last Update: 4/18/19

 * This class is a custom Stack implementation. It contains methods
 * for adding items push(), removing and returning the last item pop(),
 * viewing the last added item without removing it peek(), and checking 
 * whether the stack is empty isEmpty(). This implementation will also adjust
 * its size, up or down, as needed by doubling/halving via resizeUp() and 
 * resizeDown(). Resizing is O(n), so doubling/halving reduces need to resize
 * logarithmically for larger values of n.
 */
//package bstproject;

@SuppressWarnings("Unchecked")
public class MyStack<E> {
    
    //Variables
    private E[] stack;
    private static final int START_SIZE = 8;
    private int currentSize = START_SIZE;
    private int numberElements = 0;
    
    //Constructor
    public MyStack() {
        
        //Create a stack of default size 8
        
        stack = createStack(START_SIZE);
        
    } // end of public MyStack() {
    
    public MyStack(int size) {
        
        //Create a stack of user defined size
        
        currentSize = size;
        stack = createStack(size);
        
    } // end of public MyStack(int size) {
    
    private E[] createStack(int size) {
               
        /*
         * This method creates a new stack of the supplied size
        */
        
        //Warning suppressed because E[] always extends Object
        @SuppressWarnings("unchecked") E[] newStack = (E[]) new Object[size];

        return newStack;
        
    } // end of private E[] createStack(int size) {
    
    public void push(E element) {
        
        /*
         * This method adds the supplied element to the top of the stack
        */
        
        //Check the size of the stack
        //If it is full double its size
        if((currentSize-1 == numberElements)) {
            
            resizeUp();
            
        } // end of if((currentSize-1 == numberElements)) {
        
        stack[numberElements] = element;
        
        numberElements++;
        
    } // end of public void push(E element) {
    
    
    public E pop() throws Exception{
        
        /*
         * This method returns the last element added to the stack
         * and removes it from the stack
        */
        
        //Make sure the stack isn't empty
        if(isEmpty()) {
            
            throw new CustomException("Trying to pop a null");
            
        } // end of if(isEmpty()) {
        
        //Reference element at the top of the stack
        E itemToPop = stack[numberElements-1];
        
        //Clean up
        stack[numberElements-1] = null;
        
        numberElements--;
        
        //Check the size of the stack
        //If it is more than double the number of elements
        //Halve its size, never going lower than 8 elements
        if((currentSize > (numberElements*2)) && (currentSize > 8)) {
            
           resizeDown();
           
        } // end of if((currentSize > (numberElements*2)) && (numberElements >= 1) && (currentSize > 8)) {
       
        return itemToPop;
               
    } // end of public E pop() throws PostFixException{
    
    public E peek() throws Exception {
        
        /*
         * This method returns the element at the top of the stack
         * without removing it from the stack
        */
        
        //Check that the stack is not empty
        if(isEmpty()) {
            
            throw new CustomException("Trying to peek at a null");
            
        } // end of if(isEmpty()) {
        
        return stack[(numberElements - 1)];
        
    } // end of public E peek() throws PostFixException {
    
    public boolean isEmpty() {
        
        /*
         * This method returns true if the stack is empty
        */
        
        return numberElements == 0;
        
    } // end of public boolean isEmpty() {
    
    private void resizeUp() {
        
        /*
         * This method doubles the size of the stack
        */
        
        currentSize = currentSize*2;
        
        //Make a temporary stack and reference the current stack
        E[] temp = stack;
        
        //Create a new stack, double in size
        //stack = (E[]) new Object[currentSize*2];
        stack = createStack(currentSize);
        
        //Copy elements from temp to new stack
        for(int i = 0; i<temp.length-1; i++) {
            
            stack[i] = temp[i];
            
        } // end of for(int i = 0; i<temp.length-1; i++) {

    } // end of private void resizeUp() {
    
    private void resizeDown() {
        
        /*
         * This method halves the size of the stack
        */
        
        currentSize = currentSize/2;
        
        //Create a new stack, halved in size
        E[] temp = createStack(currentSize);    
        
        //Copy elements into new stack
        for(int i = 0; i < temp.length-1; i++) {
            
            temp[i] = stack[i];
            
        } // end of for(int i = 0; i < temp.length-1; i++) {
        
        stack = temp;
        
    } // end of private void resizeDown() {
    
    public int getSize() {
        
        /*
         * This method returns the size of the Stack
        */
        
        return numberElements;
        
    } // end of public int getSize() {
    
} // end of public class MyStack<E> {