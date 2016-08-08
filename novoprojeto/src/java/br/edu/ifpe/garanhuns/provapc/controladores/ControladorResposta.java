/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.negocio.Questao;
import br.edu.ifpe.garanhuns.provapc.negocio.RespostaProva;
import br.edu.ifpe.garanhuns.provapc.negocio.RespostaQuestao;
import br.edu.ifpe.garanhuns.provapc.persistencia.implementacoes.RepositorioRespostaProvaBD;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thais
 */
public class ControladorResposta {
    private Prova prova;
    
    private final Map<Questao, RespostaQuestao> respostas;

    public ControladorResposta() {
        this.respostas = new HashMap<>();
        respostas.put(new Questao(), new RespostaQuestao());
    }

    ControladorResposta(Prova selected) {
       this();
       setProva(selected);
       for(Questao q: prova.getQuestoes()){
           respostas.put(q, new RespostaQuestao(q));
       }
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
        
    }

    public Map<Questao, RespostaQuestao> getRespostas() {
        return respostas;
    }
    
    public String salvar(){
        RespostaProva respostaProva = new RespostaProva(prova);
        for(RespostaQuestao q : respostas.values()){
            respostaProva.adicionar(q);
        }
       new RepositorioRespostaProvaBD().adicionar(respostaProva);
        return "CrudProva.xhtml";
    }
     
   
    
}
