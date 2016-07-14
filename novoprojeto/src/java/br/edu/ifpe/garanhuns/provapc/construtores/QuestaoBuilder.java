/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.construtores;

import br.edu.ifpe.garanhuns.provapc.controladores.ControladorQuestao;
import br.edu.ifpe.garanhuns.provapc.negocio.Questao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author Lucinaldo Melquíades Jr.
 */
@ManagedBean
@SessionScoped
public class QuestaoBuilder {
    
    private long id;
    private String enunciado;
    private double pontuacao;
    private int tamanhoEspaco;
    FacesContext faces = FacesContext.getCurrentInstance();
    private ControladorQuestao controlador = (ControladorQuestao) faces.getApplication().evaluateExpressionGet(faces, "#{controladorQuestao}", ControladorQuestao.class);
    private boolean alterando = false;
    List<AlternativaBuilder> alternativas = new ArrayList<>();
    
    public QuestaoBuilder() {
        Questao q = controlador.getAlterando();
        if(q!=null) {
            this.id = q.getId();
            this.enunciado = q.getEnunciado();
            this.pontuacao = q.getPontuacao();
            this.alterando = true;
        }
        alternativas.add(new AlternativaBuilder());
        alternativas.add(new AlternativaBuilder());
    }

    public String getEnunciado() {
        return enunciado;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public int getTamanhoEspaco() {
        return tamanhoEspaco;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setPontuacao(double pontuaçao) {
        this.pontuacao = pontuaçao;
    }

    public void setTamanhoEspaco(int tamanhoEspaço) {
        this.tamanhoEspaco = tamanhoEspaço;
    }
    
    public Questao construir() {
        return new Questao(id,enunciado,pontuacao,tamanhoEspaco);
    }
    
    public List<AlternativaBuilder> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<AlternativaBuilder> alternativas) {
        this.alternativas = alternativas;
    }
    
    public boolean addAlternativa(AlternativaBuilder e){
        return alternativas.add(e);
    }
    
    public boolean removeAlternativa(AlternativaBuilder e){
        return alternativas.remove(e);
    }
    
}
