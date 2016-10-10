/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.provapc.negocio;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Thais
 */
@Entity
@Table
public class RespostaQuestao {

    @Id
    @GeneratedValue
    private long id;
    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Questao.class)
    private Questao questao;
    //@MapKey
   // @MapKeyClass(Alternativa.class)
   // @OneToMany(cascade = CascadeType.ALL)
   // private final Map<Alternativa,RespostaAlternativa> respostas;
    @ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Alternativa.class)
    private Alternativa escolhida;

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Alternativa getEscolhida() {
        return escolhida;
    }

    public void setEscolhida(Alternativa escolhida) {
        this.escolhida = escolhida;
    }

    public RespostaQuestao() {
       // this.respostas = new HashMap<>();
    }

    public RespostaQuestao(Questao q) {
      this();
      this.questao = q;
    
    }
    
    public double calcularPontuaçao(){
        return 1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
  
    
}
