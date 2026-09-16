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
    
    //Registering the a correctly formatted usename
    for (int i=0; i != -1; i++){
        Boolean regUsername = checkUserName();
        if (regUsername == true){
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
    
    }
    //Check if username is correctly formatted
    public static Boolean checkUserName(){
        //Declaration of variables
        Boolean results;
        results = true;
        String username;
        int i;
        
        Scanner myRegister = new Scanner(System.in);
        System.out.print("Enter a username: ");
        username = myRegister.nextLine().trim();
        
        // Checking if username meets the criteria
        if (username.length() >= 6){
            return false;
        }
        if (username.contains("_")){
            return true;
        }
        else {
            return false;
        }
    }
}
