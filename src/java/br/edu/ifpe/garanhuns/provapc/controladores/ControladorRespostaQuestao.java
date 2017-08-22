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
import java.util.ListIterator;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Thais
 */
@ManagedBean
@SessionScoped
public class ControladorRespostaQuestao {

    private RespostaProva respostaProva;
    private RespostaQuestao respostaQuestao;
    private String altEscolhida;
    private ListIterator<RespostaQuestao> itr;
    private String nomeAluno;
    
    RepositorioGenerico<RespostaProva, Integer> repositorio=null;

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    List<Alternativa> alternativas = new LinkedList<>();
    List<String> strings = new LinkedList<>();

    Map<String, Alternativa> mapa = new HashMap<>();

    public ControladorRespostaQuestao() {
    }

    public String responderProva(Prova prova) {
        respostaProva = new RespostaProva(prova);
        for (Questao q : prova.getQuestoes()) {
            respostaProva.adicionar(new RespostaQuestao(q));
        }
        itr = respostaProva.recuperaQuestao().listIterator();
        this.proximo();
        
        return "LoginAluno.xhtml";
        //return "ResponderQuestao.xhtml";
    }

    public RespostaProva getRespostaProva() {
        return respostaProva;
    }

    public void setRespostaProva(RespostaProva respostaProva) {
        this.respostaProva = respostaProva;
    }

    public RespostaQuestao getRespostaQuestao() {
        return respostaQuestao;
    }

    public void setRespostaQuestao(RespostaQuestao respostaQuestao) {
        this.respostaQuestao = respostaQuestao;
    }

    public String getAltEscolhida() {
        return altEscolhida;
    }

    public void setAltEscolhida(String altEscolhida) {
        this.altEscolhida = altEscolhida;
    }

    public void proximo() {
        if(this.respostaQuestao != null){
        this.respostaQuestao.setEscolhida(mapa.get(altEscolhida));
        }
        if (itr.hasNext()) {
            respostaQuestao = itr.next();
            if (respostaQuestao.getEscolhida() == null) {
                altEscolhida = null;
            } else {
                altEscolhida = respostaQuestao.getEscolhida().toString();
            }
            mapa.clear();
            strings.clear();
            for (Alternativa o : this.respostaQuestao.getQuestao().getAlternativas()) {
                String convertida = o.toString();
                mapa.put(convertida, o);
                strings.add(o.toString());
            }
        }

    }
     public boolean desativar(){
        return !itr.hasNext();
    }

    public List<String> getAlternativasString() {
        return strings;
    }
    
    public void voltar(){
        if(this.respostaQuestao != null){
        this.respostaQuestao.setEscolhida(mapa.get(altEscolhida));
        }
        if (itr.hasPrevious()) {
            respostaQuestao = itr.previous();
            if (respostaQuestao.getEscolhida() == null) {
                altEscolhida = null;
            } else {
                altEscolhida = respostaQuestao.getEscolhida().toString();
            }
            mapa.clear();
            strings.clear();
            for (Alternativa o : this.respostaQuestao.getQuestao().getAlternativas()) {
                String convertida = o.toString();
                mapa.put(convertida, o);
                strings.add(o.toString());
            }
        }
    }
    
   // public boolean isDesabilitarBotao(){
       // if(itr.hasNext()){
        //    return false;
      //  }  
      //  return true;
   // }
    
   // public String comecarProva(){
       // respostaProva.setNomeAluno(nomeAluno);
        
      //  return "RespostaQuestao.xhtml";
    //}
    public String salvarProva() {
        proximo();
        this.repositorio = FabricaRepositorios.fabricarRepositorio(FabricaRepositorios.respostaProva, FabricaRepositorios.BD);
        repositorio.inserir(respostaProva);
        return "Pontuacao.xhtml";
    }
    
    public String comecar() {
        respostaProva.setNomeAluno(nomeAluno);
        return "ResponderQuestao.xhtml";
    }

}
