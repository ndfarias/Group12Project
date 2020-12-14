/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nicol Farias
 */
@Entity
@Table(name = "BUSMODEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Busmodel.findAll", query = "SELECT b FROM Busmodel b")
    , @NamedQuery(name = "Busmodel.findByBusid", query = "SELECT b FROM Busmodel b WHERE b.busid = :busid")
    , @NamedQuery(name = "Busmodel.findByDeparturedate", query = "SELECT b FROM Busmodel b WHERE b.departuredate = :departuredate")
    , @NamedQuery(name = "Busmodel.findByBusservice", query = "SELECT b FROM Busmodel b WHERE b.busservice = :busservice")
    , @NamedQuery(name = "Busmodel.findByBusorigin", query = "SELECT b FROM Busmodel b WHERE b.busorigin = :busorigin")
    , @NamedQuery(name = "Busmodel.findByBusdestination", query = "SELECT b FROM Busmodel b WHERE b.busdestination = :busdestination")
    , @NamedQuery(name = "Busmodel.findByDeparturetime", query = "SELECT b FROM Busmodel b WHERE b.departuretime = :departuretime")
    , @NamedQuery(name = "Busmodel.findByArrivaltime", query = "SELECT b FROM Busmodel b WHERE b.arrivaltime = :arrivaltime")
    , @NamedQuery(name = "Busmodel.findBySeatcapacity", query = "SELECT b FROM Busmodel b WHERE b.seatcapacity = :seatcapacity")
    , @NamedQuery(name = "Busmodel.findBySeatstaken", query = "SELECT b FROM Busmodel b WHERE b.seatstaken = :seatstaken")
    , @NamedQuery(name = "Busmodel.findByDateOriginDestination", query = "SELECT b FROM Busmodel b WHERE b.departuredate = :departuredate "
            + "and b.busorigin LIKE CONCAT('%', :busorigin, '%') and b.busdestination LIKE CONCAT('%', :busdestination, '%')")
    })
public class Busmodel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BUSID")
    private Integer busid;
    @Basic(optional = false)
    @Column(name = "DEPARTUREDATE")
    @Temporal(TemporalType.DATE)
    private Date departuredate;
    @Basic(optional = false)
    @Column(name = "BUSSERVICE")
    private String busservice;
    @Basic(optional = false)
    @Column(name = "BUSORIGIN")
    private String busorigin;
    @Basic(optional = false)
    @Column(name = "BUSDESTINATION")
    private String busdestination;
    @Basic(optional = false)
    @Column(name = "DEPARTURETIME")
    @Temporal(TemporalType.TIME)
    private Date departuretime;
    @Basic(optional = false)
    @Column(name = "ARRIVALTIME")
    @Temporal(TemporalType.TIME)
    private Date arrivaltime;
    @Basic(optional = false)
    @Column(name = "SEATCAPACITY")
    private int seatcapacity;
    @Column(name = "SEATSTAKEN")
    private Integer seatstaken;

    public Busmodel() {
    }

    public Busmodel(Integer busid) {
        this.busid = busid;
    }

    public Busmodel(Integer busid, Date departuredate, String busservice, String busorigin, String busdestination, Date departuretime, Date arrivaltime, int seatcapacity) {
        this.busid = busid;
        this.departuredate = departuredate;
        this.busservice = busservice;
        this.busorigin = busorigin;
        this.busdestination = busdestination;
        this.departuretime = departuretime;
        this.arrivaltime = arrivaltime;
        this.seatcapacity = seatcapacity;
    }

    public Integer getBusid() {
        return busid;
    }

    public void setBusid(Integer busid) {
        this.busid = busid;
    }

    public Date getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(Date departuredate) {
        this.departuredate = departuredate;
    }

    public String getBusservice() {
        return busservice;
    }

    public void setBusservice(String busservice) {
        this.busservice = busservice;
    }

    public String getBusorigin() {
        return busorigin;
    }

    public void setBusorigin(String busorigin) {
        this.busorigin = busorigin;
    }

    public String getBusdestination() {
        return busdestination;
    }

    public void setBusdestination(String busdestination) {
        this.busdestination = busdestination;
    }

    public Date getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(Date departuretime) {
        this.departuretime = departuretime;
    }

    public Date getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(Date arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public int getSeatcapacity() {
        return seatcapacity;
    }

    public void setSeatcapacity(int seatcapacity) {
        this.seatcapacity = seatcapacity;
    }

    public Integer getSeatstaken() {
        return seatstaken;
    }

    public void setSeatstaken(Integer seatstaken) {
        this.seatstaken = seatstaken;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (busid != null ? busid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Busmodel)) {
            return false;
        }
        Busmodel other = (Busmodel) object;
        if ((this.busid == null && other.busid != null) || (this.busid != null && !this.busid.equals(other.busid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Busmodel[ busid=" + busid + " ]";
    }
    
}
