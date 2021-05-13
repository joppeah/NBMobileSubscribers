/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.subscribers.pojo;

import java.io.Serializable;

/**
 *
 * @author Junior
 */
public class Message implements Serializable{
    private String msg;
    private String status;

    public Message() {
    }
    
    public Message(String msg, String status) {
        this.msg = msg;
        this.status = status;
    }
    
    

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
