/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.controladores;

import br.edu.ifpe.garanhuns.provapc.negocio.Alternativa;
import br.edu.ifpe.garanhuns.provapc.negocio.Prova;
import br.edu.ifpe.garanhuns.provapc.negocio.Questao;
import br.edu.ifpe.garanhuns.provapc.negocio.RespostaProva;
import br.edu.ifpe.garanhuns.provapc.negocio.RespostaQuestao;
import br.edu.ifpe.garanhuns.provapc.persistencia.fabricas.FabricaRepositorio;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
    private Iterator<RespostaQuestao> itr;

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
        itr = respostaProva.recuperaQuestao().iterator();
        respostaQuestao = itr.next();

        return "ResponderQuestao.xhtml";
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
        this.respostaQuestao.setEscolhida(mapa.get(altEscolhida));
        if (itr.hasNext()) {
            respostaQuestao = itr.next();
            altEscolhida = respostaQuestao.getEscolhida().toString();
            for (Alternativa o : alternativas) {
                String convertida = o.toString();
                mapa.put(convertida, o);
                strings.add(o.toString());
            }

            // desconverter
            Object o = mapa.get("string");
        }

    }

    public List<String> getAlternativasString() {
        return strings;
    }

    public String salvarProva() {
        proximo();
        FabricaRepositorio.getFabrica().getRepositorioRespostaProva().adicionar(respostaProva);
        return "CrudProva.xhtml";
    }

}
