/*
 * File: CustomException.java
 * Created: 4/18/19
 * Author: Jeffrey Killen - jkillen2@student.umuc.edu
 * Last Update: 

 * This is a custom exception class.
 * This class is used to assign custom messages to errors 
 * such as when an invalid token is detected.

 * The exception is handled in the BSTGUI class, by displaying the message value
 * to a JOptionPane
 */

//package bstproject;

public class CustomException extends Exception {
    
    //Default constructor should not be called
    public CustomException() {
        
        super("No Error Message Specified");
        
    } // end of public CustomException() { 
    
    public CustomException(String message) {
        
        super(message);
        
    } // end of public CustomException(String message) {
    
} // end of public class PostFixException extends Exception {{
