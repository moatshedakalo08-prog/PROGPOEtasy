/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progpoetasy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

    // Test Data from assignment document
    private final String recipient1 = "+27834557896";
    private final String message1 = "Did you get the cake?";
    // Flag 1: Sent

    private final String recipient2 = "+27838884567";
    private final String message2 = "Where are you? You are late! I have asked you to be on time.";
    // Flag 2: Stored

    public ProgpoetasyTest() {
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
        new java.io.File("messages.json").delete();
    }

    @Test
    public void testCheckUserName() {
        Boolean expected = true;
        Boolean actual = Progpoetasy.checkUserName("kyl_1");
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        Boolean expected = true;
        Boolean actual = Progpoetasy.checkPasswordComplexity("Ch&&sec@ke99!");
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckPasswordComplexity_Invalid() {
        Boolean expected = false;
        Boolean actual = Progpoetasy.checkPasswordComplexity("password");
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckCellPhoneNumber_Valid() {
        Boolean expected = true;
        Boolean actual = Progpoetasy.checkCellPhoneNumber("+27838968976");
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckCellPhoneNumber_Invalid() {
        Boolean expected = false;
        Boolean actual = Progpoetasy.checkCellPhoneNumber("08966553");
        assertEquals(expected, actual);
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
        assertTrue(MessageChat.checkRecipientCell("+27721234567"));
        assertTrue(MessageChat.checkRecipientCell("0821234567"));
    }

    @Test
    void testCreateMessageHash_ValidFormat() {
        MessageChat chat = new MessageChat(1);
        String hash = chat.createMessageHash("AB123456", "Hello standard text");
        assertEquals("AB1:HELLOTEXT", hash);
    }
    //JUnit testing reference from google
    @Test
    void testSentMessage_OptionSend() {
    InputStream originalIn = System.in;
    try {
        String simulatedInput = "2\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        MessageChat chat = new MessageChat(1);
        String status = chat.SentMessage();
        assertEquals("Send", status);
    } 
    finally {
        System.setIn(originalIn);
    }
}

  @Test
  void testSentMessage_OptionDelete() {
  InputStream originalIn = System.in;
   try {
        String simulatedInput = "1\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        MessageChat chat = new MessageChat(1);
        String status = chat.SentMessage();
        assertEquals("Delete", status);
    } 
    finally {
        System.setIn(originalIn);
    }
}
    @Test
    void testReturnTotalMessages() {
        MessageChat chat = new MessageChat(5);
        assertEquals(3, chat.returnTotalMessages(3));
    }

    // --- NEW UNIT TESTS USING ASSIGNMENT TEST DATA (MESSAGES 1 & 2) ---

    @Test
    void testTestData_ValidMessagesAndRecipients() {
        MessageChat chat = new MessageChat(2);

        // Test Data Message 1
        assertTrue(chat.checkMessage(message1));
        assertTrue(MessageChat.checkRecipientCell(recipient1));

        // Test Data Message 2
        assertTrue(chat.checkMessage(message2));
        assertTrue(MessageChat.checkRecipientCell(recipient2));
    }

    @Test
    void testTestData_MessageHashes() {
        MessageChat chat = new MessageChat(2);

        assertEquals("111:DIDCAKE?", chat.createMessageHash("11223344", message1));
        assertEquals("221:WHERETIME.", chat.createMessageHash("22334455", message2));
    }

    @Test
    void testPopulateArrays_TestData1And2() {
        // Simulates entering Message 1 (Send -> 2) and Message 2 (Store -> 3)
        String simulatedInput = String.join("\n",
                message1,
                recipient1,
                "2",
                message2,
                recipient2,
                "3"
        ) + "\n";

        InputStream originalIn = System.in;
        try {
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            MessageChat chat = new MessageChat(2);
            chat.setSenderCell("+27831112222");
            chat.message();

            // Assert Sent array was populated correctly with Message 1
            assertEquals(1, chat.counterOne);
            assertEquals(message1, chat.sentMessage[0]);

            // Assert Stored arrays were populated correctly with Message 2
            assertEquals(1, chat.counterTwo);
            assertEquals(message2, chat.storedMessage[0]);
            assertEquals(recipient2, chat.storedRecipients[0]);
        } finally {
            System.setIn(originalIn);
        }
    }
}