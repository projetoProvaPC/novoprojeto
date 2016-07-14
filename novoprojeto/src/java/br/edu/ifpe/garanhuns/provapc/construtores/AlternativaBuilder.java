/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.construtores;
import br.edu.ifpe.garanhuns.provapc.negocio.Alternativa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author João Witor
 */
@ManagedBean
@SessionScoped
public class AlternativaBuilder {
     private long id;
     private String texto;
     private boolean veracidade;

    
    public AlternativaBuilder() {
    }
    
    public long getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public boolean getVeracidade() {
        return veracidade;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setVeracidade(boolean veracidade) {
        this.veracidade = veracidade;
    }
    
     public Alternativa construir(){
        return new Alternativa(id,texto, veracidade);
    }
}
