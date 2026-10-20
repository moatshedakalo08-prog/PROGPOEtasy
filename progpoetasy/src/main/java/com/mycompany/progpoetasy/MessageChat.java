/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progpoetasy;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Student
 */
public class MessageChat {
    //Declarations
    int arraySize;
    String[] id;
    String[] message;
    String[] hash;
   //use constructor to assign values to attributes
    public MessageChat(int numTexts){
    this.arraySize = numTexts;
    this.id = new String[arraySize];
    this.message= new String[arraySize];
    this.hash= new String[arraySize];
   }
    //the core funtion that also allows the process tro be looped
 public void message (){
     Scanner myChat = new Scanner(System.in); {
        for (int i = 0 ; i < arraySize; i++){
            System.out.print("Enter a message: ");
            message[i] = myChat.nextLine();
                
            if (checkMessage(message[i])){
                System.out.println("Message sent ");
                }
            else{
                System.out.println("Please enter a message of less than 250 characters");
                i--;
                continue;
                }
                
                
         //code line from google
        id[i] = UUID.randomUUID().toString().substring(0, 8);
                
        System.out.println("Enter the cellphone number for the recipient: ");
        String recipient = myChat.nextLine().trim();
                
            if (checkRecipientCell(recipient)){
                System.out.println("Phone number of the recipient is correctly formatteed ");
                }
            else {
                System.out.println("Phone number of the recipient is not correctly formatteed or is missing international code. ");
                i--;
                continue;
                }
                
        hash[i] = createMessageHash(id[i], message[i]);
                
        String status = SentMessage();
            if( "Send".equalsIgnoreCase(status)){
                printMessages(message[i]);
                }
            int msgs = returnTotalMessages(i);
            System.out.println("The total nybeer of messages entered is " +msgs);
            saveMessageData("messages.json",message[i], id[i], hash[i]);
            }    
        }
 }
 
 public Boolean checkMessage(String message){
  String text;
  text = message;
  if (text == null){
      return false;
  }
  return text.length() <= 250 && !message.isEmpty();
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
  public String createMessageHash(String id, String text) {
        String firstTwo = id.substring(0, 2);
        int placeholderIndex = 1;

        int lastWordIndex = text.lastIndexOf(' ');
        String lastOne = (lastWordIndex == -1) ? text.toUpperCase() : text.substring(lastWordIndex + 1).toUpperCase();
        
        String firstOne = text.trim().split("\\s+")[0].toUpperCase();
        
        return firstTwo + placeholderIndex + ":" + firstOne + lastOne;
    }

    public String SentMessage() {
        Scanner myMessage = new Scanner(System.in);
        System.out.println("\nSelect a feature to use:");
        System.out.println("Option 0) Delete message");
        System.out.println("Option 2) Send message");
        System.out.println("Option 3) Store message");
        System.out.print("Selection: ");
        
        int decision = myMessage.nextInt();
        myMessage.nextLine(); // Clear scanner buffer trailing newline

        return switch (decision) {
            case 0 -> "Delete";
            case 2 -> "Send";
            case 3 -> "Store";
            default -> "Unknown";
        };
    }

    public void printMessages(String message) {
        System.out.println("Message content: " + message);
    }

    public int returnTotalMessages(int i) {
        return i;
    }

    public static void saveMessageData(String filePath, String text, String msgId, String msgHash) {
        JSONObject json = new JSONObject();
        json.put("text", text);
        json.put("messageId", msgId);
        json.put("messageHash", msgHash);

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(json.toString(4) + "\n");
        } catch (IOException e) {
        }
    }
}
