/*
 * File: Packager.java
 * Created: 4/16/19
 * Author: Jeffrey Killen - jkillen2@student.umuc.edu
 * Last Update: 4/18/19

 * This class takes the user supplied String and converts it to a stack of
 * MyNodes for use in the MyNode tree. It does this by tokenizing the input
 * String to String[]. Then a function, appropriate to the String data is called
 * recursively for each token. After all recursions are called, the function
 * checks each token for errors, places the token into a MyFraction/MyInteger,
 * places the MyFraction/MyInteger into a MyNode, and places the MyNode into a
 * MyStack. Finally, the MyStack is handed over to the tree.
 */
//package bstproject;

@SuppressWarnings("Unchecked")
public class Packager {
    
    //Variables
    private MyStack<MyNode> hopper;
    private int index = 0;
    private String[] elements;
    
    //Default Constructor
    //Do not use
    public Packager() throws Exception{
        
        throw new CustomException("Packager Default Constructor Called!");
        
    } // end of public Packager() {
    
    //Constructor
    public Packager(String userInput, String dataType) throws Exception {
        
        /*
         * This constructor splits the supplied string into tokens. Then calls
         * the recursive function for the specified data type. Finally, the stack
         * built by the recursive function is handed over to the tree.
        */
        
        //Tokenize the input string
        tokenize(userInput);
        
        hopper = new MyStack<MyNode>(elements.length);
        
        //If the chosen data type is fraction
        if(dataType == "Fraction") {
            
            packageFractions(elements[index]);
        
        //If the chosen data type is integer
        } else if(dataType == "Integer") {
            
            packageIntegers(elements[index]);
            
        } // end of if(dataType == "Fraction") { ... elseif
        
        //Hand the stack over to the tree
        MyNode.setHopper(hopper);
        
    } // end of public Packager(String userInput, String dataType) {
    
    //Methods
    public void packageFractions(String element) throws Exception {
        
        /*
         * This method is called recursively for each token generated from the
         * user input. Each token is checked for errors, and placed into a new 
         * MyFraction object. The MyFraction object is placed into a new MyNode. 
         * The MyNode is pushed to a MyStack.
        */
        
        //Check the token for input errors
        checkInputForErrors(element, "Fractions");
        
        //Create a MyFraction with value = element
        //Create a MyNode with value = MyFraction
        //Push the MyNode to a stack
        hopper.push(new MyNode<MyFraction>(new MyFraction(element)));
        
        //If there is another token, recurse
        if(++index < elements.length) {
            
            packageFractions(elements[index]);
                    
        } // end of if(index++ < elements.length) {      
        
        return;
        
    } // end of public void packageFractions(String[] input) {
    
    public void packageIntegers(String element) throws Exception {
        
        /*
         * This method is called recursively for each token generated from the
         * user input. Each token is checked for errors, and placed into a new 
         * MyInteger object. The MyInteger object is placed into a new MyNode. 
         * The MyNode is pushed to a MyStack.
        */
        
        //Check the token for input errors
        checkInputForErrors(element, "Integers");
        
        //Create a MyInteger with value = element
        //Create a MyNode with value = MyInteger
        //Push the MyNode to a stack
        hopper.push(new MyNode<MyInteger>(new MyInteger(element)));
        
        //If there is another token, recurse
        if(++index < elements.length) {
            
            packageIntegers(elements[index]);
                    
        } // end of if(index++ < elements.length) {    
        
        return;
        
    } // end of public void packageIntegers(String[] input) {
    
    private void checkInputForErrors(String element, String dataType) throws Exception{
        
        /*
         * This method checks the given string for errors. It does this
         * by matching the string to a regular expression via the matches()
         * method. If no match is found, an error is thrown.
        */
        
        //Check for a properly formed fraction
        if((element.matches("[0-9]+/[0-9]+")) && (dataType == "Fractions")) {
            
            return;
        
        //Check for an integer
        } else if((element.matches("[0-9]+")) && (dataType == "Integers")) {
            
            return;
        
        //We have an input error
        } else {

            throw new CustomException("Invalid Input: " + element);
            
        } // end of if(element.matches("[0-9]+/[0-9]+")) { ... elseif/else
        
    } // end of private void checkInputForErrors() {
    
    private void tokenize(String userInput) {
        
        /*
         * This method tokenizes the user input by splitting at the spaces
         * and sending it to an array
        */
        
        elements = userInput.split(" ");
        
    } // end of private void tokenize(String userInput) {
        
} // end of public class Packager {
