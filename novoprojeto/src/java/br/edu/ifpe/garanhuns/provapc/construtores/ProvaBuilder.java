/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.construtores;

import br.edu.ifpe.garanhuns.provapc.controladores.ControladorProva;
import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Thais
 */
@ManagedBean
@RequestScoped
public class ProvaBuilder {
    
    private long id;
    private String titulo;
    private boolean alterando = false;
    List<QuestaoBuilder> questoes = new ArrayList<>();
    //@ManagedProperty (value="#{controladorProva}")
    /*FacesContext faces = FacesContext.getCurrentInstance();
    private ControladorProva controlador = (ControladorProva) faces.getApplication().evaluateExpressionGet(faces, "#{controladorProva}", ControladorProva.class);
    
    public ProvaBuilder() {
      //controlador = (ControladorProva)((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).
                //getAttribute("controladorProva");
        Prova p = controlador.getAlterando();
        if(p!=null) {
            this.id = p.getId();
            this.titulo = p.getTitulo();
            this.alterando = true;
        }
        QuestaoBuilder questao1 = new QuestaoBuilder();
        QuestaoBuilder questao2 = new QuestaoBuilder();
        questoes.add(questao1);
        questoes.add(questao2);
    }*/
    
    public ProvaBuilder() {
        
    }

    public ProvaBuilder(Prova selected) {
        this.id = selected.getId();
        this.titulo = selected.getTitulo();
        this.alterando = true;
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

    /*public ControladorProva getControlador() {
        return controlador;
    }

    public void setControlador(ControladorProva controlador) {
        this.controlador = controlador;
    }*/

    public boolean isAlterando() {
        return alterando;
    }

    public void setAlterando(boolean alterando) {
        this.alterando = alterando;
    }

    public List<QuestaoBuilder> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<QuestaoBuilder> questoes) {
        this.questoes = questoes;
    }

    public boolean addQuestao(QuestaoBuilder e) {
        return questoes.add(e);
    }

    public boolean removeQuestao(QuestaoBuilder o) {
        return questoes.remove(o);
    }
    
    
    public Prova construir(){
        return new Prova(id,titulo);
        
    }
}
