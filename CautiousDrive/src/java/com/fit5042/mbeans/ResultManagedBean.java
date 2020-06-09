/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fit5042.mbeans;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

/**
 *
 * @author csz
 */
@Named(value = "resultManagedBean")
@ApplicationScoped
public class ResultManagedBean implements Serializable {

    /**
     * Creates a new instance of ResultManagedBean
     */
    
    private String responseTime;
    private String memoryLevel;
    private String age;
    private String gender;
    private String notification;

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getMemoryLevel() {
        return memoryLevel;
    }

    public void setMemoryLevel(String memoryLevel) {
        this.memoryLevel = memoryLevel;
    }
    
    
    
    public ResultManagedBean() {
        
        
    }
    
    
    
}
