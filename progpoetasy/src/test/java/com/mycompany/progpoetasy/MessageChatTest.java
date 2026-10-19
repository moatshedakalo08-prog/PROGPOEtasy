/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progpoetasy;

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
// google was used as reference on how to approach the testing unit 
public class MessageChatTest {
    private final java.io.InputStream originalSystemIn = System.in;
    public MessageChatTest() {
       
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
        System.setIn(originalSystemIn);
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


    /**
     * Test of message method, of class MessageChat.
     */
    @Test
    public void testMessage() {
        System.out.println("message");
        int arraySize = 0;
        MessageChat instance = null;
        instance.message(arraySize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessage method, of class MessageChat.
     */
    @Test
    public void testCheckMessage() {
        System.out.println("checkMessage");
        String message = "";
        MessageChat instance = null;
        Boolean expResult = null;
        Boolean result = instance.checkMessage(message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessageID method, of class MessageChat.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        String textID = "";
        MessageChat instance = null;
        Boolean expResult = null;
        Boolean result = instance.checkMessageID(textID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSAPhonePattern method, of class MessageChat.
     */
    @Test
    public void testGetSAPhonePattern() {
        System.out.println("getSAPhonePattern");
        Pattern expResult = null;
        Pattern result = MessageChat.getSAPhonePattern();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRecipientCell method, of class MessageChat.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String cellNo = "";
        Boolean expResult = null;
        Boolean result = MessageChat.checkRecipientCell(cellNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class MessageChat.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        String id = "";
        String text = "";
        MessageChat instance = null;
        String expResult = "";
        String result = instance.createMessageHash(id, text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SentMessage method, of class MessageChat.
     */
    @Test
    public void testSentMessage() {
        System.out.println("SentMessage");
        MessageChat instance = null;
        String expResult = "";
        String result = instance.SentMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMessages method, of class MessageChat.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        String message = "";
        MessageChat instance = null;
        instance.printMessages(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalMessages method, of class MessageChat.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        int i = 0;
        MessageChat instance = null;
        int expResult = 0;
        int result = instance.returnTotalMessages(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveMessageData method, of class MessageChat.
     */
    @Test
    public void testSaveMessageData() {
        System.out.println("saveMessageData");
        String filePath = "";
        String text = "";
        String msgId = "";
        String msgHash = "";
        MessageChat.saveMessageData(filePath, text, msgId, msgHash);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
