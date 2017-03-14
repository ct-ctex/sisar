/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.eb.ctex.sisar.controller;

import br.eb.ctex.sisar.modelo.Usuario;
import br.eb.ctex.sisar.util.LCAuth;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
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
    private String perfil;
    private Usuario userLoggedIn;
    
    private static final long serialVersionUID = 1094801825228386363L;
    
    public LoginController() {
        this.perfil = "ADMINISTRADOR";
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

    /**
     * @return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    public String login() throws Exception {                
        FacesContext context = FacesContext.getCurrentInstance();
        
        if (LCAuth.autentica(usuario,senha)) {
            
            userLoggedIn = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
            
            // consultar perfil de usuário no banco de dados
            
            return "index?faces-redirect=true";
        } else { 
            // apresenta mensagem no contexto do faces
            FacesMessage faces = new FacesMessage("Credenciais inválidas!"); 
            context.addMessage(null, faces);            

            return "login?faces-redirect=false";
        }
        
    }
    
    //logout event, invalidate session
    public String logout() {    
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().remove("usuarioLogado");
        context.getExternalContext().invalidateSession();        
        return "/login?faces-redirect=true";
    }  
    

    public Usuario getUserLoggedIn() {
        return userLoggedIn;
    }
    
    /**
     * @param userLoggedIn the userLoggedIn to set
     */
    public void setUserLoggedIn(Usuario userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }

}
