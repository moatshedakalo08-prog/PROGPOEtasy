/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progpoetasy;

import java.io.ByteArrayInputStream;
import java.util.regex.Pattern;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author Student
 */
public class ProgpoetasyTest {
    
    public ProgpoetasyTest() {
    }
    @Test 
    public void testCheckUserName(){
        Boolean expected = true;
        Boolean actual;
        actual = Progpoetasy.checkUserName("kyl_1");
        assertEquals(expected, actual);
     }  
    @Test
      public void testCheckPasswordComplexity_Valid(){
        Boolean expected = true;
        Boolean actual;
        actual = Progpoetasy.checkPasswordComplexity("Ch&&sec@ke99!");
        assertEquals(expected, actual);
     }  
    @Test 
        public void testCheckPasswordComplexity_Invalid(){
        Boolean expected = false;
        Boolean actual;
        actual = Progpoetasy.checkPasswordComplexity("password");
        assertEquals(expected, actual);
    }
    @Test
    public void testCheckCellPhoneNumber_Valid(){
        Boolean expected = true;
        Boolean actual;
        actual = Progpoetasy.checkCellPhoneNumber("+27838968976");
        assertEquals(expected, actual);
    }
    @Test
    public void testCheckCellPhoneNumber_Invalid(){
        Boolean expected = false;
        Boolean actual;
        actual = Progpoetasy.checkCellPhoneNumber("08966553");
        assertEquals(expected, actual);
    }
    
    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
     @Test
    void testCheckMessage_NullInput() {
        MessageChat chat = new MessageChat(1);
        assertFalse(chat.checkMessage(null));
    }

    @Test
    void testCheckMessage_ValidLength() {
        MessageChat chat = new MessageChat(1);
        assertTrue(chat.checkMessage("Hello World"));
    }

    @Test
    void testCheckMessage_TooLong() {
        MessageChat chat = new MessageChat(1);
        String longMessage = "a".repeat(251);
        assertFalse(chat.checkMessage(longMessage));
    }
    @Test
    void testGetSAPhonePattern_NotNull() {
        Pattern pattern = MessageChat.getSAPhonePattern();
        assertNotNull(pattern);
    }

    @Test
    void testCheckRecipientCell_NullInput() {
        assertFalse(MessageChat.checkRecipientCell(null));
    }

    @Test
    void testCheckRecipientCell_ValidSouthAfricanNumber() {
        // Matches typical SA formats handled by the regex pattern
        assertTrue(MessageChat.checkRecipientCell("+27721234567"));
        assertTrue(MessageChat.checkRecipientCell("0821234567"));
    }
     @Test
    void testCreateMessageHash_ValidFormat() {
        MessageChat chat = new MessageChat(1);
        // ID: "AB123456", Text: "Hello standard text"
        // Expected components: firstTwo="AB", i=1, firstOne="HELLO", lastOne="TEXT"
        String hash = chat.createMessageHash("AB123456", "Hello standard text");
        assertEquals("AB1:HELLOTEXT", hash);
    }
     @Test
    void testSentMessage_OptionSend() {
        // Simulates user entering option '2' (Send message)
        String simulatedInput = "2\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        MessageChat chat = new MessageChat(1);
        String status = chat.SentMessage();
        assertEquals("Send", status);
    }
   
    @Test
    void testSentMessage_OptionDelete() {
        // Simulates user entering option '0' (Delete message)
        String simulatedInput = "0\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        MessageChat chat = new MessageChat(1);
        String status = chat.SentMessage();
        assertEquals("Delete", status);
    }
      @Test
    void testReturnTotalMessages() {
        MessageChat chat = new MessageChat(5);
        assertEquals(3, chat.returnTotalMessages(3));
    }
       
    
  
   
}   
