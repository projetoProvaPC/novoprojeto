/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.construtores;

import br.edu.ifpe.garanhuns.provapc.controladores.ControladorProva;
import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.negocio.Questao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thais
 */
@ManagedBean
@RequestScoped
public class ProvaBuilder {
    
    private long id;
    private String titulo;
    //@ManagedProperty (value="#{controladorProva}")
    FacesContext faces = FacesContext.getCurrentInstance();
    private ControladorProva controlador = (ControladorProva) faces.getApplication().evaluateExpressionGet(faces, "#{controladorProva}", ControladorProva.class);
    private boolean alterando = false;
    
    public ProvaBuilder() {
      //controlador = (ControladorProva)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).
                //getAttribute("controladorProva");
        Prova p = controlador.getAlterando();
        if(p!=null) {
            this.id = p.getId();
            this.titulo = p.getTitulo();
            this.alterando = true;
        }
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ControladorProva getControlador() {
        return controlador;
    }

    public void setControlador(ControladorProva controlador) {
        this.controlador = controlador;
    }

    public boolean isAlterando() {
        return alterando;
    }

    public void setAlterando(boolean alterando) {
        this.alterando = alterando;
    }
    
    
    public Prova construir(){
        return new Prova(id,titulo);
    }
}
