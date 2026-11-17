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
    int counterOne;
    int counterTwo;
    int counterThree;
    int arraySize;
    String[] id;
    String[] message;
    String[] sentMessage;
    String[] storedMessage;
    String[] deletedMessage;
    String[] hash;
    String[] storedIds;
    String[] storedHashes;
    String[] storedRecipients;
    String senderCell;
   //use constructor to assign values to attributes
    public MessageChat(int numTexts){
    this.arraySize = numTexts;
    this.id = new String[arraySize];
    this.message= new String[arraySize];
    this.hash= new String[arraySize];
    this.counterOne = 0;
    this.counterTwo = 0;
    this.counterThree = 0;
    this.sentMessage= new String[counterOne];
    this.storedMessage= new String[counterTwo];
    this.deletedMessage= new String[counterThree];
    this.storedIds = new String[arraySize];
    this.storedHashes = new String[arraySize];
    this.storedRecipients = new String[arraySize];
   }
 public void setSenderCell(String senderCell){
    this.senderCell = senderCell;
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
                sentMessage[counterOne] = message[i];
                counterOne = counterOne + 1;
                }
            else if("Store".equalsIgnoreCase(status)){
            storedMessage[counterTwo] = message[i];
            storedIds[counterTwo] = id[i];
            storedHashes[counterTwo] = hash[i];
            storedRecipients[counterTwo] = recipient;
            counterTwo = counterTwo + 1;
            System.out.println("Message stored.");
            }
            else if( "Delete".equalsIgnoreCase(status)){
            deletedMessage[counterThree] = message[i];
            counterThree = counterThree + 1;
            } 
            int msgs = returnTotalMessages(i);
            System.out.println("The total number of messages entered is " +(msgs+1));
            saveMessageData("messages.json",message[i], id[i], hash[i],sentMessage[counterOne],storedMessage[counterTwo],storedMessage[counterThree]);
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
        System.out.println("Option 1) Delete message");
        System.out.println("Option 2) Send message");
        System.out.println("Option 3) Store message");
        System.out.print("Selection: ");
        
        int decision = myMessage.nextInt();
        myMessage.nextLine(); // Clear scanner buffer trailing newline

    return switch (decision) {
      case 1 -> "Delete";
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

    public static void saveMessageData(String filePath, String text, String msgId, String msgHash, String sentMsg, String storedMsg, String deletedMsg) {
        JSONObject json = new JSONObject();
        json.put("text", text);
        json.put("messageId", msgId);
        json.put("messageHash", msgHash);
        json.put("sentMsg", sentMsg);
        json.put("storedMsg", storedMsg);
        json.put("deletedMsg", deletedMsg);
      
        
        

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(json.toString(4) + "\n");
        } catch (IOException e) {
        }
    }
    public void showStoredMessagesMenu(){
    Scanner report = new Scanner(System.in);
    System.out.println("\n--- Stored Messages ---");
    System.out.println("a) Display sender and recipient of all stored");
    System.out.println("b) Display longest stored message");
    System.out.println("c) Search by Message ID");
    System.out.println("d) Search by Recipient");
    System.out.println("e) Delete by Message Hash");
    System.out.println("f) Display full report");
    System.out.print("Choose a-f: ");
    String choice = report.nextLine().trim().toLowerCase();

    switch(choice){
        case "a" -> { // SENDER AND RECIEPIENT
            if(counterTwo == 0){
              System.out.println("No stored messages.");
            } 
            else {
              for(int i = 0; i < counterTwo; i++){
                System.out.println("Sender: " + senderCell);
                System.out.println( "  Recipient: " + storedRecipients[i]);
              }
            }
            }

        case "b" -> { //LONGEST STORED MESSAGE
            if(counterTwo == 0){
             System.out.println("No stored messages.");
            } 
            else {
                String lgst = storedMessage[0];
                for(int i = 1; i < counterTwo; i++){
                  if(storedMessage[i].length() > lgst.length()){
                    lgst = storedMessage[i];
                    }
                }
            System.out.println("Longest stored message: " + lgst);
            }
            }

        case "c" -> { //SEARCHING USING ID
            System.out.print("Enter Mssage ID to search: ");
            String searchId = report.nextLine().trim();
            boolean foundId = false;
            for(int i = 0; i < counterTwo; i++){
                if(storedIds[i] != null && storedIds[i].equals(searchId)){
                System.out.println("Recipient: " + storedRecipients[i]);
                System.out.println("Message: " + storedMessage[i]);
                foundId = true;
                }
            }
            if(!foundId) System.out.println("Message ID not found.");
            }

        case "d" -> {
            // d. search by recipient
            System.out.print("Enter recipient number: ");
            String searchRec = report.nextLine().trim();
            boolean foundRec = false;
            for(int i = 0; i < counterTwo; i++){
                if(storedRecipients[i] != null && storedRecipients[i].equals(searchRec)){
                    System.out.println("Message: " + storedMessage[i]);
                    foundRec = true;
                }
            }
            if(!foundRec) System.out.println("No messages for that recipient.");
            }

        case "e" -> {
            // e. delete by hash
            System.out.print("Enter Message Hash to delete: ");
            String searchHash = report.nextLine().trim();
            boolean deleted = false;
            for(int i = 0; i < counterTwo; i++){
                if(storedHashes[i] != null && storedHashes[i].equals(searchHash)){
                    // shift everything left to close the gap
                    for(int j = i; j < counterTwo - 1; j++){
                        storedMessage[j] = storedMessage[j+1];
                        storedIds[j] = storedIds[j+1];
                        storedHashes[j] = storedHashes[j+1];
                        storedRecipients[j] = storedRecipients[j+1];
                    }
                    counterTwo--;
                    System.out.println("Message with hash " + searchHash + " deleted.");
                    deleted = true;
                    break;
                }
            }
            if(!deleted) System.out.println("Hash not found.");
            }

        case "f" -> {
            // f. full report
            if(counterTwo == 0){
                System.out.println("No stored messages.");
            } 
            else {
                for(int i = 0; i < counterTwo; i++){
                    System.out.println("--- Message " + (i+1) + " ---");
                    System.out.println("ID: " + storedIds[i]);
                    System.out.println("Hash: " + storedHashes[i]);
                    System.out.println("Sender: " + senderCell);
                    System.out.println("Recipient: " + storedRecipients[i]);
                    System.out.println("Message: " + storedMessage[i]);
                }
            }
            }
    }
}
}
