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
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedProperty;
/**
 *
 * @author Lucinaldo Melquíades Jr.
 */
@ManagedBean
@RequestScoped
public class QuestaoBuilder {
    
    private String enunciado;
    private double pontuacao;
    private int tamanhoEspaco;

    public QuestaoBuilder() {
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
        return new Questao(enunciado,pontuacao,tamanhoEspaco);
    }
    
}
