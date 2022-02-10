/*
 * File: BSTGUI.java
 * Created: 4/12/19
 * Author: Jeffrey Killen - jkillen2@student.umuc.edu
 * Last Update: 4/18/19

 * This class is the GUI for the binary search tree project. This class also
 * provides all error handling for the program.
 
 * The user enters a series of integers or fractions into the original list
 * text field. The user selects what type of data they have entered, either
 * integers or fractions, and the order in which they would like to have
 * the data sorted, ascending order, or descending order. The user then
 * presses the Perform Sort button.

 * The entered data is sent to a new Packager object along with the type of
 * data the user selected. The data is split, packaged into either a MyInteger,
 * or a MyFraction object and a key is generated. The MyInteger or MyFraction
 * is then packaged in a node that is pushed to a stack. When all data has been
 * packaged, the stack is sent to the MyNode class, where it is used to build
 * a binary search tree.

 * Then the type of traversal the user selected is determined and the
 * appropriate traversal is made, returning the ordered list of node values
 * to the sorted list text field. The MyNode is reset for the next user interaction.
 */
//package bstproject;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class BSTGUI extends JFrame {

    //Variables
    private static final int COLUMNS = 15;
    private static String sortType = "Ascending";
    private static String inputType = "Integer";
    
    //Controls
    JLabel inputList = new JLabel();
    JLabel sortedList = new JLabel();
    JTextField inputTextField = new JTextField();
    JTextField sortedTextField = new JTextField();
    JButton performSortButton = new JButton();
    JPanel sortOrder = new JPanel();
    JPanel numericType = new JPanel();
    ButtonGroup sortedButtons = new ButtonGroup();
    ButtonGroup numericButtons = new ButtonGroup();
    JRadioButton ascendingButton = new JRadioButton();
    JRadioButton descendingButton = new JRadioButton();
    JRadioButton integerButton = new JRadioButton();
    JRadioButton fractionButton = new JRadioButton();
    
    //Default Constructor
    public BSTGUI() {
        
        setParams();
        
    } // end of public BSTGUI() {
    
    private void setParams() {
        
        /*
         * This method sets the initial parameters for the UI elements
         * as well as the window and component listeners
        */

        //Frame Parameters
        setTitle("Binary Search Tree Sort");
        setLocationRelativeTo(null);
        setSize(1000,1000);

        //Listeners
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitForm();
            }
        }); // end of addWindowListener(new WindowAdapter() {

        performSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSortButtonActionPerformed(e);
            }
        }); // end of performSortButton.addActionListener(new ActionListener() {
        
        ascendingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAscending(e);
            }
        }); // end of ascendingButton.addActionListener(new ActionListener() {
        
        descendingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDescending(e);
            }
        }); // end of ascendingButton.addActionListener(new ActionListener() {
        
        integerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setInteger(e);
            }
        }); // end of ascendingButton.addActionListener(new ActionListener() {
        
        fractionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFraction(e);
            }
        }); // end of ascendingButton.addActionListener(new ActionListener() {
        
        //Layout
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.insets = new Insets(5,5,5,5);
        gridConstraints.anchor = GridBagConstraints.CENTER;
        
        sortOrder.setLayout(new GridBagLayout());
        GridBagConstraints sortConstraints = new GridBagConstraints();
        sortConstraints.insets = new Insets(5,5,5,5);
        sortConstraints.anchor = GridBagConstraints.LINE_START;
        
        numericType.setLayout(new GridBagLayout());
        GridBagConstraints numericConstraints = new GridBagConstraints();
        numericConstraints.insets = new Insets(5,5,5,5);
        numericConstraints.anchor = GridBagConstraints.LINE_START;

        //Control Parameters
        inputList.setText("Original List");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.ipady = 25;
        getContentPane().add(inputList, gridConstraints);
        
        sortedList.setText("Sorted List");
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 2;
        gridConstraints.ipady = 25;
        getContentPane().add(sortedList, gridConstraints);
        
        gridConstraints.ipady = 0;
        
        inputTextField.setText("");
        inputTextField.setColumns(COLUMNS);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 0;
        gridConstraints.weightx = 1.0;
        gridConstraints.gridwidth = 5;
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(inputTextField, gridConstraints);
        
        sortedTextField.setText("");
        sortedTextField.setEditable(false);
        sortedTextField.setColumns(COLUMNS);
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 2;
        gridConstraints.weightx = 1.0;
        gridConstraints.gridwidth = 5;
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(sortedTextField, gridConstraints);
        
        gridConstraints.weightx = 0.0;
        gridConstraints.fill = GridBagConstraints.NONE;
        
        performSortButton.setText("Perform Sort");
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 4;
        gridConstraints.gridwidth = 1;
        getContentPane().add(performSortButton, gridConstraints);
        
        gridConstraints.ipady = 0;
                
        sortedButtons.add(ascendingButton);
        sortedButtons.add(descendingButton);
        
        numericButtons.add(integerButton);
        numericButtons.add(fractionButton);
        
        ascendingButton.setText("Ascending");
        ascendingButton.setSelected(true);
        sortConstraints.gridx = 0;
        sortConstraints.gridy = 0;
        sortConstraints.gridwidth = 2;
        sortConstraints.weightx = 1.0;
        sortOrder.add(ascendingButton, sortConstraints);
        
        descendingButton.setText("Descending");
        descendingButton.setSelected(false);
        sortConstraints.gridx = 0;
        sortConstraints.gridy = 1;
        sortConstraints.gridwidth = 2;
        sortConstraints.weightx = 1.0;
        sortOrder.add(descendingButton, sortConstraints);
        
        integerButton.setText("Integer");
        integerButton.setSelected(true);
        numericConstraints.gridx = 0;
        numericConstraints.gridy = 0;
        numericConstraints.gridwidth = 2;
        numericConstraints.weightx = 1.0;
        numericType.add(integerButton, numericConstraints);
        
        fractionButton.setText("Fraction");
        descendingButton.setSelected(false);
        numericConstraints.gridx = 0;
        numericConstraints.gridy = 1;
        numericConstraints.gridwidth = 2;
        numericConstraints.weightx = 1.0;
        numericType.add(fractionButton, numericConstraints);
        
        sortOrder.setBorder(BorderFactory.createTitledBorder("Sort Order"));
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 6;
        gridConstraints.ipadx = 75;
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(sortOrder, gridConstraints);
        
        numericType.setBorder(BorderFactory.createTitledBorder("Numeric Type"));
        gridConstraints.gridx = 3;
        gridConstraints.gridy = 6;
        gridConstraints.ipadx = 100;
        gridConstraints.weightx = 1.0;
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        getContentPane().add(numericType, gridConstraints);
        
        pack();
        
    } // end of private void setParams() {
    
    private static void setAscending(ActionEvent e) {
        
        /*
         * This method changes the sortType to ascending
        */
        
        sortType = "Ascending";
        
    } // end of private static void setAscending(ActionEvent e) {
    
    private static void setDescending(ActionEvent e) {
        
        /*
         * This method changes the sortType to descending
        */
        
        sortType = "Descending";
        
    } // end of private static void setDescending(ActionEvent e) {
    
    private static void setInteger(ActionEvent e) {
        
        /*
         * This method changes the data type to integers
        */
        
        inputType = "Integer";
        
    } // end of private static void setInteger(ActionEvent e) {
    
    private static void setFraction(ActionEvent e) {
        
        /*
         * This method changes the data type to fractions
        */
        
        inputType = "Fraction";
        
    } // end of private static void setFraction(ActionEvent e) {
            
    private static void exitForm() {
        
        /*
         * This method exits the program
        */
        
        System.exit(0);
        
    } // end of private static void exitForm() {
    
    private static void reportError(String error) {
        
        /*
         * This method is called when there is an error
         * It displays a JOptionPane with the message of the error
        */
        
        JOptionPane.showMessageDialog(null, error, error, JOptionPane.INFORMATION_MESSAGE);
        
    } // end of private void reportError(String error) {
    
    private void performSortButtonActionPerformed(ActionEvent e) {
        
        /*
         * This method creates a new Packager object with the inputTextField
         * and inputType as arguments. Then, a call to the default
         * constructor of MyNode is made to catalyse the building of the
         * binary search tree.
        
         * A check is then made to discern the traveral method chosen by the user
         * and the appropriate traversal is made. The sortTextField is filled
         * in with the return value of the traversal.
        
         * The tree is then destroyed with a call to MyNode.close() to reset for
         * the next user interaction.
        
         * This method provides all error handling for the program.
        */
        
        try {
            
            //Send the user input to a new Packager
            //Build a tree from the data
            new Packager(inputTextField.getText(), inputType);
            new MyNode();
            
            //Determine the user selected traversal option
            switch(sortType) {
                
                case "Ascending": 
                    sortedTextField.setText(MyNode.inOrderTraverse(MyNode.getRoot()));
                    break;
                    
                case "Descending":
                    sortedTextField.setText(MyNode.invInOrderTraverse(MyNode.getRoot()));
                    break;
                    
            } // end of switch(sortType) {
            
        } catch (CustomException cx) {
            
            reportError(cx.getMessage());
                        
        } catch (Exception ex) {
            
            ex.printStackTrace();
            
        } finally {
            
            //Reset the tree
            MyNode.close();
            
        } // end of try/catch/finally
        
    } // end of private void performSortButtonActionPerformed(ActionEvent e) {
       
    public static void main(String[] args) {
        
        /*
         * This method is the main method of the program. It creates a new
         * BSTGUI object and sets it to visible.
        */
    
        new BSTGUI().setVisible(true);
        
    } // end of public static void main(String[] args) {
    
} // end of public class BSTGUI {
