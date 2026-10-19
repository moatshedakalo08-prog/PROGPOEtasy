/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progpoetasy;

/**
 *
 * @author Student
 */
public class login {
    //Declarations
    String regUsername;
    String regPassword;
    String loginUsername;
    String loginPassword;
   public login( String usrnm, String psw, String logUsrnm, String logPsw){
   regUsername = usrnm;
   regPassword =  psw;
   loginUsername = logUsrnm;
   loginPassword = logPsw;
   }
   public Boolean loginUser(String regUsername, String regPassword, String loginUsername, String loginPassword){
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
   
   
    
}
