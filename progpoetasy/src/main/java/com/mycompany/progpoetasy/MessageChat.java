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
        message[i] = myChat.nextLine();
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
    hash[i] = createMessageHash(id[i], message[i]);
    String status = SentMessage();
    if( "send".equals(status)){
    printMessages(message[i]);
    }
    int msgs = returnTotalMessages(i);
    System.out.println("The total nybeer of messages entered is " +msgs);
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
  public String createMessageHash(String id, String text){
      String textID = id;
      String chat = text;
      String firstTwo;
      int i = 1;
      String lastOne;
      String firstOne;
      String result;
    firstTwo = textID.substring(0, 2);
    // google reference
    int lastWordIndex = chat.lastIndexOf(' ');
    lastOne = chat.substring(lastWordIndex + 1).toUpperCase();
    firstOne = chat.trim().split("\\s+")[0].toUpperCase();
    result = firstTwo + i + ':'+ firstOne + lastOne;
    
    return result;
  }
  public String SentMessage(){
   //declarations 
   int  decision;
   String result;
   result = null;
      Scanner myMessage = new Scanner(System.in);
       System.out.println("Select a feature to use:");
    System.out.println("Option 0) Delete message");
    System.out.println("Option 2) Send message");
    System.out.println("Option 3) Store message");
    decision = myMessage.nextInt();
    
    switch (decision){
        case 0 -> {
       result = "Delete";
        }
        case 2 -> {
        result = "Send";
        }
        case 3 -> {
         result = "Store";
        }
    }
    return result;
  }
  public void printMessages( String message){
  //Declarations
  String msg= message;
  System.out.println(msg);
  }
 public int returnTotalMessages(int i){
 int k;
 k = i;
 return k;
 }
}
