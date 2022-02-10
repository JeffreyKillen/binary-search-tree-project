/*
 * File: MyInteger.java
 * Created: 4/12/19
 * Author: Jeffrey Killen - jkillen2@student.umuc.edu
 * Last Update: 4/18/19

 * This class serves as a wrapper class for a key/value pair. The value is
 * a String in the form "[0-9]+" (e.g. 8, 37, 54358). The key is the numeric representation
 * of the supplied value as an int. This class implements the Comparable interface
 * for the purpose of comparing keys to other MyInteger objects while sorting.
 * This class also uses the Integer.parseInt() method to assist in parsing the key
 * from the value.
 */
//package bstproject;

public class MyInteger implements Comparable {
    
    //Variables
    private int key;
    private String value;
    
    //Default Constructor
    public MyInteger() throws Exception {
        
        throw new CustomException("MyInteger default constructor called!");
        
    } // end of public MyInteger() throws Exception {
    
    public MyInteger(String inputValue) throws Exception {
        
        /*
         * This constructor creates a new MyInteger object
         * Assigns the input String to value
         * And parses the int of value
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
         * is a MyInteger object. The keys of this MyInteger, and the casted 
         * MyInteger are then compared. This method is used by the MyNode objects
         * in sorting themselves.
        */
        
        //Warning suppressed because Object o will always be a MyInteger object
        @SuppressWarnings("unchecked")
        MyNode node = (MyNode) o;
        MyInteger input = (MyInteger) node.getMyValue();
        
        //If the key of both MyIntegers are equal
        if((this.key - input.key) == 0) {
            
            return 0;
        
        //If the key of this MyInteger is greater
        } else if((this.key - input.key) > 0) {
            
            return 1;
        
        //The key of this MyInteger must be smaller
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
         * This method uses the Integer class from the Java library
         * to parse the integer value of the String value
        */
        
        //Don't reinvent the wheel
        this.key = Integer.parseInt(value);
        
    } // end of private void parseValue() throws Exception {
    
} // end of public class MyInteger implements Comparable {