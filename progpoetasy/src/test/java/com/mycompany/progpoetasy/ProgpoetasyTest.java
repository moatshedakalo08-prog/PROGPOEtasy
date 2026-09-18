/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progpoetasy;

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
        
     @Test 
     public void testCheckUserName(){
        Progpoetasy register = new Progpoetasy();
        Boolean expected = true;
        Boolean actual;
        actual = register.checkUserName("kyl_1");
        assertEquals(expected, actual);
     }  
      @Test public void testcheckPasswordComplexity()
      {
        Progpoetasy register = new Progpoetasy();
        Boolean expected = true;
        Boolean actual;
        actual = register.checkPasswordComplexity("Ch&&sec@ke99!");
        assertEquals(expected, actual);
     }  
      @Test public void testcheckPasswordComplexity(){
      Progpoetasy register = new Progpoetasy();
        Boolean expected = true;
        Boolean actual;
        actual = register.checkPasswordComplexity("password");
        assertEquals(expected, actual);
    }
      
    }
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

    /**
  
   
    
