/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Thais
 */
@Entity
@Table
public class Questao {
    
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String enunciado;
    @Column
    private double pontuaçao;
    @Column
    private int tamanhoDoEspaço;
    
    @OneToMany(targetEntity = Alternativa.class)
    List<Alternativa> Alternativa= new ArrayList<>();
    
}
            
