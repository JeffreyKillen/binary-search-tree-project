/*
 * File: MyFraction.java
 * Created: 4/12/19
 * Author: Jeffrey Killen - jkillen2@student.umuc.edu
 * Last Update: 4/18/19

 * This class serves as a wrapper class for a key/value pair. The value is
 * a String in the form "[0-9]+/[0-9]+" (e.g. 1/8, 16/32). The key is the numeric representation
 * of the supplied value as a double. This class implements the Comparable interface
 * for the purpose of comparing keys to other MyFraction objects while sorting.
 * This class also uses the Double.valueOf() method to assist in parsing the key
 * from the value.
 */
//package bstproject;

public class MyFraction implements Comparable {
    
    //Variables
    private double key;
    private String value;
    
    //Default Constructor
    public MyFraction() throws Exception {
        
        throw new CustomException("MyFraction default constructor called!");
        
    } // end of public MyInteger() throws Exception {
    
    public MyFraction(String inputValue) throws Exception {
        
        /*
         * This constructor creates a new MyFraction object
         * Assigns the input String to value
         * And parses the double of value
        */
        
        this.value = inputValue;
        this.parseValue();
        
    } // end of public MyInteger(String inputValue) throws Exception {
    
    //Methods
    @Override
    public int compareTo(Object o) {
        
        /*
         * This method implements the compareTo(Object o) inherited from the 
         * Comparable class. The supplied object is cast to a MyNode, who value
         * is a MyFraction object. The keys of this MyFraction, and the casted 
         * MyFraction are then compared. This method is used by the MyNode objects
         * in sorting themselves.
        */
        
        //Warning suppressed because Object o will always be a MyFraction object
        @SuppressWarnings("unchecked")
        MyNode node = (MyNode) o;
        MyFraction input = (MyFraction) node.getMyValue();
        
        //If the key of both MyFraction are equal
        if((this.key - input.key) == 0) {
            
            return 0;
        
        //If the key of this MyFraction is greater
        } else if((this.key - input.key) > 0) {
            
            return 1;
        
        //The key of this MyFraction must be smaller
        } else {
            
            return -1;
            
        } // end of if((this.key - input.key) == 0) { ... elseif/else
        
    } // end of public int compareTo(Object integer) {
    
    @Override
    public String toString() {
        
        /*
         * This method returns the value variable as a String
        */
        
        return this.value;
        
    } // end of public String toString() {
    
    private void parseValue() throws Exception {
        
        /*
         * This method sets the value of key by splitting the variable value
         * at the "/" divisor deliminitator. Getting the double value of the
         * resulting tokens, and dividing them. If a zero is in the denominator
         * an error is thrown.
        */
        
        String[] operands = this.value.split("/");
        
        if(operands.length < 2) {
            
            throw new CustomException("Not a properly formed fraction");
            
        } // end of if(operands.length < 2) {
        
        if(Double.valueOf(operands[1]) == 0) {
            
            throw new CustomException("Cannot Divide By Zero");
            
        } // end of if(Double.valueOf(operands[1]) == 0) {
        
        this.key = Double.valueOf(operands[0]) / Double.valueOf(operands[1]);
        
    } // end of private void parseValue() throws Exception {
    
} // end of public class MyFraction implements Comparable {
