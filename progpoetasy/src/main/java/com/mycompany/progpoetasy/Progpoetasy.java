/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progpoetasy;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Progpoetasy {

    public static void main(String[] args) {
      
    //Declarations of variables
    String name;
    String lastName;
    
    //Use a Scanner to acceptr user registration input
    Scanner myRegister = new Scanner(System.in);
    System.out.println("Enter your first name: ");
    name = myRegister.nextLine().trim();
    System.out.println("Enter your last name: ");
    lastName = myRegister.nextLine().trim();
    String regUsername;
    //Registering the a correctly formatted usename
    for (int i=0; i != -1; i++){
        System.out.print("Enter a username: ");
        regUsername = myRegister.nextLine().trim();
        Boolean regUserName = checkUserName(regUsername);
        if (regUserName == true){
            System.out.println("Username successsfully captured ");
            break;
        }
        else{
            System.out.println("Username not correctly formatted: ");
            System.out.print("Ensure that username ");
            System.out.print("contains an underscore, ");
            System.out.print("and is no more than 5 characters in length.");
        }
    }
    String regPassword;
    //registering correctly formatted password
    for (int i =0; i !=-1; i++){
         System.out.println("Enter a password: ");
        regPassword = myRegister.nextLine().trim();
    
        Boolean password = checkPasswordComplexity(regPassword);
        if (password == true){
            System.out.print("Password successfully captured ");
            break;
        }
        else {
            System.out.println("Password not correctly formatted: ");
            System.out.print("Ensure that your password: ");
            System.out.print("contains atleast 8 characters, ");
            System.out.print("a capital letter, ");
            System.out.print("a number, ");
            System.out.println("and a special character.");
        }
    }
    
    }
    //Check if username is correctly formatted
    public static Boolean checkUserName(String regUsername){
    //Declaration of variables
        String username;
        username = regUsername;
      
        
        
        // Checking if username meets the criteria
        if (username.length() >= 6){
            return false;
        }
        if (username.contains("_")) {
         return true;
        } 
        else {
          return false;
        }
    }
    
    public static Boolean checkPasswordComplexity(String regPassword){
//Declaration of variables
    String password;
    password = regPassword;
  
    //Check if password meets criteria
    if (password.length() <= 7){
     return false;
    }
    Boolean Uppercase = false;
    Boolean digit = false;
    Boolean specialChar = false;
    
    for (char c : password.toCharArray()){
    if (Character.isUpperCase(c)){
     Uppercase = true;
    }
    if (Character.isDigit(c)){
     digit = true;
    }
    if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)){
        specialChar = true;
    }
    }
    return digit && specialChar && Uppercase;
    }
}
