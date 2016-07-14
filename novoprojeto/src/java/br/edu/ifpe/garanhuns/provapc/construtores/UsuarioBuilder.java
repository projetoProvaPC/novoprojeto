/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.construtores;

import br.edu.ifpe.garanhuns.provapc.negocio.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author João Witor
 */

@ManagedBean
@RequestScoped
public class UsuarioBuilder {
    private long id;
    private String senha;
    private int perfil;
    private String login;
    
    public UsuarioBuilder(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public Usuario construir(){
        return new Usuario(login, perfil, senha);
    }
}
