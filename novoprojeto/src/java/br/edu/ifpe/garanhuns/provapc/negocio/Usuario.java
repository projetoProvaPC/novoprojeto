/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.negocio;

import br.edu.ifpe.garanhuns.provapc.persistencia.interfaces.Persistivel;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author João Witor
 */

@Entity
@Table
public class Usuario implements Persistivel<Usuario> {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String senha;
    @Column
    private int perfil;
    @Column
    private String login;
    
    public Usuario(){ 
    }

    public Usuario(String login, int perfil, String senha) {
        this.login=login;
        this.perfil=perfil;
        this.senha=senha;
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
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.perfil, other.perfil)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 81 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 81 * hash + Objects.hashCode(this.login);
        hash = 81 * hash + Objects.hashCode(this.perfil);
        hash = 81 * hash + Objects.hashCode(this.senha);
        return hash;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", Login=" + login + 
                ", Perfil=" + perfil + ", Senha="+ senha + '}';
    }

    @Override
    public void alterar(Usuario t) {
        this.setLogin(t.getLogin());
        this.setPerfil(getPerfil());
        this.setSenha(t.getSenha());
    }

    @Override
    public Usuario copiar() {
        return new Usuario(login, perfil, senha);
    }
}
