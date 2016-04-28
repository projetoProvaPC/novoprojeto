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

public class Prova {
    @GeneratedValue
    @Id
    private Long id;
    

    @OneToMany (targetEntity = Questao.class)
    List<Questao> questoes = new ArrayList<>();

    public Long getID() {
        return id;
    }

    public void setID(Long ID) {
        this.id = ID;
    }
}
