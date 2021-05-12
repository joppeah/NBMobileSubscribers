/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.subscribers.logging;

/**
 *
 * @author Junior
 */
public class LogMessage {
    private Integer httpStatus;
    private String httpMethod;
    private String path;
    private String clientIp;
    private String javaMethod;
    private String response;

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getJavaMethod() {
        return javaMethod;
    }

    public void setJavaMethod(String javaMethod) {
        this.javaMethod = javaMethod;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * @return the httpMethod
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * @param httpMethod the httpMethod to set
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    @Override
    public String toString() {
        return "LogMessage{" + "httpStatus=" + httpStatus + ", httpMethod=" + httpMethod + ", path=" + path + ", clientIp=" + clientIp + ", javaMethod=" + javaMethod + ", response=" + response + '}';
    }

   
    
}
