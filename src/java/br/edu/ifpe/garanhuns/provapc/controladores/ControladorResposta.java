/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.model.Alternativa;
import br.edu.ifpe.garanhuns.provapc.model.Prova;
import br.edu.ifpe.garanhuns.provapc.model.Questao;
import br.edu.ifpe.garanhuns.provapc.model.RespostaProva;
import br.edu.ifpe.garanhuns.provapc.model.RespostaQuestao;
import br.edu.ifpe.garanhuns.provapc.model.dao.FabricaRepositorios;
import br.edu.ifpe.garanhuns.provapc.model.dao.RepositorioGenerico;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Thais
 */
public class ControladorResposta {
    private Prova prova;
    List<Alternativa> alternativas = new LinkedList<>();
    List<String> strings = new LinkedList<>();

    Map<String, Alternativa> mapa = new HashMap<>();

    private final List<RespostaQuestao> respostas;
    //private final Map<Questao, RespostaQuestao> respostas;
    
    RepositorioGenerico<RespostaProva, Integer> repositorio = null;

    public ControladorResposta() {
        this.respostas = new LinkedList<>();
    }

    ControladorResposta(Prova selected) {
       this();
       //setProva(selected);
       prova = selected;
       for(Questao q: prova.getQuestoes()){
           //respostas.put(q, new RespostaQuestao(q));
           respostas.add(new RespostaQuestao(q));
       }
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
        
    }

    public List<RespostaQuestao> getRespostas() {
        return respostas;
    }
    
    public String salvar(){
        RespostaProva respostaProva = new RespostaProva(prova);
        for(RespostaQuestao q : respostas){
            respostaProva.adicionar(q);
        }
        this.repositorio = FabricaRepositorios.fabricarRepositorio(FabricaRepositorios.respostaProva, FabricaRepositorios.BD);
        repositorio.inserir(respostaProva);
        return "CrudProva.xhtml";
    }
     
    public void salvarEscolhida(ValueChangeEvent e){
      RespostaQuestao  respotaQuestao =(RespostaQuestao) e.getComponent().getValueExpression("#{respostaQuestao}").getValue(FacesContext.getCurrentInstance().getELContext());
      respotaQuestao.setEscolhida((Alternativa)e.getNewValue());
      if(e.getNewValue()!= null){
          throw new RuntimeException("VER SE NAO ESTA NULL" + e.getNewValue());
      }
    }
   
    
}
