/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.infinity.vista.seguridad;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Edwin
 */

@ManagedBean
public class LoginMB {
 
     private String username;
     
    private String password;
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void login(ActionEvent event) {
    	FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        System.out.println(this.username+"-"+this.password);
        if(username != null && username.equals("admin") && password != null && password.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
            context.addMessage(null, message);
            context.getExternalContext().getFlash().setKeepMessages(true);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            context.addMessage(null, message);
        }
        
    }   
    
    public String doLogin() {
        
        
        FacesMessage message = null;
        boolean loggedIn = false;
        System.out.println(this.username+"-"+this.password);
        if(username != null && username.equals("admin") && password != null && password.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
        
        FacesContext.getCurrentInstance().addMessage(null, message);
         return loggedIn ? "home.jsf?faces-redirect=true":null;
    }   
}