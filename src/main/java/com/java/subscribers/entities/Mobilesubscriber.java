/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.subscribers.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Junior
 */
@Entity
@Table(name = "mobilesubscriber")
public class Mobilesubscriber implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "msisdn")
    private String msisdn;
    @Basic(optional = false)
    @Column(name = "customer_id_owner")
    private int customerIdOwner;
    @Basic(optional = false)
    @Column(name = "customer_id_user")
    private int customerIdUser;
    @Column(name = "service_type")
    private String serviceType;
    @Basic(optional = false)
    @Column(name = "service_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date serviceStartDate;

    public Mobilesubscriber()
    {
    }

    public Mobilesubscriber(Integer id)
    {
        this.id = id;
    }

    public Mobilesubscriber(Integer id, String msisdn, int customerIdOwner, int customerIdUser, String serviceType, Date serviceStartDate)
    {
        this.id = id;
        this.msisdn = msisdn;
        this.customerIdOwner = customerIdOwner;
        this.customerIdUser = customerIdUser;
        this.serviceType = serviceType;
        this.serviceStartDate = serviceStartDate;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getMsisdn()
    {
        return msisdn;
    }

    public void setMsisdn(String msisdn)
    {
        this.msisdn = msisdn;
    }

    public int getCustomerIdOwner()
    {
        return customerIdOwner;
    }

    public void setCustomerIdOwner(int customerIdOwner)
    {
        this.customerIdOwner = customerIdOwner;
    }

    public int getCustomerIdUser()
    {
        return customerIdUser;
    }

    public void setCustomerIdUser(int customerIdUser)
    {
        this.customerIdUser = customerIdUser;
    }

    public String getServiceType()
    {
        return serviceType;
    }

    public void setServiceType(String serviceType)
    {
        this.serviceType = serviceType;
    }

    public Date getServiceStartDate()
    {
        return serviceStartDate;
    }

    public void setServiceStartDate(Date serviceStartDate)
    {
        this.serviceStartDate = serviceStartDate;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mobilesubscriber))
        {
            return false;
        }
        Mobilesubscriber other = (Mobilesubscriber) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mobilesubscriber{" + "id=" + id + ", msisdn=" + msisdn + ", customerIdOwner=" + customerIdOwner + ", customerIdUser=" + customerIdUser + ", serviceType=" + serviceType + ", serviceStartDate=" + serviceStartDate + '}';
    }

    
}
