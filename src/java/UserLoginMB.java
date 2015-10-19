/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

/**
 *
 * @author fernando
 */
@ManagedBean
@SessionScoped
public class UserLoginMB {

    private String username;
    private String password;
    private boolean logado = false;
    private Integer idPerfil;

    public boolean getLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

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

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        Usuario u = new Usuario();
        u.setEmail(username);
        u.setSenha(password);

        if (u.valida(u)) {
            loggedIn = true;
            this.logado = true;
            this.idPerfil = u.getIdPerfil();
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem-vindo", username);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro ao fazer login", "Usuário ou senha incorreto.");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }

    public void logout(ActionEvent event) throws Throwable {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.getExternalContext().invalidateSession();
    
        context.addCallbackParam("loggedIn", false);
    }
}
