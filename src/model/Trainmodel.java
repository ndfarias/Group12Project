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
@Table(name = "TRAINMODEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainmodel.findAll", query = "SELECT t FROM Trainmodel t")
    , @NamedQuery(name = "Trainmodel.findByTrainid", query = "SELECT t FROM Trainmodel t WHERE t.trainid = :trainid")
    , @NamedQuery(name = "Trainmodel.findByDeparturedate", query = "SELECT t FROM Trainmodel t WHERE t.departuredate = :departuredate")
    , @NamedQuery(name = "Trainmodel.findByTrainservice", query = "SELECT t FROM Trainmodel t WHERE t.trainservice = :trainservice")
    , @NamedQuery(name = "Trainmodel.findByTrainorigin", query = "SELECT t FROM Trainmodel t WHERE t.trainorigin = :trainorigin")
    , @NamedQuery(name = "Trainmodel.findByTraindestination", query = "SELECT t FROM Trainmodel t WHERE t.traindestination = :traindestination")
    , @NamedQuery(name = "Trainmodel.findByDeparturetime", query = "SELECT t FROM Trainmodel t WHERE t.departuretime = :departuretime")
    , @NamedQuery(name = "Trainmodel.findByArrivaltime", query = "SELECT t FROM Trainmodel t WHERE t.arrivaltime = :arrivaltime")
    , @NamedQuery(name = "Trainmodel.findBySeatcapacity", query = "SELECT t FROM Trainmodel t WHERE t.seatcapacity = :seatcapacity")
    , @NamedQuery(name = "Trainmodel.findBySeatstaken", query = "SELECT t FROM Trainmodel t WHERE t.seatstaken = :seatstaken")  
    , @NamedQuery(name = "Trainmodel.findByDateOriginDestination", query = "SELECT t FROM Trainmodel t WHERE t.departuredate = :departuredate "
            + "and t.trainorigin LIKE CONCAT('%', :trainorigin, '%') and t.traindestination LIKE CONCAT('%', :traindestination, '%')")
    })

public class Trainmodel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TRAINID")
    private Integer trainid;
    @Basic(optional = false)
    @Column(name = "DEPARTUREDATE")
    @Temporal(TemporalType.DATE)
    private Date departuredate;
    @Basic(optional = false)
    @Column(name = "TRAINSERVICE")
    private String trainservice;
    @Basic(optional = false)
    @Column(name = "TRAINORIGIN")
    private String trainorigin;
    @Basic(optional = false)
    @Column(name = "TRAINDESTINATION")
    private String traindestination;
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

    public Trainmodel() {
    }

    public Trainmodel(Integer trainid) {
        this.trainid = trainid;
    }

    public Trainmodel(Integer trainid, Date departuredate, String trainservice, String trainorigin, String traindestination, Date departuretime, Date arrivaltime, int seatcapacity) {
        this.trainid = trainid;
        this.departuredate = departuredate;
        this.trainservice = trainservice;
        this.trainorigin = trainorigin;
        this.traindestination = traindestination;
        this.departuretime = departuretime;
        this.arrivaltime = arrivaltime;
        this.seatcapacity = seatcapacity;
    }

    public Integer getTrainid() {
        return trainid;
    }

    public void setTrainid(Integer trainid) {
        this.trainid = trainid;
    }

    public Date getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(Date departuredate) {
        this.departuredate = departuredate;
    }

    public String getTrainservice() {
        return trainservice;
    }

    public void setTrainservice(String trainservice) {
        this.trainservice = trainservice;
    }

    public String getTrainorigin() {
        return trainorigin;
    }

    public void setTrainorigin(String trainorigin) {
        this.trainorigin = trainorigin;
    }

    public String getTraindestination() {
        return traindestination;
    }

    public void setTraindestination(String traindestination) {
        this.traindestination = traindestination;
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
        hash += (trainid != null ? trainid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainmodel)) {
            return false;
        }
        Trainmodel other = (Trainmodel) object;
        if ((this.trainid == null && other.trainid != null) || (this.trainid != null && !this.trainid.equals(other.trainid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Trainmodel[ trainid=" + trainid + " ]";
    }
    
}
