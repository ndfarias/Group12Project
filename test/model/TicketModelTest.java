/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stuar
 */
public class TicketModelTest {
    
    public TicketModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTicketID method, of class TicketModel.
     */
    @Test
    public void testGetTicketID() {
        System.out.println("getTicketID");
        TicketModel instance = null;
        int expResult = 0;
        int result = instance.getTicketID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTicketID method, of class TicketModel.
     */
    @Test
    public void testSetTicketID() {
        System.out.println("setTicketID");
        int ticketID = 0;
        TicketModel instance = null;
        instance.setTicketID(ticketID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTicketPrice method, of class TicketModel.
     */
    @Test
    public void testGetTicketPrice() {
        System.out.println("getTicketPrice");
        TicketModel instance = null;
        double expResult = 0.0;
        double result = instance.getTicketPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTicketPrice method, of class TicketModel.
     */
    @Test
    public void testSetTicketPrice() {
        System.out.println("setTicketPrice");
        double ticketPrice = 0.0;
        TicketModel instance = null;
        instance.setTicketPrice(ticketPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReferenceCode method, of class TicketModel.
     */
    @Test
    public void testGetReferenceCode() {
        System.out.println("getReferenceCode");
        TicketModel instance = null;
        int expResult = 0;
        int result = instance.getReferenceCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReferenceCode method, of class TicketModel.
     */
    @Test
    public void testSetReferenceCode() {
        System.out.println("setReferenceCode");
        int referenceCode = 0;
        TicketModel instance = null;
        instance.setReferenceCode(referenceCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTicketName method, of class TicketModel.
     */
    @Test
    public void testGetTicketName() {
        System.out.println("getTicketName");
        TicketModel instance = null;
        String expResult = "";
        String result = instance.getTicketName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTicketName method, of class TicketModel.
     */
    @Test
    public void testSetTicketName() {
        System.out.println("setTicketName");
        String ticketName = "";
        TicketModel instance = null;
        instance.setTicketName(ticketName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
