/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicol Farias
 */
public class BusmodelTest {
    
    public BusmodelTest() {
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
     * Test of getBusid method, of class Busmodel.
     */
    @Test
    public void testGetBusid() {
        System.out.println("getBusid");
        Busmodel instance = new Busmodel();
        Integer expResult = null;
        Integer result = instance.getBusid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBusid method, of class Busmodel.
     */
    @Test
    public void testSetBusid() {
        System.out.println("setBusid");
        Integer busid = null;
        Busmodel instance = new Busmodel();
        instance.setBusid(busid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeparturedate method, of class Busmodel.
     */
    @Test
    public void testGetDeparturedate() {
        System.out.println("getDeparturedate");
        Busmodel instance = new Busmodel();
        Date expResult = null;
        Date result = instance.getDeparturedate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDeparturedate method, of class Busmodel.
     */
    @Test
    public void testSetDeparturedate() {
        System.out.println("setDeparturedate");
        Date departuredate = null;
        Busmodel instance = new Busmodel();
        instance.setDeparturedate(departuredate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBusservice method, of class Busmodel.
     */
    @Test
    public void testGetBusservice() {
        System.out.println("getBusservice");
        Busmodel instance = new Busmodel();
        String expResult = "";
        String result = instance.getBusservice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBusservice method, of class Busmodel.
     */
    @Test
    public void testSetBusservice() {
        System.out.println("setBusservice");
        String busservice = "";
        Busmodel instance = new Busmodel();
        instance.setBusservice(busservice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBusorigin method, of class Busmodel.
     */
    @Test
    public void testGetBusorigin() {
        System.out.println("getBusorigin");
        Busmodel instance = new Busmodel();
        String expResult = "";
        String result = instance.getBusorigin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBusorigin method, of class Busmodel.
     */
    @Test
    public void testSetBusorigin() {
        System.out.println("setBusorigin");
        String busorigin = "";
        Busmodel instance = new Busmodel();
        instance.setBusorigin(busorigin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBusdestination method, of class Busmodel.
     */
    @Test
    public void testGetBusdestination() {
        System.out.println("getBusdestination");
        Busmodel instance = new Busmodel();
        String expResult = "";
        String result = instance.getBusdestination();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBusdestination method, of class Busmodel.
     */
    @Test
    public void testSetBusdestination() {
        System.out.println("setBusdestination");
        String busdestination = "";
        Busmodel instance = new Busmodel();
        instance.setBusdestination(busdestination);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeparturetime method, of class Busmodel.
     */
    @Test
    public void testGetDeparturetime() {
        System.out.println("getDeparturetime");
        Busmodel instance = new Busmodel();
        Date expResult = null;
        Date result = instance.getDeparturetime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDeparturetime method, of class Busmodel.
     */
    @Test
    public void testSetDeparturetime() {
        System.out.println("setDeparturetime");
        Date departuretime = null;
        Busmodel instance = new Busmodel();
        instance.setDeparturetime(departuretime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArrivaltime method, of class Busmodel.
     */
    @Test
    public void testGetArrivaltime() {
        System.out.println("getArrivaltime");
        Busmodel instance = new Busmodel();
        Date expResult = null;
        Date result = instance.getArrivaltime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArrivaltime method, of class Busmodel.
     */
    @Test
    public void testSetArrivaltime() {
        System.out.println("setArrivaltime");
        Date arrivaltime = null;
        Busmodel instance = new Busmodel();
        instance.setArrivaltime(arrivaltime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeatcapacity method, of class Busmodel.
     */
    @Test
    public void testGetSeatcapacity() {
        System.out.println("getSeatcapacity");
        Busmodel instance = new Busmodel();
        int expResult = 0;
        int result = instance.getSeatcapacity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSeatcapacity method, of class Busmodel.
     */
    @Test
    public void testSetSeatcapacity() {
        System.out.println("setSeatcapacity");
        int seatcapacity = 0;
        Busmodel instance = new Busmodel();
        instance.setSeatcapacity(seatcapacity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeatstaken method, of class Busmodel.
     */
    @Test
    public void testGetSeatstaken() {
        System.out.println("getSeatstaken");
        Busmodel instance = new Busmodel();
        Integer expResult = null;
        Integer result = instance.getSeatstaken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSeatstaken method, of class Busmodel.
     */
    @Test
    public void testSetSeatstaken() {
        System.out.println("setSeatstaken");
        Integer seatstaken = null;
        Busmodel instance = new Busmodel();
        instance.setSeatstaken(seatstaken);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Busmodel.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Busmodel instance = new Busmodel();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Busmodel.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Busmodel instance = new Busmodel();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Busmodel.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Busmodel instance = new Busmodel();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
