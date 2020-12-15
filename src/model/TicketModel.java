/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Table;

/**
 *
 * @author Malcolm Gemmell
 */
@Table(name = "TICKET")
public class TicketModel {
    @Basic(optional = false)
    @Column(name = "ID")
    private int ticketID;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private double ticketPrice;
    @Basic(optional = false)
    @Column(name = "REFERENCECODE")
    int referenceCode;
    @Basic(optional = false)
    @Column(name = "NAME")
    String ticketName;

    public TicketModel(int ticketID, double ticketPrice, int referenceCode, String ticketName) {
        this.ticketID = ticketID;
        this.ticketPrice = ticketPrice;
        this.referenceCode = referenceCode;
        this.ticketName = ticketName;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(int referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }
    
}
