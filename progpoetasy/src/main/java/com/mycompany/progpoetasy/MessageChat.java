/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progpoetasy;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;

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
      for (int k=0; k != -1; k++){
       //code line from google
       id[i] = UUID.randomUUID().toString().substring(0, 8);
        Boolean textID = checkMessageID(id[i]);
        if (textID == true){
            break;
        }
      }
    String recipient;
    for (int k =0; k !=-1; k++){
        System.out.println("Enter the cellphone number for the recipient: ");
        recipient = myChat.nextLine().trim();
    
        Boolean cell= checkRecipientCell(recipient);
        if (cell == true){
            break;
        }
        else {
            System.out.println("Phone number of the recipient is not correctly formatteed or is missing international code. ");   
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
  return text.length() <= 250;
 }
 public Boolean checkMessageID (String textID){
  String messageID = textID;
  if (messageID == null){
   return false;
  }
  return messageID.length() <= 10;
 }
  public static Pattern getSAPhonePattern()  {
     return Pattern.compile("^(?:\\+27|27|0)[6-8][0-9]{8}$");
     }
  public static Boolean checkRecipientCell (String cellNo){
        //declaration of variables
    String phone = cellNo;
    
    if (phone == null){
     return false;
    }
    String cell = phone.replaceAll("[\\s\\=\\(\\)]", "");
    
    return getSAPhonePattern().matcher(cell).matches();
    }

}
