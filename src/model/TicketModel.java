/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Malcolm Gemmell
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TicketModel.findAll", query = "SELECT t FROM TicketModel t")
    })
@Table(name = "TICKET")

public class TicketModel implements Serializable {

    @Column(name = "PRICE")
    private Double ticketPrice;
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private int ticketID;
    @Basic(optional = false)
    @Column(name = "NAME")
    String ticketName;

    public TicketModel() {
    }

    public TicketModel(int ticketID, double ticketPrice, String ticketName) {
        this.ticketID = ticketID;
        this.ticketPrice = ticketPrice;
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


    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public Double getPrice() {
        return ticketPrice;
    }

    public void setPrice(Double price) {
        this.ticketPrice = price;
    }
    
}
