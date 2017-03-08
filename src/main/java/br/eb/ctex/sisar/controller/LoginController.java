/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.eb.ctex.sisar.controller;

import br.eb.ctex.sisar.util.LCAuth;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Ralfh
 */
@Named("loginController")
@SessionScoped
public class LoginController implements Serializable {
        
    private String senha;
    private String msg;
    private String usuario;
    private String userLoggedIn;
    
    private static final long serialVersionUID = 1094801825228386363L;
    
    public LoginController() {
    }
    
    public String getSenha() {
        return senha;
    }
 
    public void setSenha(String senha) {
        this.senha = senha;
    }
 
    public String getMsg() {
        return msg;
    }
 
    public void setMsg(String msg) {
        this.msg = msg;
    }
 
    public String getUsuario() {
        return usuario;
    }
 
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String login() throws Exception {                
        FacesContext context = FacesContext.getCurrentInstance();
        String dn = LCAuth.getUid( usuario );

        if (dn != null) {
            userLoggedIn = usuario;
            context.getExternalContext().getSessionMap().put("usuarioLogado",usuario);
            return "index?faces-redirect=true";
        } else {            
            return "login?faces-redirect=true";
        }
        
    }
    
    //logout event, invalidate session
    public String logout() {    
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("usuarioLogado");
        context.getExternalContext().invalidateSession();        
        return "/login?faces-redirect=true";
    }  
    

    public String getUserLoggedIn() {
        return userLoggedIn;
    }
    
    /**
     * @param userLoggedIn the userLoggedIn to set
     */
    public void setUserLoggedIn(String userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }

}
