/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progpoetasy;
import static com.mycompany.progpoetasy.Progpoetasy.checkUserName;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class MessageChat {
    //Declarations
    int arraySize = 0;
    String[] id = new String[arraySize];
    String[] message= new String[arraySize];
    String[] hash= new String[arraySize];
   
    public MessageChat(int numTexts){
    arraySize = numTexts;
   }
 public void message (int arraySize){
     for (int i = 1 ; i <= arraySize; i++){
         Scanner myChat = new Scanner(System.in);
         for (int k=0; k != -1; k++){
        System.out.print("Enter a message: ");
        message[i] = myChat.nextLine().trim();
        Boolean text = checkMessage(message[i]);
        if (text == true){
            System.out.println("Message sent ");
            break;
        }
        else{
            System.out.println("Please enter a message of less than 250 characters");
        }
    }
     }
 }
 
 public Boolean checkMessage(String message){
  String text;
  text = message;
  if (text == null){
      return false;
  }
  if (text.length() > 250){
  return false;
  }
  return true;
 }
}
