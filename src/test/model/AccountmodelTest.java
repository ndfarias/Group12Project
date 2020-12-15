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
 * @author Malcolm Gemmell
 */
public class AccountmodelTest {
    
    public AccountmodelTest() {
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
     * Test of getAccountid method, of class Accountmodel.
     */
    @Test
    public void testGetAccountid() {
        System.out.println("getAccountid");
        Accountmodel instance = new Accountmodel();
        Integer expResult = null;
        Integer result = instance.getAccountid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccountid method, of class Accountmodel.
     */
    @Test
    public void testSetAccountid() {
        System.out.println("setAccountid");
        Integer accountid = null;
        Accountmodel instance = new Accountmodel();
        instance.setAccountid(accountid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountname method, of class Accountmodel.
     */
    @Test
    public void testGetAccountname() {
        System.out.println("getAccountname");
        Accountmodel instance = new Accountmodel();
        String expResult = "";
        String result = instance.getAccountname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccountname method, of class Accountmodel.
     */
    @Test
    public void testSetAccountname() {
        System.out.println("setAccountname");
        String accountname = "";
        Accountmodel instance = new Accountmodel();
        instance.setAccountname(accountname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountemail method, of class Accountmodel.
     */
    @Test
    public void testGetAccountemail() {
        System.out.println("getAccountemail");
        Accountmodel instance = new Accountmodel();
        String expResult = "";
        String result = instance.getAccountemail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccountemail method, of class Accountmodel.
     */
    @Test
    public void testSetAccountemail() {
        System.out.println("setAccountemail");
        String accountemail = "";
        Accountmodel instance = new Accountmodel();
        instance.setAccountemail(accountemail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsmember method, of class Accountmodel.
     */
    @Test
    public void testGetIsmember() {
        System.out.println("getIsmember");
        Accountmodel instance = new Accountmodel();
        Boolean expResult = null;
        Boolean result = instance.getIsmember();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsmember method, of class Accountmodel.
     */
    @Test
    public void testSetIsmember() {
        System.out.println("setIsmember");
        Boolean ismember = null;
        Accountmodel instance = new Accountmodel();
        instance.setIsmember(ismember);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountpassword method, of class Accountmodel.
     */
    @Test
    public void testGetAccountpassword() {
        System.out.println("getAccountpassword");
        Accountmodel instance = new Accountmodel();
        String expResult = "";
        String result = instance.getAccountpassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccountpassword method, of class Accountmodel.
     */
    @Test
    public void testSetAccountpassword() {
        System.out.println("setAccountpassword");
        String accountpassword = "";
        Accountmodel instance = new Accountmodel();
        instance.setAccountpassword(accountpassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Accountmodel.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Accountmodel instance = new Accountmodel();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Accountmodel.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Accountmodel instance = new Accountmodel();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Accountmodel.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Accountmodel instance = new Accountmodel();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
