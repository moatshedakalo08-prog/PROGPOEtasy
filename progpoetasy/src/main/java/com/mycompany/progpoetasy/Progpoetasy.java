/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.progpoetasy;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Student
 */
public class Progpoetasy {
;

    public static void main(String[] args) {
      
    //Declarations of variables
    String name;
    String lastName;
    String regPassword = null;
    String regUsername =null;
    //Use a Scanner to acceptr user registration input
    Scanner myRegister = new Scanner(System.in);
    System.out.println("Enter your first name: ");
    name = myRegister.nextLine().trim();
    System.out.println("Enter your last name: ");
    lastName = myRegister.nextLine().trim();
    
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
    //registering correctly formatted password
    for (int i =0; i !=-1; i++){
        System.out.println("Enter a password: ");
        regPassword = myRegister.nextLine().trim();
    
        Boolean password = checkPasswordComplexity(regPassword);
        if (password == true){
            System.out.println("Password successfully captured ");
            break;
        }
        else {
            System.out.println("Password not correctly formatted: ");
            System.out.print("Ensure that your password: ");
            System.out.print("contains atleast 8 characters, ");
            System.out.print("a capital letter, ");
            System.out.print("a number, ");
            System.out.println("and a special character. ");
        }
    } 
    String phonenumber;
    for (int i =0; i !=-1; i++){
        System.out.println("Enter your cellphone number: ");
        phonenumber = myRegister.nextLine().trim();
    
        Boolean cellPhone= checkCellPhoneNumber(phonenumber);
        if (cellPhone == true){
            System.out.println("Cell phone number successfully captured ");
            break;
        }
        else {
            System.out.println("Phone number not correctly formatteed ror is missing international code. ");
           
        }
    }
    String loginUsername;
    String loginPassword;
    for (int i =0; i !=-1; i++){
        System.out.println("Enter your registered username: ");
        loginUsername = myRegister.nextLine().trim();
        System.out.println("Enter your registered password: ");
        loginPassword = myRegister.nextLine().trim();
        Boolean login = loginUser(regUsername, regPassword, loginUsername, loginPassword);
        if (login == true){
            returnLoginstatus(name, lastName);
            break;
        }
        else {
            System.out.println("Password or username is incorrect.");
            
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
     public static Pattern getSAPhonePattern()  {
     return Pattern.compile("^(?:\\+27|27|0)[6-8][0-9]{8}$");
     }
    //Phone validation structure from google
    public static Boolean checkCellPhoneNumber(String phonenumber){
        //declaration of variables
    String cell = phonenumber;
    
    if (cell == null){
     return false;
    }
    String phone = cell.replaceAll("[\\s\\=\\(\\)]", "");
    
    return getSAPhonePattern().matcher(phone).matches();
    }
    public static Boolean loginUser(String regUsername, String regPassword, String loginUsername, String loginPassword){
    //Declaration of variables
    String logUser = loginUsername;
    String regUser= regUsername;
    String logPass = loginPassword;
    String regPass = regPassword;
    Boolean password = false;
    Boolean username = false;
    
    if (logUser.equals(regUser)){
    username = true;
    }
    if (logPass.equals(regPass)){
    password = true;
    }
    return password && username;
    }
    public static void returnLoginstatus(String name, String lastName){
        //declaration of variables
        String userName = name;
        String userSurname = lastName;
        System.out.println("welcome " +userName+ " " +userSurname+ "it is great to see you again.");
    
    }
}
