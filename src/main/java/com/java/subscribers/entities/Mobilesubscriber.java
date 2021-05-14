/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.subscribers.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
//import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Junior
 */
@Entity
@Table(name = "mobilesubscriber")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mobilesubscriber implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @NotBlank(message = "MSISDN must not be null. It is mandatory!")
    @Column(name = "msisdn")    
    private String msisdn;
    @Digits(integer=10, fraction=0, message = "CustomerIdOwner must not be null. It is mandatory")
    @Column(name = "customer_id_owner")
    private int customerIdOwner;
    @Digits(integer=10, fraction=0, message = "CustomerIdUser must not be null. It is mandatory") 
    @Column(name = "customer_id_user")
    private int customerIdUser;
    @NotBlank(message = "serviceType must not be null. It is mandatory")
    @Column(name = "service_type")    
    private String serviceType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
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
